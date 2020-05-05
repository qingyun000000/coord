package com.zy.coordc.vo;

import com.zy.coordc.enums.NodeType;

/**
 * 客户端注册请求
 * @author wuhailong
 */
public class RegistRequest {
    
    /**
     * coord服务器地址
     */
    private String coordUrl;

    public String getCoordUrl() {
        return coordUrl;
    }

    public void setCoordUrl(String coordUrl) {
        this.coordUrl = coordUrl;
    }
    
}
