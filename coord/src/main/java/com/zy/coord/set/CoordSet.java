package com.zy.coord.set;

import com.zy.coord.enums.DataFormat;
import com.zy.coord.enums.GroupMode;
import com.zy.coord.enums.WorkMode;

/**
 * 协调器配置
 * @author wuhailong
 */
public class CoordSet {
    
    private static int port;
    
    private static String name;
    
    private static WorkMode workMode;
    
    private static String groupName;
    
    private static GroupMode groupMode;
    
    private static String registUrls;
    
    private static int groupSynTime;

    public static int getPort() {
        return port;
    }

    public static void setPort(int port) {
        CoordSet.port = port;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        CoordSet.name = name;
    }

    public static WorkMode getWorkMode() {
        return workMode;
    }

    public static void setWorkMode(WorkMode workMode) {
        CoordSet.workMode = workMode;
    }

    public static String getGroupName() {
        return groupName;
    }

    public static void setGroupName(String groupName) {
        CoordSet.groupName = groupName;
    }

    public static GroupMode getGroupMode() {
        return groupMode;
    }

    public static void setGroupMode(GroupMode groupMode) {
        CoordSet.groupMode = groupMode;
    }

    public static String getRegistUrls() {
        return registUrls;
    }

    public static void setRegistUrls(String registUrls) {
        CoordSet.registUrls = registUrls;
    }

    public static int getGroupSynTime() {
        return groupSynTime;
    }

    public static void setGroupSynTime(int groupSynTime) {
        CoordSet.groupSynTime = groupSynTime;
    }
    
}
