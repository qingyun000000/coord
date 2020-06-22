package com.zy.coordc.vo;

import com.zy.coordc.enums.NodeType;

/**
 * 获取节点请求
 * @author wuhailong
 */
public class GetNodeRequest {
    
    /**
     * coord服务器地址
     */
    private String coordUrl;
    
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

    public String getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }
    
}
