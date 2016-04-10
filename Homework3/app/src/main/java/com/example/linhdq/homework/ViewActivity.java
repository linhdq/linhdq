package com.example.linhdq.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnAddNew, btnBackMain;
    EmployeeManager employeeManager;
    ArrayList<Employee> employeeArrayList;
    Employee e;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        connectViewControl();
        employeeManager = EmployeeManager.getInst();
        employeeArrayList = employeeManager.getEmployees();
        setData();
        getSupportActionBar().hide();
    }

    void connectViewControl() {
        btnAddNew = (Button) findViewById(R.id.btnAddNew);
        btnAddNew.setOnClickListener(this);
        btnBackMain = (Button) findViewById(R.id.btnBack_View);
        btnBackMain.setOnClickListener(this);
        listView=(ListView)findViewById(R.id.listView);

    }

    void setData() {
        listView.setAdapter(new CustomView(this, employeeArrayList));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddNew: {
                Intent t = new Intent(this, AddActivity.class);
                startActivity(t);
                break;
            }
            case R.id.btnBack_View: {
                Intent t = new Intent(this, MainActivity.class);
                startActivity(t);
                break;
            }
            default:
                break;
        }
    }
}
