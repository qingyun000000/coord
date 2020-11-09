package com.zy.coord.pool;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import com.zy.coord.client.Client;
import com.zy.coord.client.GroupClient;
import com.zy.coord.data.DataNode;
import com.zy.coord.data.GroupData;
import com.zy.coord.data.TreeDataNode;
import com.zy.coord.enums.DataFormat;
import com.zy.coord.enums.NodeEvent;
import com.zy.coord.strategy.ListenStrategyMethod;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        
        GroupData groupData = getGroupData(client);
        
        groupData.addNode(dataNode, client);
        
        return dataNode;
    }

    /**
     * 修改节点：可修改节点类型和节点值，Key值（包含树形目录的所在位置）不能修改
     * @param client
     * @param dataNode
     * @return
     * @throws NotExistException
     */
    public static DataNode updateNode(Client client, DataNode dataNode) throws NotExistException {
        //客户端校验
        verificationClient(client.getGroup(), client.getToken());
        
        GroupData groupData = getGroupData(client);
        
        groupData.updateDataNode(dataNode, client);
        
        return dataNode;
    }

    public static DataNode deleteNode(Client client, DataNode dataNode) throws NotExistException {
        //客户端校验
        verificationClient(client.getGroup(), client.getToken());
        
        GroupData groupData = getGroupData(client);
        
        groupData.deleteDataNode(dataNode, client);
        
        return dataNode;
    }

    public static DataNode listenNode(Client client, DataNode dataNode, List<NodeEvent> events) throws NotExistException {
        //客户端校验
        verificationClient(client.getGroup(), client.getToken());
        
        GroupData groupData = getGroupData(client);
        
        groupData.listenDataNode(dataNode, client, events);
        
        return dataNode;
    }

    public static DataNode getNode(Client client, String nodeKey) throws NotExistException {
        //客户端校验
        verificationClient(client.getGroup(), client.getToken());
        
        GroupData groupData = getGroupData(client);
        
        DataNode node = groupData.getNode(nodeKey, client);
        
        return node;
    }

    /**
     * 获取主数据
     * @param client
     * @return 
     */
    private static GroupData getGroupData(Client client) {
        //获取组数据
        if(!data.containsKey(client.getGroup())){
            GroupData groupData = new GroupData();
            groupData.setListenMethod(() ->listenCallback());
            data.put(client.getGroup(), groupData);
        }
        GroupData groupData = data.get(client.getGroup());
        return groupData;
    }

    /**
     * 回调方法
     */
    private static void listenCallback() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Map<String, GroupClient> getClients() {
        return clients;
    }

}
