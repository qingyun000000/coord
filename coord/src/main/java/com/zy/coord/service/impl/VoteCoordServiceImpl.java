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
 * 选举Coord业务层实现（请求主服务器）
 * @author wuhailong
 */
@Service
public class VoteCoordServiceImpl implements VoteCoordService{
    
    @Autowired
    private MainCoordService mainService;

    @Override
    public RegistResponse regist(RegistRequest registRequest) throws ExistException {
        if(CoordSet.isMainFlag() == false){
            return mainService.regist(registRequest);
        }else{
            //请求主机
            return null;
        }
    }

    @Override
    public HeartbeatResponse heartbeat(HeartbeatRequest heartbeatRequest) throws NotExistException {
        if(CoordSet.isMainFlag() == false){
            return mainService.heartbeat(heartbeatRequest);
        }else{
            //请求主机
            return null;
        }
    }

    @Override
    public DataFormat getDataFormat() {
        if(CoordSet.isMainFlag() == false){
            return mainService.getDataFormat();
        }else{
            //请求主机
            return null;
        }
    }

    @Override
    public CreateNodeResponse createNode(CreateNodeRequest createNodeRequest) throws NotExistException, ExistException {
        if(CoordSet.isMainFlag() == false){
            return mainService.createNode(createNodeRequest);
        }else{
            //请求主机
            return null;
        }
    }

    

    @Override
    public UpdateNodeResponse updateNode(UpdateNodeRequest updateNodeRequest) throws NotExistException{
        if(CoordSet.isMainFlag() == false){
            return mainService.updateNode(updateNodeRequest);
        }else{
            //请求主机
            return null;
        }
    }

    @Override
    public DeleteNodeResponse deleteNode(DeleteNodeRequest deleteNodeRequest) throws NotExistException {
        if(CoordSet.isMainFlag() == false){
            return mainService.deleteNode(deleteNodeRequest);
        }else{
            //请求主机
            return null;
        }
    }

    @Override
    public ListenNodeResponse listenNode(ListenNodeRequest listenNodeRequest) throws NotExistException {
        if(CoordSet.isMainFlag() == false){
            return mainService.listenNode(listenNodeRequest);
        }else{
            //请求主机
            return null;
        }
    }

    @Override
    public NodeResponse getNode(GetNodeRequest nodeRequest) throws NotExistException {
        if(CoordSet.isMainFlag() == false){
            return mainService.getNode(nodeRequest);
        }else{
            //请求主机
            return null;
        }
    }
    
}
