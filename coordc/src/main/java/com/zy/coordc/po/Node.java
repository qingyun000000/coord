package com.zy.coordc.po;

import com.zy.coordc.enums.NodeType;

/**
 * 节点
 * @author wuhailong
 */
public class Node {
    
    private NodeType nodeType;
    
    private String key;
    
    private String value;

    public NodeType getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeType nodeType) {
        this.nodeType = nodeType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
