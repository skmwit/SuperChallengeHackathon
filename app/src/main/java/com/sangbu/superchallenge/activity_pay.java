package com.sangbu.superchallenge;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

import static com.sangbu.superchallenge.MainActivity.bt;

public class activity_pay extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    String menu;
    int count = 1;

    TextView textView;
    Button button;
    TextView layout;

    boolean isChk = false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pay);
        intent = getIntent();

        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                int chk = Integer.parseInt(message);
                switch (chk) {
                    case 0:
                        isFinish();
                        break;
                    case 1:
                        pushBtn(true);
                        break;
                    case 2:
                        pushBtn(false);
                        break;
                    case 4:
                        decideBtn();
                }
            }
        });

        menu = intent.getStringExtra("result");

        textView = (TextView) findViewById(R.id.burgerinfo);
        textView.setText(menu + " " + String.valueOf(count) + "개");

        button = findViewById(R.id.btnAlert);
        button.setOnClickListener(this);

        layout = findViewById(R.id.layout);
        layout.setVisibility(View.INVISIBLE);
    }

    private void isFinish() {
        if(isChk){
            isChk = false;
            layout.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(getApplicationContext(), activity_menubar.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivityForResult(intent, 117);
        }
        else
        {
            finish();

        }

    }

    private void decideBtn() {
        if(isChk){
            isChk = false;
            layout.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(getApplicationContext(), final_.class);
            startActivity(intent);
        }
        else
        {
            button.performClick();
        }
    }

    private void pushBtn(boolean b) {

        if(b)
        {
            count++;
            textView.setText(menu + " " + String.valueOf(count) + "개");
        }
        else
        {
            count--;
            if(count < 1)
            {
                count = 1;
            }
            else{
                textView.setText(menu + " " + String.valueOf(count) + "개");
            }
        }
    }


    @Override
    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnAlert:
                    isChk = true;
                    layout.setVisibility(View.VISIBLE);
            }
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                int chk = Integer.parseInt(message);
                switch (chk) {
                    case 0:
                        isFinish();
                        break;
                    case 1:
                        pushBtn(true);
                        break;
                    case 2:
                        pushBtn(false);
                        break;
                    case 4:
                        decideBtn();
                }
            }
        });
    }
}
