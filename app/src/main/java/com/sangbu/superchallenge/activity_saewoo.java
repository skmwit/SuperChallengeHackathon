package com.sangbu.superchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

import static com.sangbu.superchallenge.MainActivity.bt;
import static com.sangbu.superchallenge.MainActivity.tts;

public class activity_saewoo extends AppCompatActivity {

    private int btncurt = 0;
    ImageButton saewooBurger, shoobeBurger;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_saewoo);

        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                int chk = Integer.parseInt(message);
                switch (chk) {
                    case 0:
                        finish();
                        break;
                    case 1:
                        pushBtn();
                        break;
                    case 2:
                        pushBtn();
                        break;
                    case 4:
                        decideBtn();
                }
            }
        });

        saewooBurger = findViewById(R.id.sbrg);
        shoobeBurger = findViewById(R.id.shoobebrg);

        saewooBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),activity_pay.class);
                intent1.putExtra("result", "새우버거");
                startActivity(intent1);
            }
        });

        shoobeBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),activity_pay.class);
                intent2.putExtra("result", "슈비버거");
                startActivity(intent2);
            }
        });


        saewooBurger.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
        tts.speak("새우버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
    }

    private void decideBtn() {
        switch (btncurt) {
            case 0:
                saewooBurger.performClick();
                break;
            case 1:
                shoobeBurger.performClick();
                break;
        }
    }

    private void pushBtn() {
        switch (btncurt) {
            case 0:
                saewooBurger.setBackgroundDrawable(null);
                shoobeBurger.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                tts.speak("슈비버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                btncurt = 1;
                break;

            case 1:
                shoobeBurger.setBackgroundDrawable(null);
                saewooBurger.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                tts.speak("새우버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                btncurt = 0;
                break;
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
                        finish();
                        break;
                    case 1:
                        pushBtn();
                        break;
                    case 2:
                        pushBtn();
                        break;
                    case 4:
                        decideBtn();
                }
            }
        });
    }
}