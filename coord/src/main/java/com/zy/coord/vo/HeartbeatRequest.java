package com.zy.coord.vo;

import com.zy.coord.enums.NodeType;


/**
 * 心跳请求
 * @author wuhailong
 */
public class HeartbeatRequest {
    
    /**
     * 组（只有同组的客户端才对组内的数据可见）
     */
    private String group;
    
    /**
     * 客户端token
     */
    private String token;

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
    
}
