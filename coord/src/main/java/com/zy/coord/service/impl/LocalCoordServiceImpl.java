package com.zy.coord.service.impl;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import com.zy.coord.client.Client;
import com.zy.coord.data.DataNode;
import com.zy.coord.enums.DataFormat;
import com.zy.coord.enums.NodeEvent;
import com.zy.coord.pool.Pool;
import com.zy.coord.service.LocalCoordService;
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
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 本地Coord业务层实现（用于单机工作）
 * @author wuhailong
 */
@Service
public class LocalCoordServiceImpl implements LocalCoordService{

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
        Client client = new Client();
        
        DataNode dataNode = new DataNode();
        
        DataNode createNode = Pool.updateNode(client, dataNode);
        
        
        UpdateNodeResponse response = new UpdateNodeResponse();
        return response;
    }

    @Override
    public DeleteNodeResponse deleteNode(DeleteNodeRequest deleteNodeRequest) throws NotExistException {
        
        Client client = new Client();
        
        DataNode dataNode = new DataNode();
        
        DataNode createNode = Pool.deleteNode(client, dataNode);
        
        DeleteNodeResponse response = new DeleteNodeResponse();
        return response;
    }

    @Override
    public ListenNodeResponse listenNode(ListenNodeRequest listenNodeRequest) throws NotExistException {
        Client client = new Client();
        
        DataNode dataNode = new DataNode();
        
        List<NodeEvent> events = new ArrayList<>();
        
        DataNode createNode = Pool.listenNode(client, dataNode, events);
        
        ListenNodeResponse response = new ListenNodeResponse();
        return response;
            
    }

    @Override
    public NodeResponse getNode(GetNodeRequest nodeRequest) throws NotExistException {
        Client client = new Client();
        
        DataNode dataNode = Pool.getNode(client, nodeRequest.getNodeKey());
        
        NodeResponse response = new NodeResponse();
        return response;
    }
    
}
