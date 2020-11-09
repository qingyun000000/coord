package com.zy.coord.initiate;

import com.zy.coord.enums.DataFormat;
import com.zy.coord.enums.WorkMode;
import com.zy.coord.pool.Pool;
import com.zy.coord.set.CoordSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * 协调器配置初始化
 * @author wuhailong
 */
@Component
public class CoordInitiate  implements ApplicationListener<ContextRefreshedEvent>{
    
    @Value("${server.port:8080}")
    private int port;
    
    @Value("${zycoord.coord.name:emp}")
    private String name;
    
    @Value("${zycoord.coord.dataFormat:tree_node}")
    private String dataFormat;
    
    @Value("${zycoord.coord.work_mode:singleton}")
    private String workMode;
    
    @Value("${zycoord.coord.group.name:emp}")
    private String groupName;
    
    @Value("${zycoord.coord.group.mode:}")
    private String groupMode;
    
    @Value("${zycoord.coord.group.regist:emp}")
    private String registUrls;
    
    @Value("${zycoord.coord.group.syn_time:600}")
    private int groupSynTime;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        initCoord();
    }

    private void initCoord() {
        System.out.println("初始化");
        if("singleton".equals(workMode)){
            CoordSet.setWorkMode(WorkMode.SINGLETON);
        }else{
            CoordSet.setWorkMode(WorkMode.GROUP);
        }
        if("key_value".equals(dataFormat)){
            Pool.setDataFormat(DataFormat.KEY_VALUE);
        }else{
            Pool.setDataFormat(DataFormat.TREE_NODE);
        }
    }
    
}
