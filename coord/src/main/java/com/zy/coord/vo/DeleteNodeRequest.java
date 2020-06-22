package com.zy.coord.vo;

import com.zy.coord.enums.NodeType;


/**
 * 删除节点请求
 * @author wuhailong
 */
public class DeleteNodeRequest {
    
    /**
     * coord服务器地址
     */
    private String coordUrl;
    
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

    public String getCoordUrl() {
        return coordUrl;
    }

    public void setCoordUrl(String coordUrl) {
        this.coordUrl = coordUrl;
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
    
    
    
}
