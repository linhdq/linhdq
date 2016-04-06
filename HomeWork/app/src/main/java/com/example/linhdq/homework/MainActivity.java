package com.example.linhdq.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnB1, btnB2, btnB3, btnB4, btnB5, btnB6;
    Button btnR1, btnR2, btnR3, btnR4, btnR5, btnR6, btnR7;
    Button btnG1, btnG2, btnG3, btnG4, btnG5, btnG6, btnG7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectButton();

        btnB1.setOnClickListener(this);
        btnB2.setOnClickListener(this);
        btnB3.setOnClickListener(this);
        btnB4.setOnClickListener(this);
        btnB5.setOnClickListener(this);
        btnB6.setOnClickListener(this);

        btnR1.setOnClickListener(this);
        btnR2.setOnClickListener(this);
        btnR3.setOnClickListener(this);
        btnR4.setOnClickListener(this);
        btnR5.setOnClickListener(this);
        btnR6.setOnClickListener(this);
        btnR7.setOnClickListener(this);

        btnG1.setOnClickListener(this);
        btnG2.setOnClickListener(this);
        btnG3.setOnClickListener(this);
        btnG4.setOnClickListener(this);
        btnG5.setOnClickListener(this);
        btnG6.setOnClickListener(this);
        btnG7.setOnClickListener(this);


    }

    public void connectButton() {
        //button Blue
        btnB1 = (Button) findViewById(R.id.btnB1);
        btnB2 = (Button) findViewById(R.id.btnB2);
        btnB3 = (Button) findViewById(R.id.btnB3);
        btnB4 = (Button) findViewById(R.id.btnB4);
        btnB5 = (Button) findViewById(R.id.btnB5);
        btnB6 = (Button) findViewById(R.id.btnB6);
        //button Red
        btnR1 = (Button) findViewById(R.id.btnR1);
        btnR2 = (Button) findViewById(R.id.btnR2);
        btnR3 = (Button) findViewById(R.id.btnR3);
        btnR4 = (Button) findViewById(R.id.btnR4);
        btnR5 = (Button) findViewById(R.id.btnR5);
        btnR6 = (Button) findViewById(R.id.btnR6);
        btnR7 = (Button) findViewById(R.id.btnR7);
        //button Green
        btnG1 = (Button) findViewById(R.id.btnG1);
        btnG2 = (Button) findViewById(R.id.btnG2);
        btnG3 = (Button) findViewById(R.id.btnG3);
        btnG4 = (Button) findViewById(R.id.btnG4);
        btnG5 = (Button) findViewById(R.id.btnG5);
        btnG6 = (Button) findViewById(R.id.btnG6);
        btnG7 = (Button) findViewById(R.id.btnG7);
    }

    public void goToRed() {
        Intent t = new Intent(this, RedActivity.class);
        startActivity(t);
    }

    public void goToBlue() {
        Intent t = new Intent(this, BlueActivity.class);
        startActivity(t);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnR1:{
                goToRed();
                break;
            }
            case R.id.btnR2:{
                goToRed();
                break;
            }
            case R.id.btnR3:{
                goToRed();
                break;
            }
            case R.id.btnR4:{
                goToRed();
                break;
            }
            case R.id.btnR5:{
                goToRed();
                break;
            }
            case R.id.btnR6:{
                goToRed();
                break;
            }
            case R.id.btnR7:{
                goToRed();
                break;
            }
            case R.id.btnB1:{
                goToBlue();
                break;
            }
            case R.id.btnB2:{
                goToBlue();
                break;
            }
            case R.id.btnB3:{
                goToBlue();
                break;
            }
            case R.id.btnB4:{
                goToBlue();
                break;
            }
            case R.id.btnB5:{
                goToBlue();
                break;
            }
            case R.id.btnB6:{
                goToBlue();
                break;
            }
        }
    }
}
