package com.zy.coord.client;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import cn.whl.commonutils.log.LoggerUtils;
import cn.whl.commonutils.token.SimpleLongToken;
import cn.whl.commonutils.token.TokenUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 组客户端
 * @author wuhailong
 */
public class GroupClient {
    
    private  Map<String, Client> clients = new HashMap<>();
    
    private Lock clientsUpdateLock = new ReentrantLock();

    /**
     * 获取客户端列表
     * @return 
     */
    public Map<String, Client> getClients() {
        return clients;
    }

    /**
     * 加入客户端
     * @param client
     * @return 
     * @throws ExistException 
     */
    public Client addClient(Client client) throws ExistException {
        clientsUpdateLock.lock();
        try {
            if(clients.containsKey(client.getClientUrl())){
                throw new ExistException("客户端");
            }
            if(clients.containsKey(client.getToken())){
                throw new ExistException("客户端");
            }
            client.setHeartbeatDate(new Date());
            client.setUniName(client.getClientUrl() + new Date().getTime());
            client.setRegistDate(new Date());
            try {
                client.setToken(TokenUtils.createToken(new Date().getTime() + "" + new Random().nextInt(999), new SimpleLongToken()));
            } catch (Exception ex) {
                LoggerUtils.log4j_write.error(new Exception("生成token失败"));
            }
            clients.put(client.getToken(), client);
        } finally {
            clientsUpdateLock.unlock();
        }
        return client;
    }

    public void heartbeat(String token) throws NotExistException {
        clientsUpdateLock.lock();
        try {
            if(!clients.containsKey(token)){
                throw new NotExistException("客户端");
            }
            clients.get(token).setHeartbeatDate(new Date());;
        } finally {
            clientsUpdateLock.unlock();
        }
    }

    public boolean verToken(String token) {
        return clients.containsKey(token);
    }

    
}
