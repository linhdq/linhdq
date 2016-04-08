package com.example.linhdq.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAddNewEmployee, btnViewEmployeeList, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAddNewEmployee = (Button) findViewById(R.id.btnAddEmployee);
        btnAddNewEmployee.setOnClickListener(this);
        btnViewEmployeeList = (Button) findViewById(R.id.btnViewEmployeeList);
        btnViewEmployeeList.setOnClickListener(this);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddEmployee: {
                Intent t = new Intent(this, AddActivity.class);
                startActivity(t);
                break;
            }
            case R.id.btnViewEmployeeList: {
                Intent t = new Intent(this, ViewActivity.class);
                startActivity(t);
                break;
            }
            case R.id.btnExit: {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            }
        }
    }
}
