package com.zy.coord.initiate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * 协调器配置初始化
 * @author wuhailong
 */
public class CoordInitiate  implements ApplicationListener<ContextRefreshedEvent>{
    
    @Value("${server.port:8080}")
    private int port;
    
    @Value("${zycoord.coord.name:emp}")
    private String name;
    
    @Value("${zycoord.coord.dataFormat:list}")
    private String dataFormat;
    
    @Value("${zycoord.coord.work_mode:singleton}")
    private String workMode;
    
    @Value("${zycoord.coord.group.name:emp}")
    private String groupName;
    
    @Value("${zycoord.coord.group.mode:}")
    private String groupMode;
    
    @Value("${zyras.ras.group.regist:emp}")
    private String registUrls;
    
    @Value("${zyras.ras.group.syn_time:600}")
    private int groupSynTime;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        initCoord();
    }

    private void initCoord() {
        
    }
    
}
