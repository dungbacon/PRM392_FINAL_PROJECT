package com.example.myapplication.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.example.myapplication.activities.AddExpenseActivity;
import com.example.myapplication.activities.MainActivity;
import com.example.myapplication.adapter.ExpensesDayAdapter;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.example.myapplication.model.Expense;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ArrayList<Expense> mExpenseList ;
    private RecyclerView mRecyclerView;
    private ExpensesDayAdapter mExpenseAdapter ;
    private FragmentHomeBinding binding;

    private int totalExpenses = 0;
    private int currentBalance = 0;
    private int totalIncome = 0;
    private TextView expenseStat;
    private TextView balanceStat;
    private TextView incomeStat;

    private ExtendedFloatingActionButton addExpenseFab;

    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        addExpenseFab = root.findViewById(R.id.addExpenseFab);
        addExpenseFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddExpenseActivity.class);
//            intent.putExtra("userId", 0);
                startActivity(intent);
            }
        });

//        mRecyclerView = root.findViewById(R.id.expensesRecyclerView);
//        mExpenseList = new ArrayList<>();
//        mExpenseAdapter = new ExpensesDayAdapter(MainActivity.expensesList, getContext());
//        mRecyclerView.setAdapter(mExpenseAdapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));



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