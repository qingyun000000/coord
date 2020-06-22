package com.zy.coord.data;

import java.util.List;

/**
 * 数据节点
 * @author wuhailong
 */
public class TreeDataNode extends DataNode{
    
    /**
     * 树型目录
     */
    private String index;
    
    /**
     * 父节点key
     */
    private TreeDataNode parent;
    
    /**
     * 子节点key
     */
    private List<TreeDataNode> children;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

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
