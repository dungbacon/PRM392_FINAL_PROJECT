package com.example.myapplication.model;

import java.util.List;

public class Category {
    private int cate_id;
    private String cate_name;
    private int parent_cate_id;
    private String icon_name;

    private int type;
    /*
        1. Income
        2. Outcome
        3. Loan / Debt
     */

    public Category(String cate_name) {
        this.cate_name = cate_name;
    }

    public Category(int cate_id, String cate_name, int parent_cate_id, int type) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
        this.parent_cate_id = parent_cate_id;
        this.type = type;;
        this.icon_name = icon_name;
//        this.child_cate = child_cate;
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

    public int getParent_cate_id() {
        return parent_cate_id;
    }

    public void setParent_cate_id(int parent_cate_id) {
        this.parent_cate_id = parent_cate_id;
    }

    public String getIcon_name() {
        return icon_name;
    }

    public void setIcon_name(String icon_name) {
        this.icon_name = icon_name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
