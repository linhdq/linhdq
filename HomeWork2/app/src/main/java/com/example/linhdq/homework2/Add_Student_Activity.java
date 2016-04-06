package com.example.linhdq.homework2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Calendar;

public class Add_Student_Activity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    Button btnBirthday, btnSave, btnBackMain;
    RadioButton radioMale, radioFemale;
    CheckBox cbMusic, cbShopping, cbMovie, cbOther;
    EditText txtName, txtClass;
    Spinner birthPlace;
    DatePickerDialog.OnDateSetListener dateSetListener;
    Calendar calendar;
    Student_Management student_management;
    int year, month, day;
    String birth_place="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student_);
        getEventControl();
        getCurrentTime();
        changeDate();
        student_management = Student_Management.getInstance();
    }

    public void getEventControl() {
        btnBirthday = (Button) findViewById(R.id.btnBirthday);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnBackMain = (Button) findViewById(R.id.btnBackMain);
        radioMale = (RadioButton) findViewById(R.id.radioMale);
        cbMovie = (CheckBox) findViewById(R.id.cbMovie);
        cbMusic = (CheckBox) findViewById(R.id.cbMusic);
        cbShopping = (CheckBox) findViewById(R.id.cbShopping);
        cbOther = (CheckBox) findViewById(R.id.cbOther);
        radioFemale = (RadioButton) findViewById(R.id.radioFemale);
        txtClass = (EditText) findViewById(R.id.txtClass);
        txtName = (EditText) findViewById(R.id.txtName);
        birthPlace = (Spinner) findViewById(R.id.birth_place);
        btnBirthday.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnBackMain.setOnClickListener(this);
        radioMale.setChecked(true);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.birth_place, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        birthPlace.setAdapter(adapter);
        birthPlace.setOnItemSelectedListener(this);
    }

    public void getCurrentTime() {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        btnBirthday.setText(day + " / " + month + " / " + year);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 1) {
            return new DatePickerDialog(this, dateSetListener, year, month, day);
        }
        return null;
    }

    public void changeDate() {
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year_, int monthOfYear, int dayOfMonth) {
                year = year_;
                month = monthOfYear+1;
                day = dayOfMonth;
                String txt = dayOfMonth + " / " + (monthOfYear+1) + " / " + year;
                btnBirthday.setText(txt);
            }
        };

    }

    public boolean saveData() {
        if (student_management.checkStudentInfor(txtName.getText().toString(),
                txtClass.getText().toString(), birth_place)) {
            String hobby = "";
            if (cbMusic.isChecked()) {
                hobby += cbMusic.getText().toString() + " ";
            }
            if (cbMovie.isChecked()) {
                hobby += cbMovie.getText().toString() + " ";
            }
            if (cbShopping.isChecked()) {
                hobby += cbShopping.getText().toString() + " ";
            }
            if (cbOther.isChecked()) {
                hobby += cbOther.getText().toString();
            }
            String gender = "";
            if (radioMale.isChecked()) {
                gender = radioMale.getText().toString();
            } else {
                gender = radioFemale.getText().toString();
            }
            Student student = new Student(txtName.getText().toString(), txtClass.getText().toString(),
                    btnBirthday.getText().toString(), birth_place,
                    hobby, gender);

            return student_management.writeToFile(student);
        }

        return false;
    }

    public void setEmpty() {
        txtName.setText("");
        txtClass.setText("");
        cbOther.setChecked(false);
        cbShopping.setChecked(false);
        cbMovie.setChecked(false);
        cbMusic.setChecked(false);
    }

    public void displayMessage(String mess){
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, mess, Toast.LENGTH_SHORT);
        toast.show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBirthday: {
                showDialog(1);
                break;
            }
            case R.id.btnBackMain: {
                Intent t=new Intent(this, MainActivity.class);
                startActivity(t);
                break;
            }
            case R.id.btnSave: {
                if(saveData()){
                    setEmpty();
                    displayMessage("Student information was successful saved!");
                }else{
                    displayMessage("All fields must be non-blank!");
                }
                break;
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        birth_place=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
