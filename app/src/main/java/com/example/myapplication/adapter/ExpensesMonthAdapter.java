package com.example.myapplication.adapter;

import android.content.Context;
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

import java.util.ArrayList;

public class ExpensesMonthAdapter extends RecyclerView.Adapter<ExpensesMonthAdapter.ViewHolder> {

    private final ArrayList<Expense> expenseList;
    private Context context;

    public ExpensesMonthAdapter(ArrayList<Expense> expenseList, Context context) {
        this.expenseList = expenseList;
        this.context = context;
    }

    @NonNull
    @Override
    public ExpensesMonthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View mExpensesDateItemView = mInflater.inflate(R.layout.expense_date_item, parent, false);
        return new ViewHolder(mExpensesDateItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpensesMonthAdapter.ViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        Category category = MainActivity.getCategoryById(expense.getCate_id());
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ExpensesMonthAdapter mAdapter;
        private TextView headingDate;
        private TextView headingTotal;
        public ViewHolder(@NonNull View itemView, ExpensesMonthAdapter expensesMonthAdapter) {
            super(itemView);
            this.mAdapter = expensesMonthAdapter;
            this.headingDate = itemView.findViewById(R.id.expenseDateDate);
            this.headingTotal = itemView.findViewById(R.id.expenseDateTotal);
        }
    }
}
