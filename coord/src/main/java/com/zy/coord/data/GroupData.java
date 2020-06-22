package com.zy.coord.data;

import cn.whl.commonutils.exception.ExistException;
import com.zy.coord.enums.DataFormat;
import com.zy.coord.enums.NodePower;
import com.zy.coord.pool.Pool;
import java.util.HashMap;
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
    
    private Map<DataNode, Map<NodePower, DataNodePower>> powers = new HashMap<>();
    
    private Lock nodeUpdateLock = new ReentrantLock();

    public void addKeyValueNode(DataNode node) throws ExistException {
        nodeUpdateLock.lock();
        try {
            //存在性校验
            if(nodes.containsKey(node.getNodeKey())){
                throw new ExistException("数据Key值");
            }
            
            nodes.put(node.getNodeKey(), node);
        } finally {
            nodeUpdateLock.unlock();
        }
    }
    
    public DataNode getNode(String nodeKey) {
        if(Pool.getDataFormat() == DataFormat.KEY_VALUE){
            return nodes.get(nodeKey);
        }else{
            return getTreeNode(nodeKey);
        }
    }

    private TreeDataNode getTreeNode(String index) {
        String nodeKey = index.replaceAll("/", "_");
        return (TreeDataNode) nodes.get(nodeKey);
    }

    public void addTreeNode(TreeDataNode node) throws ExistException {
        node.setIndex(node.getParent().getIndex() + "/" + node.getNodeKey());
        node.setNodeKey(node.getIndex().replaceAll("/", "_"));
        nodeUpdateLock.lock();
        try {
            if(nodes.containsKey(node.getNodeKey())){
                throw new ExistException("数据Key值");
            }
            nodes.put(node.getNodeKey(), node);
            node.getParent().getChildren().add(node);
        } finally {
            nodeUpdateLock.unlock();
        }
    }
    
    
    
    
    
    
    
    
}
