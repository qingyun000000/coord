package com.zy.coord.service;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import cn.whl.commonutils.exception.ServiceRunException;
import cn.whl.commonutils.service.result.ServiceResult;
import com.zy.coord.client.GroupClient;
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
import java.util.Map;

/**
 * Coord业务层接口
 * @author wuhailong
 */
public interface ClientService {

    /**
     * 客户端注册
     * @param registRequest
     * @return 
     * @throws cn.whl.commonutils.exception.ExistException 
     * @throws cn.whl.commonutils.exception.ServiceRunException 
     */
    public RegistResponse regist(RegistRequest registRequest) throws ExistException, ServiceRunException;

    /**
     * 心跳
     * @param heartbeatRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     * @throws cn.whl.commonutils.exception.ServiceRunException 
     */
    public HeartbeatResponse heartbeat(HeartbeatRequest heartbeatRequest) throws NotExistException, ServiceRunException;
    
    /**
     * 获取数据格式
     * @return 
     * @throws cn.whl.commonutils.exception.ServiceRunException 
     */
    public DataFormat getDataFormat() throws ServiceRunException;

    /**
     * 创建节点
     * @param createNodeRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     * @throws cn.whl.commonutils.exception.ExistException 
     * @throws cn.whl.commonutils.exception.ServiceRunException 
     */
    public CreateNodeResponse createNode(CreateNodeRequest createNodeRequest) throws NotExistException, ExistException, ServiceRunException;

    /**
     * 修改节点
     * @param updateNodeRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     * @throws cn.whl.commonutils.exception.ServiceRunException 
     */
    public UpdateNodeResponse updateNode(UpdateNodeRequest updateNodeRequest) throws NotExistException, ServiceRunException;

    /**
     * 删除节点
     * @param deleteNodeRequest
     * @return
     * @throws cn.whl.commonutils.exception.NotExistException
     * @throws cn.whl.commonutils.exception.ServiceRunException
     */
    public DeleteNodeResponse deleteNode(DeleteNodeRequest deleteNodeRequest) throws NotExistException, ServiceRunException;

    /**
     * 监听节点
     * @param listenNodeRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     * @throws cn.whl.commonutils.exception.ServiceRunException 
     */
    public ListenNodeResponse listenNode(ListenNodeRequest listenNodeRequest) throws NotExistException, ServiceRunException;

    /**
     * 获取节点
     * @param nodeRequest
     * @return 
     * @throws cn.whl.commonutils.exception.NotExistException 
     * @throws cn.whl.commonutils.exception.ServiceRunException 
     */
    public NodeResponse getNode(GetNodeRequest nodeRequest) throws NotExistException, ServiceRunException;

    public Map<String, GroupClient> getClients() throws NotExistException, ServiceRunException;

    
    
}
