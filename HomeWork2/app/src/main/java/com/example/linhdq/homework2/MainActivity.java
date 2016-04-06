package com.example.linhdq.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button addNewStudent, viewStudent, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getEventControl();
    }

    public void getEventControl(){
        addNewStudent=(Button)findViewById(R.id.addNewStudent);
        viewStudent=(Button)findViewById(R.id.viewStudent);
        exit=(Button)findViewById(R.id.exit);
        addNewStudent.setOnClickListener(this);
        viewStudent.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addNewStudent:{
                Intent t=new Intent(this,Add_Student_Activity.class);
                startActivity(t);
                break;
            }
            case R.id.viewStudent:{
                Intent t=new Intent(this, viewStudent.class);
                startActivity(t);
                break;
            }
            case R.id.exit:{
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
    }
}
