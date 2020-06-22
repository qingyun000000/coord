package com.zy.coord.vo;

import com.zy.coord.enums.NodeType;


/**
 * 创建节点请求
 * @author wuhailong
 */
public class CreateNodeRequest {
    
    /**
     * 组（只有同组的客户端才对组内的数据可见）
     */
    private String group;
    
    /**
     * token
     */
    private String token;
    
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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
