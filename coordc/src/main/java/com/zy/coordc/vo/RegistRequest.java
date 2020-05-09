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
    
    /**
     * 组（只有同组的客户端才对组内的数据可见）
     */
    private String group;

    public String getCoordUrl() {
        return coordUrl;
    }

    public void setCoordUrl(String coordUrl) {
        this.coordUrl = coordUrl;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    
}
