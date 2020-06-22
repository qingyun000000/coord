package com.zy.coord.controller;

import cn.whl.commonutils.exception.InputNullException;
import cn.whl.commonutils.exception.InputWrongException;
import cn.whl.commonutils.service.result.ResultParam;
import cn.whl.commonutils.service.result.ServiceResult;
import cn.whl.commonutils.service.result.ServiceResultUtils;
import cn.whl.commonutils.verificate.VerificateUtils;
import com.zy.coord.service.CoordService;
import com.zy.coord.vo.CreateNodeRequest;
import com.zy.coord.vo.DeleteNodeRequest;
import com.zy.coord.vo.GetNodeRequest;
import com.zy.coord.vo.HeartbeatRequest;
import com.zy.coord.vo.ListenNodeRequest;
import com.zy.coord.vo.RegistRequest;
import com.zy.coord.vo.UpdateNodeRequest;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 协调器
 * @author wuhailong
 */
@RestController
public class Controller {
    
    @Autowired
    private CoordService coordService;
    
    @PostMapping(value = "/regist")
    public ServiceResult regist(RegistRequest registRequest, HttpServletRequest request){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, ()->{
            if(VerificateUtils.isEmpty(registRequest.getGroup())){throw new InputNullException("客户组");}
            if(registRequest.getPort() < 1){throw new InputWrongException("客户端口");}
            registRequest.setClientUrl("http://" + request.getRemoteAddr() + ":" + registRequest.getPort());
        }, () -> coordService.regist(registRequest));
        return result;
    }
       
    @PostMapping(value = "/heartbeat")
    public ServiceResult heartbeat(HeartbeatRequest heartbeatRequest, HttpServletRequest request){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, ()->{
        }, () -> coordService.heartbeat(heartbeatRequest));
        return result;
    }
    
    @PostMapping(value = "/dateFormat")
    public ServiceResult dateFormat(){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, () -> coordService.getDataFormat());
        return result;
    }
    
    @PostMapping(value = "/createNode")
    public ServiceResult createNode(CreateNodeRequest createNodeRequest, HttpServletRequest request){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, () -> coordService.createNode(createNodeRequest));
        return result;
    }
    
    @PostMapping(value = "/createStandingNode")
    public ServiceResult createStandingNode(CreateNodeRequest createNodeRequest, HttpServletRequest request){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, () -> coordService.createNode(createNodeRequest));
        return result;
    }
    
    @PostMapping(value = "/createTemporaryNode")
    public ServiceResult createTemporaryNode(CreateNodeRequest createNodeRequest, HttpServletRequest request){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, () -> coordService.createNode(createNodeRequest));
        return result;
    }
    
    @PostMapping(value = "/updateNode")
    public ServiceResult updateNode(UpdateNodeRequest updateNodeRequest, HttpServletRequest request){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, () -> coordService.updateNode(updateNodeRequest));
        return result;
    }
    
    @PostMapping(value = "/deleteNode")
    public ServiceResult deleteNode(DeleteNodeRequest deleteNodeRequest, HttpServletRequest request){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, () -> coordService.deleteNode(deleteNodeRequest));
        return result;
    }
    
    @PostMapping(value = "/listenNode")
    public ServiceResult listenNode(ListenNodeRequest listenNodeRequest, HttpServletRequest request){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, () -> coordService.listenNode(listenNodeRequest));
        return result;
    }
    
    @PostMapping(value = "/getNode")
    public ServiceResult getNode(GetNodeRequest getNodeRequest, HttpServletRequest request){
        ServiceResult result = ServiceResultUtils.action(ResultParam.Data, () -> coordService.getNode(getNodeRequest));
        return result;
    }
} 
