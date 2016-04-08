package com.example.linhdq.homework;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        DatePickerDialog.OnDateSetListener, View.OnClickListener {
    EditText txtName;
    RadioButton radioMale, radioFemale;
    Spinner birthPlace;
    Button btnAdd, btnbirthDay, btnBack;
    String birth_place;
    EmployeeManager employeeManager;
    Calendar c;
    SimpleDateFormat simpleDateFormat;
    CheckBox cbMusic, cbMovie, cbShopping, cbOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        employeeManager = EmployeeManager.getInst();
        c = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("MM / dd / yyyy");
        connectControl();
        setDataToControl();
    }

    void connectControl() {
        txtName = (EditText) findViewById(R.id.txtName);
        radioMale = (RadioButton) findViewById(R.id.radioMale);
        radioFemale = (RadioButton) findViewById(R.id.radioFemale);
        radioMale.setChecked(true);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnbirthDay = (Button) findViewById(R.id.btnbirthDay);
        btnbirthDay.setText(simpleDateFormat.format(c.getTime()));
        btnbirthDay.setOnClickListener(this);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
        cbMovie = (CheckBox) findViewById(R.id.cbMovie);
        cbMusic = (CheckBox) findViewById(R.id.cbMusic);
        cbOther = (CheckBox) findViewById(R.id.cbOther);
        cbShopping = (CheckBox) findViewById(R.id.cbShopping);
        birthPlace = (Spinner) findViewById(R.id.birthPlace);

    }

    void displayMessage(String mess) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, mess, Toast.LENGTH_SHORT);
        toast.show();
    }

    boolean addEmployee() {
        String name = txtName.getText().toString();
        String gender;
        String birthDay;
        String hobby = "";
        int age = 0;
        if (radioMale.isChecked()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        birthDay = btnbirthDay.getText().toString();
        try {
            Date dateBirth = simpleDateFormat.parse(birthDay);
            Date now = simpleDateFormat.parse(simpleDateFormat.format(c.getTime()));
            age = now.getYear() - dateBirth.getYear() + 1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (cbMusic.isChecked()) {
            hobby += "Music ";
        }
        if (cbMovie.isChecked()) {
            hobby += "Movie ";
        }
        if (cbShopping.isChecked()) {
            hobby += "Shopping ";
        }
        if (cbOther.isChecked()) {
            hobby += "Other";
        }
        if (name != null && !name.trim().equals("")) {
            Employee e = new Employee(name, gender, age, birth_place, hobby);
            employeeManager.addEmployee(e);
            txtName.setText("");
            displayMessage(name + " is added!");
            return true;
        } else {
            displayMessage("Name can not be empty!");
        }
        return false;
    }

    void setDataToControl() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.place, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        birthPlace.setAdapter(adapter);
        birthPlace.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        birth_place = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        btnbirthDay.setText((monthOfYear + 1) + " / " + dayOfMonth + " / " + year);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, this, 1995, 01, 01);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd: {
                if (addEmployee()) {
                    Intent t = new Intent(this, ViewActivity.class);
                    startActivity(t);
                }
                break;
            }
            case R.id.btnbirthDay: {
                showDialog(1);
                break;
            }
            case R.id.btnBack: {
                Intent t = new Intent(this, MainActivity.class);
                startActivity(t);
                break;
            }
            default:
                break;
        }
    }
}
