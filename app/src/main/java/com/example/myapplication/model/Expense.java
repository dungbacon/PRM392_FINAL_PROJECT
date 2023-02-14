package com.example.myapplication.model;

import java.util.Date;

public class Expense {
    private int expense_id;
    private int cate_id;
    private String description;
    private int amount;

    private Date createAt;

    public Expense() {
    }

    public Expense(int expense_id, int cate_id, String description, int amount, Date createAt) {
        this.expense_id = expense_id;
        this.cate_id = cate_id;
        this.description = description;
        this.amount = amount;
        this.createAt = createAt;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
