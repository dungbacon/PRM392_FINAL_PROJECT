package com.example.myapplication.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.activities.MainActivity;
import com.example.myapplication.adapter.ExpensesAdapter;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.model.Expense;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ArrayList<Expense> mExpenseList ;
    private RecyclerView mRecyclerView;
    private ExpensesAdapter mExpenseAdapter ;
    private FragmentHomeBinding binding;

    private int totalExpenses = 0;
    private int currentBalance = 0;
    private int totalIncome = 0;
    private TextView expenseStat;
    private TextView balanceStat;
    private TextView incomeStat;

    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        mRecyclerView = root.findViewById(R.id.expensesRecyclerView);
        mExpenseList = new ArrayList<>();
        mExpenseAdapter = new ExpensesAdapter(MainActivity.expensesList, getContext());
        mRecyclerView.setAdapter(mExpenseAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        expenseStat = root.findViewById(R.id.expenseStat);
        balanceStat = root.findViewById(R.id.balanceStat);
        incomeStat = root.findViewById(R.id.incomeStat);

        MainActivity.expensesList.forEach((item) -> {
            int catType = MainActivity.getCategoryById(item.getCate_id()).getType();
            if(catType == 1)
                totalIncome += item.getAmount();
            if(catType == 2)
                totalExpenses += item.getAmount();
        });
        currentBalance = totalIncome - totalExpenses;


        expenseStat.setText( MainActivity.intToMoneyFormat(totalExpenses));
        balanceStat.setText( MainActivity.intToMoneyFormat(currentBalance));
        incomeStat.setText( MainActivity.intToMoneyFormat(totalIncome));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}