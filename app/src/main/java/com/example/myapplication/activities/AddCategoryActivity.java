package com.example.myapplication.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityAddCategoryBinding;
import com.example.myapplication.model.Category;
import com.example.myapplication.utils.DBHelper;

public class AddCategoryActivity extends AppCompatActivity {

    ActivityAddCategoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        binding = ActivityAddCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar2);
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        binding.btnAddCategory.setOnClickListener(view -> {
            String categoryName = binding.etCategoryName.getText().toString();
            if(categoryName.isEmpty()){
                binding.ilCategoryName.setError("Please Enter Category Name");
            }else{
                DBHelper.addCategory(new Category(categoryName));
                finish();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        onBackPressed();
        return true;
    }
}
