package com.example.linhdq.homework04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_doraemon;
    private Button btn_shizuka;
    private Button btn_nobita;
    private Button btn_show;
    private Button btn_hide;
    private RelativeLayout rLayout_nobita, rLayout_doraemon, rLayout_shizuka;
    private FrameLayout.LayoutParams params_shizuka, params_doraemon,
            params_nobita, params_shizuka_temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        manageControl();
    }

    private void manageControl() {
        btn_doraemon = (Button) findViewById(R.id.btnExitDoraemon);
        btn_nobita = (Button) findViewById(R.id.btnExitNobita);
        btn_shizuka = (Button) findViewById(R.id.btnExitShizuka);
        btn_hide = (Button) findViewById(R.id.btnHide);
        btn_show = (Button) findViewById(R.id.btnShow);
        rLayout_doraemon = (RelativeLayout) findViewById(R.id.doraemonLayout);
        rLayout_nobita = (RelativeLayout) findViewById(R.id.nobitaLayout);
        rLayout_shizuka = (RelativeLayout) findViewById(R.id.shizukaLayout);
        params_shizuka_temp = params_shizuka = (FrameLayout.LayoutParams) rLayout_shizuka.getLayoutParams();
        params_nobita= (FrameLayout.LayoutParams) rLayout_nobita.getLayoutParams();
        params_doraemon = (FrameLayout.LayoutParams) rLayout_doraemon.getLayoutParams();
        btn_doraemon.setOnClickListener(this);
        btn_shizuka.setOnClickListener(this);
        btn_nobita.setOnClickListener(this);
        btn_show.setOnClickListener(this);
        btn_hide.setOnClickListener(this);
    }
    private void changeMarginLayout(RelativeLayout layout) {
        if (layout == rLayout_doraemon) {
            if (rLayout_shizuka.getVisibility() == View.VISIBLE) {
                rLayout_shizuka.setLayoutParams(params_doraemon);
                if (rLayout_nobita.getVisibility() == View.VISIBLE) {
                    rLayout_nobita.setLayoutParams(params_shizuka);
                }
            } else if (rLayout_nobita.getVisibility() == View.VISIBLE) {
                rLayout_nobita.setLayoutParams(params_doraemon);
            }
            return;
        }
        if (layout == rLayout_shizuka) {
            if (rLayout_doraemon.getVisibility() == View.VISIBLE) {
                rLayout_nobita.setLayoutParams(params_shizuka);
            } else {
                rLayout_nobita.setLayoutParams(params_doraemon);
            }
            return;
        }
    }

    private void restoreMarginLayout() {
        rLayout_nobita.setLayoutParams(params_nobita);
        rLayout_shizuka.setLayoutParams(params_shizuka_temp);
    }

    private void setVisible(int visible) {
        rLayout_nobita.setVisibility(visible);
        rLayout_shizuka.setVisibility(visible);
        rLayout_doraemon.setVisibility(visible);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnExitNobita: {
                rLayout_nobita.setVisibility(View.GONE);
                break;
            }
            case R.id.btnExitDoraemon: {
                rLayout_doraemon.setVisibility(View.GONE);
                changeMarginLayout(rLayout_doraemon);
                break;
            }
            case R.id.btnExitShizuka: {
                rLayout_shizuka.setVisibility(View.GONE);
                changeMarginLayout(rLayout_shizuka);
                break;
            }
            case R.id.btnShow: {
                restoreMarginLayout();
                setVisible(View.VISIBLE);
                break;
            }
            case R.id.btnHide: {
                setVisible(View.GONE);
                break;
            }

        }
    }
}
