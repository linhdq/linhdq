package com.example.linhdq.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txt11, txt12, txt21, txt22, txt31, txt32, txt41, txt42, txt51, txt52;
    TextView txt61, txt62, txt71, txt72, txt81, txt82, txt91, txt92, txt101, txt102;
    Button btnAddNew, btnBackMain;
    EmployeeManager employeeManager;
    ArrayList<Employee> employeeArrayList;
    Employee e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        connectViewControl();
        employeeManager = EmployeeManager.getInst();
        employeeArrayList = employeeManager.getEmployees();
        setData();
    }

    void connectViewControl() {
        btnAddNew = (Button) findViewById(R.id.btnAddNew);
        btnAddNew.setOnClickListener(this);
        btnBackMain = (Button) findViewById(R.id.btnBack_View);
        btnBackMain.setOnClickListener(this);
        txt11 = (TextView) findViewById(R.id.txt1_1);
        txt12 = (TextView) findViewById(R.id.txt1_2);
        txt21 = (TextView) findViewById(R.id.txt2_1);
        txt22 = (TextView) findViewById(R.id.txt2_2);
        txt31 = (TextView) findViewById(R.id.txt3_1);
        txt32 = (TextView) findViewById(R.id.txt3_2);
        txt41 = (TextView) findViewById(R.id.txt4_1);
        txt42 = (TextView) findViewById(R.id.txt4_2);
        txt51 = (TextView) findViewById(R.id.txt5_1);
        txt52 = (TextView) findViewById(R.id.txt5_2);
        txt61 = (TextView) findViewById(R.id.txt6_1);
        txt62 = (TextView) findViewById(R.id.txt6_2);
        txt71 = (TextView) findViewById(R.id.txt7_1);
        txt72 = (TextView) findViewById(R.id.txt7_2);
        txt81 = (TextView) findViewById(R.id.txt8_1);
        txt82 = (TextView) findViewById(R.id.txt8_2);
        txt91 = (TextView) findViewById(R.id.txt9_1);
        txt92 = (TextView) findViewById(R.id.txt9_2);
        txt101 = (TextView) findViewById(R.id.txt10_1);
        txt102 = (TextView) findViewById(R.id.txt10_2);

    }

    void setData() {
        if(employeeArrayList.size()==0){
            txt12.setText("Data is empty!");
            return;
        }
        if (employeeArrayList.size() >= 1 && (e = employeeArrayList.get(0)) != null) {
            txt11.setText(e.getName());
            txt12.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
        if (employeeArrayList.size() >= 2 && (e = employeeArrayList.get(1)) != null) {
            txt21.setText(e.getName());
            txt22.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
        if (employeeArrayList.size() >= 3 && (e = employeeArrayList.get(2)) != null) {
            txt31.setText(e.getName());
            txt32.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
        if (employeeArrayList.size() >= 4 && (e = employeeArrayList.get(3)) != null) {
            txt41.setText(e.getName());
            txt42.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
        if (employeeArrayList.size() >= 5 && (e = employeeArrayList.get(4)) != null) {
            txt51.setText(e.getName());
            txt52.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
        if (employeeArrayList.size() >= 6 && (e = employeeArrayList.get(5)) != null) {
            txt61.setText(e.getName());
            txt62.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
        if (employeeArrayList.size() >= 7 && (e = employeeArrayList.get(6)) != null) {
            txt71.setText(e.getName());
            txt72.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
        if (employeeArrayList.size() >= 8 && (e = employeeArrayList.get(7)) != null) {
            txt81.setText(e.getName());
            txt82.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
        if (employeeArrayList.size() >= 9 && (e = employeeArrayList.get(8)) != null) {
            txt91.setText(e.getName());
            txt92.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
        if (employeeArrayList.size() >= 10 && (e = employeeArrayList.get(9)) != null) {
            txt101.setText(e.getName());
            txt102.setText("Age: " + e.getAge() + " - Gender: " + e.getGender() + " - Birth place: " + e.getBirthPlace());
        }
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
