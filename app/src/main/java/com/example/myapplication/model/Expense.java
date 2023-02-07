package com.example.myapplication.model;

public class Expense {
    private int expense_id;
    private String expense_name;
    private int cate_id;
    private String description;
    private Float amount;

    public Expense() {
    }

    public Expense(int expense_id, String expense_name, int cate_id, String description, Float amount) {
        this.expense_id = expense_id;
        this.expense_name = expense_name;
        this.cate_id = cate_id;
        this.description = description;
        this.amount = amount;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public String getExpense_name() {
        return expense_name;
    }

    public void setExpense_name(String expense_name) {
        this.expense_name = expense_name;
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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
