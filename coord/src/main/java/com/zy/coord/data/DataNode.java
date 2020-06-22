package com.zy.coord.data;

import com.zy.coord.enums.NodeType;

/**
 * 数据节点
 * @author wuhailong
 */
public class DataNode {
    
    /**
     * 节点类型
     */
    private NodeType nodeType;
    
    /**
     * 节点key
     */
    private String nodeKey;
    
    /**
     * 节点值
     */
    private String nodeValue;

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }
    
    
}
