package com.zy.coordc.vo;

import com.zy.coordc.enums.NodeType;

/**
 * 监听节点请求
 * @author wuhailong
 */
public class ListenNodeRequest {
    
    /**
     * coord服务器地址
     */
    private String coordUrl;
    
    /**
     * 节点key
     */
    private String nodeKey;
    
    /**
     *  监听类型
     */
    private String nodePowers;
    
    /**
     * 回调地址
     */
    private String callbackUrl;

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

    public String getNodePowers() {
        return nodePowers;
    }

    public void setNodePowers(String nodePowers) {
        this.nodePowers = nodePowers;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
    
    
}
