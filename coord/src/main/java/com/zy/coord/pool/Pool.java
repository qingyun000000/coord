package com.zy.coord.pool;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import cn.whl.commonutils.log.LoggerUtils;
import cn.whl.commonutils.token.SimpleLongToken;
import cn.whl.commonutils.token.TokenUtils;
import com.zy.coord.client.Client;
import com.zy.coord.client.GroupClient;
import com.zy.coord.data.DataNode;
import com.zy.coord.data.GroupData;
import com.zy.coord.data.TreeDataNode;
import com.zy.coord.enums.DataFormat;
import com.zy.coord.set.CoordSet;
import com.zy.coord.vo.RegistRequest;
import com.zy.coord.vo.RegistResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 客户端和数据池
 * @author wuhailong
 */
public class Pool {
    
    /**
     * 数据格式
     */
    private static volatile DataFormat dataFormat;
    
    /**
     * 组客户端
     */
    private static volatile Map<String, GroupClient> clients = new HashMap<>();
    
    /**
     * 组数据
     */
    private static volatile Map<String, GroupData> data = new HashMap<>();

    public static DataFormat getDataFormat() {
        return dataFormat;
    }

    public static void setDataFormat(DataFormat dataFormat) {
        Pool.dataFormat = dataFormat;
    }
    
    public static Client registClient(Client client) throws ExistException {
        if(!clients.containsKey(client.getGroup())){
            clients.put(client.getGroup(), new GroupClient());
        }
        GroupClient groupClient = clients.get(client.getGroup());
        
        return groupClient.addClient(client);
    }

    public static void heartbeat(Client client) throws NotExistException {
        GroupClient groupClient = clients.get(client.getGroup());
        if(groupClient == null){
            throw new NotExistException("客户组");
        }
        groupClient.heartbeat(client.getToken());
    }
    
    private static void verificationClient(String group, String token) throws NotExistException {
        GroupClient groupClient = clients.get(group);
        
        if(groupClient == null){
            throw new NotExistException("客户组");
        }
        
        boolean verToken = groupClient.verToken(token);
        
        if(verToken){
            throw new NotExistException("客户端");
        }
    }
    
    public static DataNode createNode(Client client, DataNode dataNode) throws NotExistException, ExistException{
        //客户端校验
        verificationClient(client.getGroup(), client.getToken());
        
        //获取组数据
        if(!data.containsKey(client.getGroup())){
            data.put(client.getGroup(), new GroupData());
        }
        GroupData groupData = data.get(client.getGroup());
        
        if(dataFormat == DataFormat.KEY_VALUE){
            groupData.addKeyValueNode(dataNode);
        }else{
            TreeDataNode node = new TreeDataNode();
            node.setNodeType(dataNode.getNodeType());
            
            int index = dataNode.getNodeKey().lastIndexOf("/");
            
            if(index == 1){
                node.setParent(new TreeDataNode());
            }else{
                TreeDataNode treeNode = (TreeDataNode) groupData.getNode(dataNode.getNodeKey().substring(0, index));
                if(treeNode == null){
                    throw new NotExistException("父节点");
                }
                node.setParent(treeNode);
            }
            
            node.setNodeKey(dataNode.getNodeKey());
            node.setNodeValue(dataNode.getNodeValue());
            groupData.addTreeNode(node);
        }
        
        return dataNode;
    }

}
