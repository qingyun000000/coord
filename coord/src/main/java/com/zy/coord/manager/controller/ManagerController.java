package com.zy.coord.manager.controller;

import cn.whl.commonutils.exception.NotExistException;
import cn.whl.commonutils.exception.ServiceRunException;
import com.zy.coord.client.Client;
import com.zy.coord.client.GroupClient;
import com.zy.coord.enums.DataFormat;
import com.zy.coord.service.ClientService;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 管理页面Controller
 * @author wuhailong
 */
@Controller
@RequestMapping("/coord")
public class ManagerController {
    
    @Autowired
    private ClientService clientService;
    
    /**
     * 管理主页
     * @param model
     * @return 
     */
    @GetMapping("/manager")
    public String mangerMainPage(Model model){
        
        try {
            DataFormat dataFormat = clientService.getDataFormat();
            model.addAttribute("dataFormat", dataFormat);
            
            Map<String, GroupClient> clients = clientService.getClients();
            GroupClient client = new GroupClient();
            Client client1 = new Client();
            client1.setGroup("test1");
            client1.setUniName("test1-1");
            client1.setClientUrl("http://dere");
            client.getClients().put("test1-1", client1);
            clients.put("test1", client);
            model.addAttribute("clients", clients);
        } catch (ServiceRunException | NotExistException ex) {
            Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "manager";
    }
    
    /**
     * 客户端页面
     * @param model
     * @return 
     */
    @GetMapping("/client")
    public String clientPage(Model model){
        
        return "client";
    }
    
    /**
     * 服务页面
     * @param model
     * @return 
     */
    @GetMapping("/service")
    public String servicePage(Model model){
        
        return "service";
    }
    
    /**
     * 监控页面
     * @param model
     * @return 
     */
    @GetMapping("/monitor")
    public String monitorPage(Model model){
        
        return "monitor";
    }
}
