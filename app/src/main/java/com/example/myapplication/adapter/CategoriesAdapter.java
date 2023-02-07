package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.myapplication.activities.CategoriesActivity;
import com.example.myapplication.databinding.RowCategoriesBinding;
import com.example.myapplication.model.Category;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CategoriesAdapter extends FirebaseRecyclerAdapter<Category, CategoriesAdapter.CategoryViewHolder> {

    Context mContext;

    public CategoriesAdapter(@NonNull FirebaseRecyclerOptions<Category> options, Context mContext) {
        super(options);
        this.mContext = mContext;
    }

    @Override
    protected void onBindViewHolder(@NonNull CategoryViewHolder holder, int position, @NonNull Category model) {
        holder.binding.tvCategoryName.setText(model.getCate_name());
        holder.binding.btnCategoryEdit.setOnClickListener(view -> {
            /*Intent intent = new Intent(mContext,)*/
        });
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryViewHolder(RowCategoriesBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }


    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        RowCategoriesBinding binding;
        public CategoryViewHolder(RowCategoriesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
