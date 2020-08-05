package com.zy.coordClient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author wuhailong
 */
@Controller
public class TestController {
    
    @RequestMapping("/test")
    public String test(Model model){
        return "test";
    }
    
}
