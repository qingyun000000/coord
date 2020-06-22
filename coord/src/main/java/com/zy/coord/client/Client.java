package com.zy.coord.client;

import java.util.Date;

/**
 * 客户端
 * @author wuhailong
 */
public class Client {
    
    private String group;
    
    private String uniName;
    
    private String clientUrl;
    
    private Date registDate;
    
    private String token;
    
    private Date heartbeatDate;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getClientUrl() {
        return clientUrl;
    }

    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getHeartbeatDate() {
        return heartbeatDate;
    }

    public void setHeartbeatDate(Date heartbeatDate) {
        this.heartbeatDate = heartbeatDate;
    }
    
}
