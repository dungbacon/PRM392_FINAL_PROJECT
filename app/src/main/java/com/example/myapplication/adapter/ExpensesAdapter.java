package com.example.myapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activities.MainActivity;
import com.example.myapplication.model.Category;
import com.example.myapplication.model.Expense;
import com.example.myapplication.ui.home.HomeFragment;

import java.util.ArrayList;

public class ExpensesAdapter extends RecyclerView.Adapter<ExpensesAdapter.ViewHolder> {

    private final ArrayList<Expense> expenseList;
    private Context context;

    public ExpensesAdapter(ArrayList<Expense> expenseList, Context context) {
        this.expenseList = expenseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExpensesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View mExpensesItemView = mInflater.inflate(R.layout.dashboard_expense_item, parent, false);
        return new ViewHolder(mExpensesItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpensesAdapter.ViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        Category category = MainActivity.getCategoryById(expense.getCate_id());

        holder.catTitle.setText(category.getCate_name());
        holder.description.setText(expense.getDescription());
        holder.price.setText(MainActivity.intToMoneyFormat(expense.getAmount()));

        if(category.getType() == 1)
            holder.price.setTextColor(ContextCompat.getColor(context, R.color.green_income));
        else
            if(category.getType() == 2) {
                holder.price.setTextColor(ContextCompat.getColor(context, R.color.red_expense));
            }
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ExpensesAdapter mAdapter;

        private ImageView catIcon;
        private TextView catTitle;
        private TextView description;
        private TextView price;
        public ViewHolder(@NonNull View itemView, ExpensesAdapter expensesAdapter) {
            super(itemView);
            this.mAdapter = expensesAdapter;
            catIcon = itemView.findViewById(R.id.expenseCatIcon);
            catTitle = itemView.findViewById(R.id.expenseCatTitle);
            description = itemView.findViewById(R.id.expenseDes);
            price = itemView.findViewById(R.id.expensePrice);
        }
    }
}
