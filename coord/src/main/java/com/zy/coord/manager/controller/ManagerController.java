package com.zy.coord.manager.controller;

import java.util.List;
import java.util.Map;
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
    
    /**
     * 管理主页
     * @param model
     * @return 
     */
    @GetMapping("/manager")
    public String mangerMainPage(Model model){
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
