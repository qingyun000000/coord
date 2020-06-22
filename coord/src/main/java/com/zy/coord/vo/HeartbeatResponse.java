package com.zy.coord.vo;

import java.util.Date;

/**
 * 心跳返回
 * @author wuhailong
 */
public class HeartbeatResponse {
    
    /*
    * 组（只有同组的客户端才对组内的数据可见）
    */
    private String group;
    
    /*
    * 唯一名
    */
    private String uniName;
    
    /*
    * 客户端token
    */
    private String token;
    
    /*
    * 注册时间
    */
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
