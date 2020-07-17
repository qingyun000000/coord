package com.zy.coord.data;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import com.zy.coord.client.Client;
import com.zy.coord.enums.DataFormat;
import com.zy.coord.enums.NodeEvent;
import com.zy.coord.enums.NodePower;
import com.zy.coord.pool.Pool;
import com.zy.coord.strategy.ListenStrategyMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 组数据
 * @author wuhailong
 */
public class GroupData {
    
    //节点数据
    private Map<String, DataNode> nodes = new HashMap<>();
    
    //节点权限
    private Map<String, Map<NodePower, DataNodePower>> powers = new HashMap<>();
    
    //监听列表
    private Map<String, Map<NodeEvent, List<String>>> listens = new HashMap<>();
    
    //监听回调策略
    private ListenStrategyMethod listenMethod;
    
    //节点修改锁
    private Lock nodeUpdateLock = new ReentrantLock();

    public void setListenMethod(ListenStrategyMethod listenMethod) {
        this.listenMethod = listenMethod;
    }
    
    /**
     * 新增数据节点
     * @param node
     * @param client
     * @throws ExistException
     * @throws NotExistException
     */
    public void addNode(DataNode node, Client client) throws ExistException, NotExistException {
        if(Pool.getDataFormat() == DataFormat.TREE_NODE){
            nodeUpdateLock.lock();
            try {
                //存在性校验
                if(nodes.containsKey(node.getNodeKey())){
                    throw new ExistException("数据节点Key值");
                }

                nodes.put(node.getNodeKey(), node);
            } finally {
                nodeUpdateLock.unlock();
            }
        }else{
            TreeDataNode treeNode = new TreeDataNode();
            treeNode.setNodeType(node.getNodeType());
            treeNode.setNodeKey(node.getNodeKey());
            treeNode.setNodeValue(node.getNodeValue());
            addTreeNode(treeNode, client);
        }
    }
    
    /**
     * 新增树形数据节点
     * @param node
     * @param client
     * @throws ExistException
     * @throws NotExistException
     */
    private void addTreeNode(TreeDataNode node, Client client) throws ExistException, NotExistException {
        node.setNodeKey(node.getNodeKey().replaceAll("/", "_"));
        nodeUpdateLock.lock();
        try {
            if(nodes.containsKey(node.getNodeKey())){
                throw new ExistException("数据节点Key值");
            }
            
            int index = node.getNodeKey().lastIndexOf("_");
            if(index == 0){
                node.setParent(new TreeDataNode());
            }else{
                TreeDataNode treeNode = (TreeDataNode) nodes.get(node.getNodeKey().substring(0, index));
                if(treeNode == null){
                    throw new NotExistException("父节点");
                }
                treeNode.getChildren().add(node);
                node.setParent(treeNode);
            }
            
            nodes.put(node.getNodeKey(), node);
            
        } finally {
            nodeUpdateLock.unlock();
        }
    }
    
    /**
     * 修改数据节点（类型和值）
     * @param node
     * @param client
     * @throws NotExistException
     */
    public void updateDataNode(DataNode node, Client client) throws NotExistException {
        if(Pool.getDataFormat() == DataFormat.TREE_NODE){
            node.setNodeKey(node.getNodeKey().replaceAll("/", "_"));
        }
            
        nodeUpdateLock.lock();
        try {
            //存在性校验
            if (!nodes.containsKey(node.getNodeKey())) {
                throw new NotExistException("数据节点");
            }

            DataNode get = nodes.get(node.getNodeKey());
            get.setNodeType(node.getNodeType());
            get.setNodeValue(node.getNodeValue());
        } finally {
            nodeUpdateLock.unlock();
        }
    }
    
    /**
     * 删除数据节点
     * @param node
     * @param client
     * @throws NotExistException
     */
    public void deleteDataNode(DataNode node, Client client) throws NotExistException {
        if(Pool.getDataFormat() == DataFormat.TREE_NODE){
            node.setNodeKey(node.getNodeKey().replaceAll("/", "_"));
        }
            
        nodeUpdateLock.lock();
        try {
            //存在性校验
            if (!nodes.containsKey(node.getNodeKey())) {
                throw new NotExistException("数据节点");
            }

            nodes.remove(node.getNodeKey());
        } finally {
            nodeUpdateLock.unlock();
        }
    }
    
    /**
     * 监听数据节点
     * @param dataNode
     * @param client
     * @param events
     */
    public void listenDataNode(DataNode dataNode, Client client, List<NodeEvent> events) throws NotExistException {
        DataNode node = getNode(dataNode.getNodeKey(), client);
        if(node == null){
            throw new NotExistException("数据节点");
        }
        
        if(!listens.containsKey(node.getNodeKey())){
            listens.put(node.getNodeKey(), new HashMap<>());
        }
        Map<NodeEvent, List<String>> getMap = listens.get(node.getNodeKey());
        
        for(NodeEvent event : events){
            if(!getMap.containsKey(event)){
                getMap.put(event, new ArrayList<>());
            }
            List<String> clients = getMap.get(event);
            
            if(!clients.contains(client.getToken())){
                clients.add(client.getToken());
            }
        }
        
    }
    
    private void listenCallback(){
        listenMethod.run();
    }
    
    
    /**
     * 获取数据节点
     * @param nodeKey
     * @param client
     * @return
     */
    public DataNode getNode(String nodeKey, Client client) {
        if(Pool.getDataFormat() == DataFormat.KEY_VALUE){
            return nodes.get(nodeKey);
        }else{
            String treeNodeKey = nodeKey.replaceAll("/", "_");
            TreeDataNode treeNode = getTreeNode(treeNodeKey, client);
            DataNode node = new DataNode();
            node.setNodeType(treeNode.getNodeType());
            node.setNodeKey(nodeKey);
            node.setNodeValue(treeNode.getNodeValue());
            return node;
        }
    }

    /**
     * 获取树形数据节点
     * @param nodeKey
     * @param client
     * @return 
     */
    private TreeDataNode getTreeNode(String nodeKey, Client client) {
        TreeDataNode node = (TreeDataNode) nodes.get(nodeKey);
        return node;
    }

    

    
}
