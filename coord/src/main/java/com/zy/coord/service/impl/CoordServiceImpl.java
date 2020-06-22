package com.zy.coord.service.impl;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import cn.whl.commonutils.log.LoggerUtils;
import cn.whl.commonutils.token.SimpleLongToken;
import cn.whl.commonutils.token.TokenUtils;
import com.zy.coord.client.Client;
import com.zy.coord.client.GroupClient;
import com.zy.coord.data.DataNode;
import com.zy.coord.data.GroupData;
import com.zy.coord.data.TreeDataNode;
import com.zy.coord.enums.DataFormat;
import com.zy.coord.pool.Pool;
import com.zy.coord.service.CoordService;
import com.zy.coord.set.CoordSet;
import com.zy.coord.vo.CreateNodeRequest;
import com.zy.coord.vo.CreateNodeResponse;
import com.zy.coord.vo.DeleteNodeRequest;
import com.zy.coord.vo.DeleteNodeResponse;
import com.zy.coord.vo.GetNodeRequest;
import com.zy.coord.vo.HeartbeatRequest;
import com.zy.coord.vo.HeartbeatResponse;
import com.zy.coord.vo.ListenNodeRequest;
import com.zy.coord.vo.ListenNodeResponse;
import com.zy.coord.vo.NodeResponse;
import com.zy.coord.vo.RegistRequest;
import com.zy.coord.vo.RegistResponse;
import com.zy.coord.vo.UpdateNodeRequest;
import com.zy.coord.vo.UpdateNodeResponse;
import java.util.Date;
import java.util.Random;

/**
 * Coord业务层实现
 * @author wuhailong
 */
public class CoordServiceImpl implements CoordService{

    @Override
    public RegistResponse regist(RegistRequest registRequest) throws ExistException {
        Client client = new Client();
        client.setGroup(registRequest.getGroup());
        client.setClientUrl(registRequest.getClientUrl());
        
        Client registClient = Pool.registClient(client);
        
        RegistResponse response = new RegistResponse();
        response.setGroup(registClient.getGroup());
        response.setRegistDate(registClient.getRegistDate());
        response.setToken(registClient.getToken());
        response.setUniName(registClient.getUniName());
        return response;
    }

    @Override
    public HeartbeatResponse heartbeat(HeartbeatRequest heartbeatRequest) throws NotExistException {
        Client client = new Client();
        client.setGroup(heartbeatRequest.getGroup());
        client.setToken(heartbeatRequest.getToken());
        Pool.heartbeat(client);
        
        HeartbeatResponse response = new HeartbeatResponse();
        
        return response;
    }

    @Override
    public DataFormat getDataFormat() {
        return Pool.getDataFormat();
    }

    @Override
    public CreateNodeResponse createNode(CreateNodeRequest createNodeRequest) throws NotExistException, ExistException {
        Client client = new Client();
        
        DataNode dataNode = new DataNode();
        
        DataNode createNode = Pool.createNode(client, dataNode);
        
        
        
        CreateNodeResponse response = new CreateNodeResponse();
        
        return response;
    }

    

    @Override
    public UpdateNodeResponse updateNode(UpdateNodeRequest updateNodeRequest) throws NotExistException{
        //客户端校验
        verificationClient(updateNodeRequest.getGroup(), updateNodeRequest.getToken());
        
        //获取节点，校验权限
        if(!Pool.getData().containsKey(updateNodeRequest.getGroup())){
            throw new NotExistException("组数据");
        }
        
        GroupData
        
        GroupData groupData = Pool.getData().get(updateNodeRequest.getGroup());
        DataNode node = groupData.getNode(updateNodeRequest.getNodeKey());
        
        
        UpdateNodeResponse response = new UpdateNodeResponse();
        return response;
    }

    @Override
    public DeleteNodeResponse deleteNode(DeleteNodeRequest deleteNodeRequest) {
        
        //获取节点
        
        
        
        DeleteNodeResponse response = new DeleteNodeResponse();
        return response;
    }

    @Override
    public ListenNodeResponse listenNode(ListenNodeRequest listenNodeRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NodeResponse getNode(GetNodeRequest nodeRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
