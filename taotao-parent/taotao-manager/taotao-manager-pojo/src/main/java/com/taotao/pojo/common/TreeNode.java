package com.taotao.pojo.common;

/**
 * @Author binblink
 * @Create Time　2018/4/12 15:12
 * @Description:
 */
public class TreeNode {

    private long id;

    private String text;

    private String state;

    public TreeNode(long id,String text, String state) {

        this.text = text;
        this.id = id;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
