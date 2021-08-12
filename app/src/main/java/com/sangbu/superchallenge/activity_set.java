package com.sangbu.superchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

import static com.sangbu.superchallenge.MainActivity.bt;
import static com.sangbu.superchallenge.MainActivity.tts;

public class activity_set extends AppCompatActivity implements View.OnClickListener{


    private int btncurt = 0;
    ImageButton dbbulset, goldeneggset, quapcset, bulset, bigmacset;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

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

        dbbulset = findViewById(R.id.dbbulset);
        goldeneggset = findViewById(R.id.goldeneggset);
        quapcset = findViewById(R.id.quapcset);
        bulset = findViewById(R.id.bulset);
        bigmacset = findViewById(R.id.bigmacset);

        dbbulset.setOnClickListener(this);
        goldeneggset.setOnClickListener(this);
        quapcset.setOnClickListener(this);
        bulset.setOnClickListener(this);
        bigmacset.setOnClickListener(this);

        dbbulset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
        tts.speak("감자튀김을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
    }

    private void decideBtn() {
        switch (btncurt) {
            case 0:
                dbbulset.performClick();
                break;
            case 1:
                bulset.performClick();
                break;
            case 2:
                bigmacset.performClick();
                break;
            case 3:
                goldeneggset.performClick();
                break;
            case 4:
                quapcset.performClick();
                break;
        }

    }

    private void pushBtn(boolean b) {
        if (b) {
            switch (btncurt) {
                case 0:
                    dbbulset.setBackgroundDrawable(null);
                    bulset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("불고기 버거 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    break;
                case 1:
                    bulset.setBackgroundDrawable(null);
                    bigmacset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("빅맥 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    break;
                case 2:
                    bigmacset.setBackgroundDrawable(null);
                    goldeneggset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("골든 에그 버거 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    break;
                case 3:
                    goldeneggset.setBackgroundDrawable(null);
                    quapcset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("쿼터 파운드 치즈 버거 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 4;
                    break;
                case 4:
                    quapcset.setBackgroundDrawable(null);
                    dbbulset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("더블 불고기 버거 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    break;
            }
        }
        else
        {
            switch (btncurt) {
                case 0:
                    dbbulset.setBackgroundDrawable(null);
                    quapcset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("쿼터 파운드 치즈 버거 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 4;
                    break;
                case 1:
                    bulset.setBackgroundDrawable(null);
                    dbbulset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("더블 불고기 버거 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    break;
                case 2:
                    bigmacset.setBackgroundDrawable(null);
                    bulset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("불고기 버거 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    break;
                case 3:
                    goldeneggset.setBackgroundDrawable(null);
                    bigmacset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("빅맥 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    break;
                case 4:
                    quapcset.setBackgroundDrawable(null);
                    goldeneggset.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("골든 에그 버거 세트를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent myintent = new Intent(getApplicationContext(), activity_pay.class);
        switch (v.getId()) {
            case R.id.dbbulset:
                myintent.putExtra("result", "더블불고기버거세트");
                startActivity(myintent);
                break;
            case R.id.goldeneggset:
                myintent.putExtra("result", "골든에그버거세트");
                startActivity(myintent);
                break;
            case R.id.quapcset:
                myintent.putExtra("result", "쿼터파운드치즈버거세트");
                startActivity(myintent);
                break;
            case R.id.bulset:
                myintent.putExtra("result", "불고기버거세트");
                startActivity(myintent);
                break;
            case R.id.bigmacset:
                myintent.putExtra("result", "빅맥세트");
                startActivity(myintent);
                break;
        }

    }
}
