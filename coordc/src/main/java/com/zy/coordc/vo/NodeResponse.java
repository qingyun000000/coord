package com.zy.coordc.vo;

import com.zy.coordc.enums.NodeType;

/**
 *
 * @author wuhailong
 */
public class NodeResponse {
    
    /**
     * TREE_NODE模式，父节点路径
     */
    private String parent;
    
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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

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
