package com.example.myapplication.activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.adapter.CategoriesAdapter;
import com.example.myapplication.databinding.ActivityCategoriesBinding;
import com.example.myapplication.model.Category;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CategoriesActivity extends AppCompatActivity {

    ActivityCategoriesBinding binding;

    CategoriesAdapter categoriesAdapter;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        /*FirebaseRecyclerOptions<Category>options =new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery()*/
        /*categoriesAdapter = new CategoriesAdapter(getApplicationContext())*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        onBackPressed();
        return true;
    }

    @Override
    protected void onStart(){
        super.onStart();
        categoriesAdapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        categoriesAdapter.stopListening();
    }

}
