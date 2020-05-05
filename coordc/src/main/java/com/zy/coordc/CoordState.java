package com.zy.coordc;

import com.zy.coordc.enums.DataFormat;
import com.zy.coordc.enums.NodePower;
import com.zy.coordc.po.Node;
import java.util.List;
import java.util.Map;


/**
 * 服务器信息
 * @author wuhailong
 */
public class CoordState {
    
    private static DataFormat dataFormat;
    
    private static String clientToken;
    
    private static Map<Node, List<NodePower>> powers;

    public static DataFormat getDataFormat() {
        return dataFormat;
    }

    public static void setDataFormat(DataFormat dataFormat) {
        CoordState.dataFormat = dataFormat;
    }

    public static String getClientToken() {
        return clientToken;
    }

    public static void setClientToken(String clientToken) {
        CoordState.clientToken = clientToken;
    }

    public static Map<Node, List<NodePower>> getPowers() {
        return powers;
    }

    public static void setPowers(Map<Node, List<NodePower>> powers) {
        CoordState.powers = powers;
    }
    
    
}
