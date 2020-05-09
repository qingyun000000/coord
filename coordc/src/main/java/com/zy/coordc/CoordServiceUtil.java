package com.zy.coordc;

import com.alibaba.fastjson.JSON;
import com.zy.coordc.enums.DataFormat;
import com.zy.coordc.exception.NodeExistExcepiton;
import com.zy.coordc.utils.HttpUtil;
import com.zy.coordc.vo.CreateNodeRequest;
import com.zy.coordc.vo.CreateNodeResponse;
import com.zy.coordc.vo.DeleteNodeRequest;
import com.zy.coordc.vo.DeleteNodeResponse;
import com.zy.coordc.vo.GetNodeRequest;
import com.zy.coordc.vo.HeartbeatRequest;
import com.zy.coordc.vo.HeartbeatResponse;
import com.zy.coordc.vo.ListenNodeRequest;
import com.zy.coordc.vo.ListenNodeResponse;
import com.zy.coordc.vo.NodeResponse;
import com.zy.coordc.vo.RegistRequest;
import com.zy.coordc.vo.RegistResponse;
import com.zy.coordc.vo.ServiceResult;
import com.zy.coordc.vo.UpdateNodeRequest;
import com.zy.coordc.vo.UpdateNodeResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 协调器服务
 * @author wuhailong
 */
public class CoordServiceUtil {
    
    /**
     * 客户端注册
     * @param request
     * @return 
     * @throws com.zy.coordc.exception.NodeExistExcepiton 
     */
    public static RegistResponse regist(RegistRequest request) throws NodeExistExcepiton{
        if(CoordState.getDataFormat() == null){
            getDataFormat(request.getCoordUrl());
        }
        
        Map<String, String> params = new HashMap<>();
        params.put("group", request.getGroup());
        
        String result = HttpUtil.doPost(request.getCoordUrl() + "/regist", params);
        ServiceResult serviceResult = JSON.parseObject(result, ServiceResult.class);
        RegistResponse registResponse = JSON.parseObject(serviceResult.getData().toString(), RegistResponse.class);
        
        /**
         * 守护线程维持心跳
         */
        Thread thread = new Thread(() -> {
            while(true){
                try {
                    HeartbeatRequest request1 = new HeartbeatRequest();
                    heartbeat(request1);
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CoordServiceUtil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        
        return registResponse;
    }
    
    /**
     * 客户端心跳 （因为客户端的多样性，不能保证客户端能够被coord访问，因此由客户端主动发送心跳）
     * @param request
     * @return 
     */
    public static HeartbeatResponse heartbeat(HeartbeatRequest request){
        if(CoordState.getDataFormat() == null){
            getDataFormat(request.getCoordUrl());
        }
        
        Map<String, String> params = new HashMap<>();
        
        HttpUtil.doPost(request.getCoordUrl() + "/heartbeat", params);
        return null;
    }
    
    /**
     * 创建节点
     * @param request
     * @return 
     * @throws com.zy.coordc.exception.NodeExistExcepiton 
     */
    public static CreateNodeResponse createNode(CreateNodeRequest request) throws NodeExistExcepiton{
        if(CoordState.getDataFormat() == null){
            getDataFormat(request.getCoordUrl());
        }
        
        Map<String, String> params = new HashMap<>();
        if(CoordState.getDataFormat() == DataFormat.TREE_NODE){
            params.put("parant", request.getParent());
        }
        params.put("nodeType", request.getNodeType().name());
        params.put("nodeKey", request.getNodeKey());
        params.put("nodeValue", request.getNodeValue());
        
        
        HttpUtil.doPost(request.getCoordUrl() + "/createNode", params);
        return null;
    }
    
    /**
     * 创建永久节点
     * @param request
     * @return 
     */
    public static CreateNodeResponse createStandingNode(CreateNodeRequest request){
        if(CoordState.getDataFormat() == null){
            getDataFormat(request.getCoordUrl());
        }
        
        Map<String, String> params = new HashMap<>();
        if(CoordState.getDataFormat() == DataFormat.TREE_NODE){
            params.put("parant", request.getParent());
        }
        params.put("nodeKey", request.getNodeKey());
        params.put("nodeValue", request.getNodeValue());
        
        
        HttpUtil.doPost(request.getCoordUrl() + "/createStandingNode", params);
        return null;
    }
    
    /**
     * 创建临时节点
     * @param request
     * @return 
     */
    public static CreateNodeResponse createTemporaryNode(CreateNodeRequest request){
        if(CoordState.getDataFormat() == null){
            getDataFormat(request.getCoordUrl());
        }
        
        Map<String, String> params = new HashMap<>();
        if(CoordState.getDataFormat() == DataFormat.TREE_NODE){
            params.put("parant", request.getParent());
        }
        params.put("nodeKey", request.getNodeKey());
        params.put("nodeValue", request.getNodeValue());
        
        
        HttpUtil.doPost(request.getCoordUrl() + "/createTemporaryNode", params);
        return null;
    }
    
    /**
     * 修改节点值
     * @param request
     * @return 
     */
    public static UpdateNodeResponse updateNode(UpdateNodeRequest request){
        if(CoordState.getDataFormat() == null){
            getDataFormat(request.getCoordUrl());
        }
        
        Map<String, String> params = new HashMap<>();
        if(CoordState.getDataFormat() == DataFormat.TREE_NODE){
            params.put("parant", request.getParent());
        }
        params.put("nodeKey", request.getNodeKey());
        params.put("nodeValue", request.getNodeValue());
        
        HttpUtil.doPost(request.getCoordUrl() + "/createTemporaryNode", params);
        return null;
    }
    
    /**
     * 删除节点
     * @param request
     * @return 
     */
    public static DeleteNodeResponse deleteNode(DeleteNodeRequest request){
        if(CoordState.getDataFormat() == null){
            getDataFormat(request.getCoordUrl());
        }
        
        
        
        
        return null;
    }
    
    /**
     * 监听节点
     * @param request
     * @return 
     */
    public static ListenNodeResponse listenNode(ListenNodeRequest request){
        
        return null;
    }
    
    public static NodeResponse getNode(GetNodeRequest request){
        
        return null;
    } 

    /**
     * 获取数据格式
     * @param coordUrl 
     */
    private static DataFormat getDataFormat(String coordUrl) {
        String result = HttpUtil.doGet(coordUrl + "/dateFormat");
        ServiceResult serviceResult = JSON.parseObject(result, ServiceResult.class);
        DataFormat dataFormat = JSON.parseObject(serviceResult.getData().toString(), DataFormat.class);
        CoordState.setDataFormat(dataFormat);
        return dataFormat;
    }
    
    
}
