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

public class activity_chicken extends AppCompatActivity {

    ImageButton macomchick, macomckleg;

    int btncurt = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chicken);

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
        macomchick = findViewById(R.id.macomchick);
        macomckleg = findViewById(R.id.macomckleg);

        macomchick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), activity_pay.class);
                intent2.putExtra("result", "매콤치킨닭가슴살버거");
                startActivityForResult(intent2, 113);
            }
        });

        macomckleg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), activity_pay.class);
                intent2.putExtra("result", "매콤치킨닭다리살버거");
                startActivityForResult(intent2, 114);
            }
        });

        macomchick.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
        tts.speak("매콤치킨닭가슴살버거를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
    }


    private void pushBtn() {
        switch (btncurt) {
            case 0:
                macomchick.setBackgroundDrawable(null);
                macomckleg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                tts.speak("매콤치킨닭가슴살버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                btncurt = 1;
                break;
            case 1:
                macomckleg.setBackgroundDrawable(null);
                macomchick.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                tts.speak("매콤치킨닭다리살버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
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

    private void decideBtn() {
        switch (btncurt) {
            case 0:
                macomchick.performClick();
                break;
            case 1:
                macomckleg.performClick();
                break;
        }
    }
}

