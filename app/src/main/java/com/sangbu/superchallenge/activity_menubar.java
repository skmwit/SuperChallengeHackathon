package com.sangbu.superchallenge;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

import static com.sangbu.superchallenge.MainActivity.bt;
import static com.sangbu.superchallenge.MainActivity.tts;

public class activity_menubar extends AppCompatActivity {

    ListView listView;

    Integer[] imgid = {R.drawable.burger, R.drawable.beverage, R.drawable.fry, R.drawable.set};

    Intent lastIntent;

    ImageButton hamburgerimg;
    ImageButton beverageimg;
    ImageButton sideimg;
    ImageButton setimg;

    int btncurt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menubar);

        lastIntent = new Intent();
        setResult(RESULT_OK, lastIntent);

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


        hamburgerimg = findViewById(R.id.hamburgerimg);
        beverageimg = findViewById(R.id.beverageimg);
        sideimg = findViewById(R.id.sideimg);
        setimg = findViewById(R.id.setimg);

        hamburgerimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), activity_hamburger.class);
                startActivityForResult(intent2, 103);
            }
        });

        beverageimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), activity_beverage.class);
                startActivityForResult(intent3, 104);
            }
        });
        sideimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), activity_side.class);
                startActivityForResult(intent4, 105);
            }
        });

        setimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent(getApplicationContext(), activity_set.class);
                startActivityForResult(intent5, 106);
            }
        });

        hamburgerimg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
        tts.speak("햄버거를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
    }

    private void decideBtn() {
        switch (btncurt)
        {
            case 0:
                hamburgerimg.performClick();
                break;
            case 1:
                beverageimg.performClick();
                break;
            case 2:
                sideimg.performClick();
                break;
            case 3:
                setimg.performClick();
                break;
        }
    }

    private void pushBtn(boolean b) {
        if (b) {
            switch (btncurt) {
                case 0:
                    hamburgerimg.setBackgroundDrawable(null);
                    beverageimg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("음료수를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    break;
                case 1:
                    beverageimg.setBackgroundDrawable(null);
                    sideimg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("기타 음식을 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    break;
                case 2:
                    sideimg.setBackgroundDrawable(null);
                    setimg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("세트를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    break;
                case 3:
                    setimg.setBackgroundDrawable(null);
                    hamburgerimg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("햄버거를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    break;

            }
        } else {
            switch (btncurt) {
                case 0:
                    hamburgerimg.setBackgroundDrawable(null);
                    setimg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("세트를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    break;
                case 1:
                    beverageimg.setBackgroundDrawable(null);
                    hamburgerimg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("햄버거를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    break;
                case 2:
                    sideimg.setBackgroundDrawable(null);
                    beverageimg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("음료수를 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    break;
                case 3:
                    setimg.setBackgroundDrawable(null);
                    sideimg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("기타 음식을 선택하셨습니다.", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    break;
            }
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

