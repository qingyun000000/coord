package com.zy.coord.vo;


/**
 * 客户端注册请求
 * @author wuhailong
 */
public class RegistRequest {
    
    /**
     * 组（只有同组的客户端才对组内的数据可见）
     */
    private String group;
    
    /**
     * 客户端端口
     */
    private int port;
    
    /**
     * 客户端地址（带port）
     */
    private String clientUrl;
    
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getClientUrl() {
        return clientUrl;
    }

    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }
    
}
