package com.zy.coord.data;

import java.util.List;

/**
 * 数据节点
 * @author wuhailong
 */
public class TreeDataNode extends DataNode{
    
    /**
     * 父节点key
     */
    private TreeDataNode parent;
    
    /**
     * 子节点key
     */
    private List<TreeDataNode> children;

    public TreeDataNode getParent() {
        return parent;
    }

    public void setParent(TreeDataNode parent) {
        this.parent = parent;
    }

    public List<TreeDataNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeDataNode> children) {
        this.children = children;
    }

    
}
