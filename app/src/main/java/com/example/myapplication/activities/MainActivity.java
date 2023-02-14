package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.model.Category;
import com.example.myapplication.model.Expense;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Category> categoriesList = new ArrayList<>();
    public static ArrayList<Expense> expensesList = new ArrayList<>();

    public static Category getCategoryById(int id){
        return categoriesList.stream().filter((item) -> item.getCate_id() == id).findFirst().get();
    }

    public static String intToMoneyFormat(int amount){
        return String.format("%,d", amount) + " đ";
    }

    private void initFakeData(){
        categoriesList.add(new Category(1, "Shopping", -1, 2));
        categoriesList.add(new Category(2, "Food & Beverage", -1, 2));
        categoriesList.add(new Category(3, "Transport", -1, 2));
        categoriesList.add(new Category(4, "Bills & Utilities", -1, 2));
        categoriesList.add(new Category(5, "Other", -1, 2));

        expensesList.add(new Expense(1, 1, "Denim jacket", 499000, new Date()));
        expensesList.add(new Expense(2, 2, "Bún đậu", 40000, new Date()));
        expensesList.add(new Expense(3, 2, "Le Monde Steak", 650000, new Date()));
        expensesList.add(new Expense(4, 3, "Bus", 18000, new Date()));
        expensesList.add(new Expense(5, 4, "Thuê trọ tháng 2", 1892000, new Date()));
        expensesList.add(new Expense(6, 1, "Denim jacket", 499000, new Date()));
        expensesList.add(new Expense(7, 2, "Bún đậu", 40000, new Date()));
        expensesList.add(new Expense(8, 2, "Le Monde Steak", 650000, new Date()));
        expensesList.add(new Expense(9, 3, "Bus", 18000, new Date()));
        expensesList.add(new Expense(10, 4, "Thuê trọ tháng 2", 1892000, new Date()));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFakeData();

        setContentView(R.layout.activity_navigation);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


    }
}