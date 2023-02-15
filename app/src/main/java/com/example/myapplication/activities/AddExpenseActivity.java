package com.example.myapplication.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.myapplication.R;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddExpenseActivity extends AppCompatActivity {
    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add new expense");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_add_expense);

        dateButton = this.findViewById(R.id.btnDatePicker);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateButton.setText(MessageFormat.format("{0}/{1}/{2}", String.valueOf(i2), String.valueOf(i1 + 1), String.valueOf(i)));
                    }
                }, year, month, day);
            }
        });
//        dateButton.setText(getTodayDate());
    }

    private String getTodayDate(){
        return formatter.format(date);
    }

    private String getYesterdayDate(){
        Date selectedDate = new Date(date.getTime() - MILLIS_IN_A_DAY);
        return formatter.format(selectedDate);
    }

//    private void initDatePicker(){
//        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
////                dateButton.setText(strDate);
//            }
//        };
//
//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//
//        int style = AlertDialog.THEME_HOLO_LIGHT;
//
//        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
//    }
//    public void openDialogDatePicker(View view) {
//        datePickerDialog.show();
//    }
}