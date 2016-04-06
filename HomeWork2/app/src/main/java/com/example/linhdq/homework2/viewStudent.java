package com.example.linhdq.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class viewStudent extends AppCompatActivity {
    Student_Management student_management;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        final Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backActivity();
            }
        });
        displayData();

    }
    public void backActivity(){
        Intent t=new Intent(this,MainActivity.class);
        startActivity(t);
    }

    public void displayData(){
        student_management=Student_Management.getInstance();
        TextView txtView=(TextView)findViewById(R.id.txtView);
        txtView.setText(student_management.readFromFile());
    }
}
