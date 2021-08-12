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

public class activity_side extends AppCompatActivity implements View.OnClickListener {

    ImageButton icecream, chocoice, strawice, cheesestick, frfry, soup, chickchest;
    private int btncurt = 0;
    Intent myintent;
    ScrollView scrollView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);

        scrollView = ((ScrollView) findViewById(R.id.sidesv));

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

        icecream = findViewById(R.id.icecream);
        chocoice = findViewById(R.id.chocoice);
        strawice = findViewById(R.id.strawice);
        cheesestick = findViewById(R.id.cheesestick);
        frfry = findViewById(R.id.frfry);
        soup = findViewById(R.id.soup);
        chickchest = findViewById(R.id.chickchest);

        icecream.setOnClickListener(this);
        strawice.setOnClickListener(this);
        chocoice.setOnClickListener(this);
        cheesestick.setOnClickListener(this);
        frfry.setOnClickListener(this);
        soup.setOnClickListener(this);
        chickchest.setOnClickListener(this);


        frfry.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
        tts.speak("감자튀김을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
    }

    private void decideBtn() {
        switch (btncurt)
        {
            case 0:
                frfry.performClick();
                break;
            case 1:
                cheesestick.performClick();
                break;
            case 2:
                chocoice.performClick();
                break;
            case 3:
                strawice.performClick();
                break;
            case 4:
                chickchest.performClick();
                break;
            case 5:
                soup.performClick();
                break;
            case 6:
                icecream.performClick();
                break;
        }
    }

    private void pushBtn(boolean b) {
        if (b) {
            switch (btncurt) {
                case 0:
                    frfry.setBackgroundDrawable(null);
                    cheesestick.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("치즈스틱을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });

                    break;
                case 1:
                    cheesestick.setBackgroundDrawable(null);
                    chocoice.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("초코 아이스크림을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 2:
                    chocoice.setBackgroundDrawable(null);
                    strawice.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("딸기 아이스크림를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 3:
                    strawice.setBackgroundDrawable(null);
                    chickchest.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("닭가슴살을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 4;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 4:
                    chickchest.setBackgroundDrawable(null);
                    soup.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("수프를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 5;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 5:
                    soup.setBackgroundDrawable(null);
                    icecream.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("아이스크림을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 6;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 6:
                    icecream.setBackgroundDrawable(null);
                    frfry.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("감자튀김을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;


                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.fullScroll(ScrollView.FOCUS_UP);
                        }
                    });
                    break;
            }
        }
        else
        {
            switch (btncurt) {
                case 0:
                    frfry.setBackgroundDrawable(null);
                    icecream.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("아이스크림을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 6;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
                    break;
                case 1:
                    cheesestick.setBackgroundDrawable(null);
                    frfry.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("감자튀김을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 2:
                    chocoice.setBackgroundDrawable(null);
                    cheesestick.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("치즈스틱을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 3:
                    strawice.setBackgroundDrawable(null);
                    chocoice.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("초코 아이스크림을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 4:
                    chickchest.setBackgroundDrawable(null);
                    strawice.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("딸기 아이스크림을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 5:
                    soup.setBackgroundDrawable(null);
                    chickchest.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("닭가슴살을 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 4;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 6:
                    icecream.setBackgroundDrawable(null);
                    soup.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("수프를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 5;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
            }
        }

    }

    @Override
    public void onClick(View v) {
        myintent = new Intent(getApplicationContext(), activity_pay.class);

        switch (v.getId()) {
            case R.id.icecream:
                myintent.putExtra("result", "아이스크림");
                startActivity(myintent);
                break;
            case R.id.strawice:
                myintent.putExtra("result", "딸기 아이스크림");
                startActivity(myintent);
                break;
            case R.id.chocoice:
                myintent.putExtra("result", "초코 아이스크림");
                startActivity(myintent);
                break;
            case R.id.frfry:
                myintent.putExtra("result", "감자튀김");
                startActivity(myintent);
                break;
            case R.id.soup:
                myintent.putExtra("result", "수프");
                startActivity(myintent);
                break;
            case R.id.cheesestick:
                myintent.putExtra("result", "치즈스틱");
                startActivity(myintent);
                break;
            case R.id.chickchest:
                myintent.putExtra("result", "닭가슴살");
                startActivity(myintent);
                break;
        }

    }
}
