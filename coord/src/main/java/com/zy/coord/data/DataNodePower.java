package com.zy.coord.data;

import com.zy.coord.client.Client;
import com.zy.coord.enums.NodePower;
import com.zy.coord.enums.PowerMode;
import java.util.List;

/**
 * 数据节点权限
 * @author wuhailong
 */
public class DataNodePower {
    
    /**
     * 节点类型
     */
    private DataNode node;
    
    /**
     * 权限类型
     */
    private NodePower power;
    
    /**
     * 权限模式
     */
    private PowerMode mode;
    
    /**
     * 白名单或者黑名单
     */
    private List<String> clients;

    public DataNode getNode() {
        return node;
    }

    public void setNode(DataNode node) {
        this.node = node;
    }

    public NodePower getPower() {
        return power;
    }

    public void setPower(NodePower power) {
        this.power = power;
    }

    public PowerMode getMode() {
        return mode;
    }

    public void setMode(PowerMode mode) {
        this.mode = mode;
    }

    public List<String> getClients() {
        return clients;
    }

    public void setClients(List<String> clients) {
        this.clients = clients;
    }
    
    
}
