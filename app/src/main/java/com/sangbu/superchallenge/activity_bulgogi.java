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

public class activity_bulgogi extends AppCompatActivity {

    int btncurt = 0;

    ImageButton bulgogibrg, dbbulgogi;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bulgogi);

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

        bulgogibrg = findViewById(R.id.bulgogibrg);
        dbbulgogi = findViewById(R.id.dbbulgogi);

        bulgogibrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), activity_pay.class);
                intent1.putExtra("result", "불고기버거");
                startActivityForResult(intent1, 111);
            }
        });

        dbbulgogi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), activity_pay.class);
                intent1.putExtra("result", "더블불고기버거");
                startActivityForResult(intent1, 112);
            }
        });

        bulgogibrg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
        tts.speak("불고기 버거를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);

    }

    private void pushBtn() {
        switch (btncurt) {
            case 0:
                bulgogibrg.setBackgroundDrawable(null);
                dbbulgogi.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                tts.speak("더블 불고기 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                btncurt = 1;
                break;
            case 1:
                dbbulgogi.setBackgroundDrawable(null);
                bulgogibrg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                tts.speak("불고기 버거를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
                btncurt = 0;
                break;
        }

    }

    private void decideBtn() {
        switch (btncurt) {
            case 0:
                bulgogibrg.performClick();
                break;
            case 1:
                dbbulgogi.performClick();
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
