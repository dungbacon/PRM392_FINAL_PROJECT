package com.example.myapplication.model;

import java.util.List;

public class Category {
    private int cate_id;
    private String cate_name;
    private List<Category> child_cate;

    public Category() {
    }

    public Category(int cate_id, String cate_name, List<Category> child_cate) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
        this.child_cate = child_cate;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public List<Category> getChild_cate() {
        return child_cate;
    }

    public void setChild_cate(List<Category> child_cate) {
        this.child_cate = child_cate;
    }
}
