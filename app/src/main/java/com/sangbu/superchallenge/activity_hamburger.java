package com.sangbu.superchallenge;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

import static com.sangbu.superchallenge.MainActivity.bt;
import static com.sangbu.superchallenge.MainActivity.tts;

public class activity_hamburger extends AppCompatActivity {

    int btncurt = 0;

    ImageButton bulgogi, chicken, saewoo, plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_hamburger);

        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                int chk = Integer.parseInt(message);
                switch (chk) {
                    case 0:
                        finish();
                        break;
                    case 1:
                        pushBtn(false);
                        break;
                    case 2:
                        pushBtn(true);
                        break;
                    case 4:
                        decideBtn();
                }
            }
        });

        bulgogi = findViewById(R.id.bulgogi);
        chicken = findViewById(R.id.chicken);
        saewoo = findViewById(R.id.saewoo);
        plus = findViewById(R.id.plus);


        bulgogi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),activity_bulgogi.class);
                startActivityForResult(intent2, 107);
            }
        });

        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),activity_chicken.class);
                startActivityForResult(intent2, 108);
            }
        });
        saewoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),activity_saewoo.class);
                startActivityForResult(intent2, 109);
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(),activity_plus.class);
                startActivityForResult(intent2, 110);
            }
        });

        bulgogi.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
        tts.speak("불고기 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
    }

    private void pushBtn(boolean b) {
        if (b) {
            switch (btncurt) {
                case 0:
                    bulgogi.setBackgroundDrawable(null);
                    chicken.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("치킨 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    break;
                case 1:
                    chicken.setBackgroundDrawable(null);
                    saewoo.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("새우 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    break;
                case 2:
                    saewoo.setBackgroundDrawable(null);
                    plus.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("일반 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    break;
                case 3:
                    plus.setBackgroundDrawable(null);
                    bulgogi.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("불고기 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    break;
            }
        }
        else
        {
            switch (btncurt) {
                case 0:
                    bulgogi.setBackgroundDrawable(null);
                    plus.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("일반 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    break;
                case 1:
                    chicken.setBackgroundDrawable(null);
                    bulgogi.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("불고기 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    break;
                case 2:
                    saewoo.setBackgroundDrawable(null);
                    chicken.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("치킨 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    break;
                case 3:
                    plus.setBackgroundDrawable(null);
                    saewoo.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("새우 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    break;
            }
        }
    }

    private void decideBtn() {
        switch (btncurt) {
            case 0:
                bulgogi.performClick();
                break;
            case 1:
                chicken.performClick();
                break;
            case 2:
                saewoo.performClick();
                break;
            case 3:
                plus.performClick();
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
                        pushBtn(false);
                        break;
                    case 2:
                        pushBtn(true);
                        break;
                    case 4:
                        decideBtn();
                }
            }
        });
    }
}

