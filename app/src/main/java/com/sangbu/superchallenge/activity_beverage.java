package com.sangbu.superchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ScrollView;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

import static com.sangbu.superchallenge.MainActivity.bt;
import static com.sangbu.superchallenge.MainActivity.tts;

public class activity_beverage extends AppCompatActivity {

    private int btncurt = 0;

    ImageButton coke, sprite, banilashake, chocoshake, strawbshake, fanta, orangejuice;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_beverage);

        scrollView = ((ScrollView) findViewById(R.id.bvagesv));

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

        coke = findViewById(R.id.coke);
        sprite = findViewById(R.id.sprite);
        banilashake = findViewById(R.id.banilashake);
        chocoshake = findViewById(R.id.chocoshake);
        strawbshake = findViewById(R.id.strawbshake);
        fanta = findViewById(R.id.fanta);
        orangejuice = findViewById(R.id.orangejuice);

        coke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),activity_pay.class);
                intent1.putExtra("result", "콜라");
                startActivity(intent1);
            }
        });

        sprite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),activity_pay.class);
                intent1.putExtra("result", "사이다");
                startActivity(intent1);
            }
        });

        banilashake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),activity_pay.class);
                intent1.putExtra("result", "바닐라 쉐이크");
                startActivity(intent1);
            }
        });

        chocoshake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),activity_pay.class);
                intent1.putExtra("result", "초코 쉐이크");
                startActivity(intent1);
            }
        });

        strawbshake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),activity_pay.class);
                intent1.putExtra("result", "딸기 쉐이크");
                startActivity(intent1);
            }
        });

        fanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),activity_pay.class);
                intent1.putExtra("result", "환타");
                startActivity(intent1);
            }
        });

        orangejuice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),activity_pay.class);
                intent1.putExtra("result", "오렌지 주스");
                startActivity(intent1);
            }
        });

        coke.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
        tts.speak("콜라를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);

    }

    private void decideBtn() {
        switch (btncurt)
        {
            case 0:
                coke.performClick();
                break;
            case 1:
                sprite.performClick();
                break;
            case 2:
                banilashake.performClick();
                break;
            case 3:
                chocoshake.performClick();
                break;
            case 4:
                strawbshake.performClick();
                break;
            case 5:
                fanta.performClick();
                break;
            case 6:
                orangejuice.performClick();
                break;
        }
    }

    private void pushBtn(boolean b) {
        if (b) {
            switch (btncurt) {
                case 0:
                    coke.setBackgroundDrawable(null);
                    sprite.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("사이다를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 1:
                    sprite.setBackgroundDrawable(null);
                    banilashake.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("바닐라 쉐이크를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 2:
                    banilashake.setBackgroundDrawable(null);
                    chocoshake.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("초코 쉐이크를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 3:
                    chocoshake.setBackgroundDrawable(null);
                    strawbshake.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("딸기 쉐이크를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 4;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 4:
                    strawbshake.setBackgroundDrawable(null);
                    fanta.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("환타를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 5;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 5:
                    fanta.setBackgroundDrawable(null);
                    orangejuice.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("오렌지 주스를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 6;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 6:
                    orangejuice.setBackgroundDrawable(null);
                    coke.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("콜라를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
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
                    coke.setBackgroundDrawable(null);
                    orangejuice.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("오렌지 주스를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 6;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
                    break;
                case 1:
                    sprite.setBackgroundDrawable(null);
                    coke.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("콜라를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 2:
                    banilashake.setBackgroundDrawable(null);
                    sprite.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("사이다를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 3:
                    chocoshake.setBackgroundDrawable(null);
                    banilashake.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("바닐라 쉐이크를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 4:
                    strawbshake.setBackgroundDrawable(null);
                    chocoshake.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("초코 쉐이크를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 5:
                    fanta.setBackgroundDrawable(null);
                    strawbshake.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("딸기 쉐이크를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 4;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 6:
                    orangejuice.setBackgroundDrawable(null);
                    fanta.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("환타를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
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

}
