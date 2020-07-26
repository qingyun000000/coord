package com.zy.coord.service.impl;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import com.zy.coord.client.Client;
import com.zy.coord.data.DataNode;
import com.zy.coord.enums.DataFormat;
import com.zy.coord.pool.Pool;
import com.zy.coord.service.MainCoordService;
import com.zy.coord.service.VoteCoordService;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 主Coord业务层实现
 * @author wuhailong
 */
@Service
public class MainCoordServiceImpl implements MainCoordService{
   
    @Override
    public RegistResponse regist(RegistRequest registRequest) throws ExistException {
        if(CoordSet.isMainFlag() == false){
            
        }
        return null;
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
        
        
        DeleteNodeResponse response = new DeleteNodeResponse();
        return response;
    }

    @Override
    public ListenNodeResponse listenNode(ListenNodeRequest listenNodeRequest) throws NotExistException {
        Client client = new Client();
        
        DataNode dataNode = new DataNode();
        
        ListenNodeResponse response = new ListenNodeResponse();
        return response;
            
    }

    @Override
    public NodeResponse getNode(GetNodeRequest nodeRequest) throws NotExistException {
        Client client = new Client();
        
        DataNode dataNode = new DataNode();
        
        
        NodeResponse response = new NodeResponse();
        return response;
    }
    
}
