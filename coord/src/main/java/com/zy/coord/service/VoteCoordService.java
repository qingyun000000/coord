package com.zy.coord.service;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import cn.whl.commonutils.service.result.ServiceResult;
import com.zy.coord.enums.DataFormat;
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

/**
 * 选举Coord业务层接口（请求主服务器）
 * @author wuhailong
 */
public interface VoteCoordService {

    /**
     * 客户端注册
     * @param registRequest
     * @return 
     * @throws cn.whl.commonutils.exception.ExistException 
     */
    public RegistResponse regist(RegistRequest registRequest) throws ExistException;

    /**
     * 心跳
     * @param heartbeatRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     */
    public HeartbeatResponse heartbeat(HeartbeatRequest heartbeatRequest) throws NotExistException;
    
    /**
     * 获取数据格式
     * @return 
     */
    public DataFormat getDataFormat();

    /**
     * 创建节点
     * @param createNodeRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     * @throws cn.whl.commonutils.exception.ExistException 
     */
    public CreateNodeResponse createNode(CreateNodeRequest createNodeRequest) throws NotExistException, ExistException;

    /**
     * 修改节点
     * @param updateNodeRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     */
    public UpdateNodeResponse updateNode(UpdateNodeRequest updateNodeRequest) throws NotExistException;

    /**
     * 删除节点
     * @param deleteNodeRequest
     * @return
     * @throws cn.whl.commonutils.exception.NotExistException
     */
    public DeleteNodeResponse deleteNode(DeleteNodeRequest deleteNodeRequest) throws NotExistException;

    /**
     * 监听节点
     * @param listenNodeRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     */
    public ListenNodeResponse listenNode(ListenNodeRequest listenNodeRequest) throws NotExistException;

    /**
     * 获取节点
     * @param nodeRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     */
    public NodeResponse getNode(GetNodeRequest nodeRequest) throws NotExistException;

    
    
}
