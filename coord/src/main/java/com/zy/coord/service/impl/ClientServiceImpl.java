package com.zy.coord.service.impl;

import cn.whl.commonutils.exception.ExistException;
import cn.whl.commonutils.exception.NotExistException;
import cn.whl.commonutils.exception.ServiceRunException;
import com.zy.coord.client.GroupClient;
import com.zy.coord.enums.DataFormat;
import com.zy.coord.enums.GroupMode;
import com.zy.coord.enums.WorkMode;
import com.zy.coord.service.ClientService;
import com.zy.coord.service.DBCoordService;
import com.zy.coord.service.LocalCoordService;
import com.zy.coord.service.RedisCoordService;
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
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Coord业务层实现
 * @author wuhailong
 */
@Service
public class ClientServiceImpl implements ClientService{
    
    @Autowired
    private LocalCoordService localCoordService;
    
    @Autowired
    private VoteCoordService voteCoordService;
    
    @Autowired
    private DBCoordService dbCoordService;
    
    @Autowired
    private RedisCoordService redisCoordService;

    @Override
    public RegistResponse regist(RegistRequest registRequest) throws ExistException, ServiceRunException {
        if(CoordSet.getWorkMode() == WorkMode.GROUP){
            if(CoordSet.getGroupMode() == GroupMode.DB){
                return dbCoordService.regist(registRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.REDIS){
                return redisCoordService.regist(registRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.VOTE){
                return voteCoordService.regist(registRequest);
            }else{
                throw new ServiceRunException("groupMode配置错误");
            }
        }else if(CoordSet.getWorkMode() == WorkMode.SINGLETON){
            return localCoordService.regist(registRequest);
        }else{
            throw new ServiceRunException("workMode配置错误");
        }
    }

    @Override
    public HeartbeatResponse heartbeat(HeartbeatRequest heartbeatRequest) throws NotExistException, ServiceRunException {
        if(CoordSet.getWorkMode() == WorkMode.GROUP){
            if(CoordSet.getGroupMode() == GroupMode.DB){
                return dbCoordService.heartbeat(heartbeatRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.REDIS){
                return redisCoordService.heartbeat(heartbeatRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.VOTE){
                return voteCoordService.heartbeat(heartbeatRequest);
            }else{
                throw new ServiceRunException("groupMode配置错误");
            }
        }else if(CoordSet.getWorkMode() == WorkMode.SINGLETON){
            return localCoordService.heartbeat(heartbeatRequest);
        }else{
            throw new ServiceRunException("workMode配置错误");
        }
    }

    @Override
    public DataFormat getDataFormat() throws ServiceRunException {
        if(CoordSet.getWorkMode() == WorkMode.GROUP){
            if(CoordSet.getGroupMode() == GroupMode.DB){
                return dbCoordService.getDataFormat();
            }else if(CoordSet.getGroupMode() == GroupMode.REDIS){
                return redisCoordService.getDataFormat();
            }else if(CoordSet.getGroupMode() == GroupMode.VOTE){
                return voteCoordService.getDataFormat();
            }else{
                throw new ServiceRunException("groupMode配置错误");
            }
        }else if(CoordSet.getWorkMode() == WorkMode.SINGLETON){
            return localCoordService.getDataFormat();
        }else{
            throw new ServiceRunException("workMode配置错误");
        }
    }

    @Override
    public CreateNodeResponse createNode(CreateNodeRequest createNodeRequest) throws NotExistException, ExistException, ServiceRunException {
        if(CoordSet.getWorkMode() == WorkMode.GROUP){
            if(CoordSet.getGroupMode() == GroupMode.DB){
                return dbCoordService.createNode(createNodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.REDIS){
                return redisCoordService.createNode(createNodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.VOTE){
                return voteCoordService.createNode(createNodeRequest);
            }else{
                throw new ServiceRunException("groupMode配置错误");
            }
        }else if(CoordSet.getWorkMode() == WorkMode.SINGLETON){
            return localCoordService.createNode(createNodeRequest);
        }else{
            throw new ServiceRunException("workMode配置错误");
        }
    }

    

    @Override
    public UpdateNodeResponse updateNode(UpdateNodeRequest updateNodeRequest) throws NotExistException, ServiceRunException{
        if(CoordSet.getWorkMode() == WorkMode.GROUP){
            if(CoordSet.getGroupMode() == GroupMode.DB){
                return dbCoordService.updateNode(updateNodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.REDIS){
                return redisCoordService.updateNode(updateNodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.VOTE){
                return voteCoordService.updateNode(updateNodeRequest);
            }else{
                throw new ServiceRunException("groupMode配置错误");
            }
        }else if(CoordSet.getWorkMode() == WorkMode.SINGLETON){
            return localCoordService.updateNode(updateNodeRequest);
        }else{
            throw new ServiceRunException("workMode配置错误");
        }
    }

    @Override
    public DeleteNodeResponse deleteNode(DeleteNodeRequest deleteNodeRequest) throws NotExistException, ServiceRunException {
        if(CoordSet.getWorkMode() == WorkMode.GROUP){
            if(CoordSet.getGroupMode() == GroupMode.DB){
                return dbCoordService.deleteNode(deleteNodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.REDIS){
                return redisCoordService.deleteNode(deleteNodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.VOTE){
                return voteCoordService.deleteNode(deleteNodeRequest);
            }else{
                throw new ServiceRunException("groupMode配置错误");
            }
        }else if(CoordSet.getWorkMode() == WorkMode.SINGLETON){
            return localCoordService.deleteNode(deleteNodeRequest);
        }else{
            throw new ServiceRunException("workMode配置错误");
        }
    }

    @Override
    public ListenNodeResponse listenNode(ListenNodeRequest listenNodeRequest) throws NotExistException, ServiceRunException {
        if(CoordSet.getWorkMode() == WorkMode.GROUP){
            if(CoordSet.getGroupMode() == GroupMode.DB){
                return dbCoordService.listenNode(listenNodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.REDIS){
                return redisCoordService.listenNode(listenNodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.VOTE){
                return voteCoordService.listenNode(listenNodeRequest);
            }else{
                throw new ServiceRunException("groupMode配置错误");
            }
        }else if(CoordSet.getWorkMode() == WorkMode.SINGLETON){
            return localCoordService.listenNode(listenNodeRequest);
        }else{
            throw new ServiceRunException("workMode配置错误");
        }
    }

    @Override
    public NodeResponse getNode(GetNodeRequest nodeRequest) throws NotExistException, ServiceRunException {
        if(CoordSet.getWorkMode() == WorkMode.GROUP){
            if(CoordSet.getGroupMode() == GroupMode.DB){
                return dbCoordService.getNode(nodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.REDIS){
                return redisCoordService.getNode(nodeRequest);
            }else if(CoordSet.getGroupMode() == GroupMode.VOTE){
                return voteCoordService.getNode(nodeRequest);
            }else{
                throw new ServiceRunException("groupMode配置错误");
            }
        }else if(CoordSet.getWorkMode() == WorkMode.SINGLETON){
            return localCoordService.getNode(nodeRequest);
        }else{
            throw new ServiceRunException("workMode配置错误");
        }
    }

    @Override
    public Map<String, GroupClient> getClients() throws NotExistException, ServiceRunException{
        if(CoordSet.getWorkMode() == WorkMode.GROUP){
            return null;
        }else if(CoordSet.getWorkMode() == WorkMode.SINGLETON){
            return localCoordService.getClients();
        }else{
            throw new ServiceRunException("workMode配置错误");
        }
    }
    
}
