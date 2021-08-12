package com.sangbu.superchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ScrollView;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

import static com.sangbu.superchallenge.MainActivity.bt;
import static com.sangbu.superchallenge.MainActivity.tts;

public class activity_plus extends AppCompatActivity implements View.OnClickListener {

    int btncurt = 0;

    ImageButton brg1955, eggcheese, db1955brg, dbscheese, megamac, bacontomatoderux;
    ImageButton bigmac, scheese, grillmushr, cheesebrg, hambak, hamburger;
    ScrollView scrollView;


    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_plus);

        scrollView = ((ScrollView) findViewById(R.id.plussv));

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


        brg1955 = findViewById(R.id.brg1955);
        eggcheese = findViewById(R.id.eggcheese);
        db1955brg = findViewById(R.id.db1955brg);
        dbscheese = findViewById(R.id.dbscheese);
        megamac = findViewById(R.id.megamac);
        bacontomatoderux = findViewById(R.id.bacontomatoderux);
        bigmac = findViewById(R.id.bigmac);
        scheese = findViewById(R.id.scheese);
        grillmushr = findViewById(R.id.grillmushr);
        cheesebrg = findViewById(R.id.cheesebrg);
        hambak = findViewById(R.id.hambak);
        hamburger = findViewById(R.id.hamburger);

        brg1955.setOnClickListener(this);
        db1955brg.setOnClickListener(this);
        eggcheese.setOnClickListener(this);
        dbscheese.setOnClickListener(this);
        megamac.setOnClickListener(this);
        bacontomatoderux.setOnClickListener(this);
        bigmac.setOnClickListener(this);
        scheese.setOnClickListener(this);
        grillmushr.setOnClickListener(this);
        cheesebrg.setOnClickListener(this);
        hambak.setOnClickListener(this);
        hamburger.setOnClickListener(this);

        brg1955.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
        tts.speak("1955버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);

    }

    @Override
    public void onClick(View v) {
        intent2 = new Intent(getApplicationContext(), activity_pay.class);
        switch (v.getId()) {
            case R.id.brg1955:
                intent2.putExtra("result", "1955버거");
                break;
            case R.id.db1955brg:
                intent2.putExtra("result", "더블1955버거");
                break;
            case R.id.eggcheese:
                intent2.putExtra("result", "에그치즈버거");
                break;
            case R.id.bacontomatoderux:
                intent2.putExtra("result", "베이컨토마토디럭스버거");
                break;
            case R.id.bigmac:
                intent2.putExtra("result", "빅맥버거");
                break;
            case R.id.megamac:
                intent2.putExtra("result", "메가맥버거");
                break;
            case R.id.scheese:
                intent2.putExtra("result", "쇠고기치즈버거");
                break;
            case R.id.grillmushr:
                intent2.putExtra("result", "그릴드버쉬룸버거");
                break;
            case R.id.hambak:
                intent2.putExtra("result", "함박버거");
                break;
            case R.id.hamburger:
                intent2.putExtra("result", "햄버거");
                break;
            case R.id.dbscheese:
                intent2.putExtra("result", "더블쇠고기버거");
                break;
            case R.id.cheesebrg:
                intent2.putExtra("result", "치즈버거");
                break;
        }

        startActivityForResult(intent2, 115);
    }

    private void pushBtn(boolean b) {
        if (b) {
            switch (btncurt) {
                case 0:
                    brg1955.setBackgroundDrawable(null);
                    db1955brg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("더블1955버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 1:
                    db1955brg.setBackgroundDrawable(null);
                    eggcheese.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("에그치즈버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 2:
                    eggcheese.setBackgroundDrawable(null);
                    dbscheese.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("더블쇠고기치즈버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 3:
                    dbscheese.setBackgroundDrawable(null);
                    megamac.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("메가맥버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 4;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 4:
                    megamac.setBackgroundDrawable(null);
                    bacontomatoderux.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("베이컨토마토디럭스버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 5;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 5:
                    bacontomatoderux.setBackgroundDrawable(null);
                    bigmac.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("빅맥버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 6;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 6:
                    bigmac.setBackgroundDrawable(null);
                    scheese.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("쇠고기치즈버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 7;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 7:
                    scheese.setBackgroundDrawable(null);
                    grillmushr.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("그릴드머쉬룸버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 8;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 8:
                    grillmushr.setBackgroundDrawable(null);
                    cheesebrg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("치즈버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 9;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 9:
                    cheesebrg.setBackgroundDrawable(null);
                    hambak.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("함박버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 10;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;
                case 10:
                    hambak.setBackgroundDrawable(null);
                    hamburger.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("햄버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 11;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, 900);
                        }
                    });
                    break;

                case 11:
                    hamburger.setBackgroundDrawable(null);
                    brg1955.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("1955 버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollTo(0, 0);
                        }
                    });
                    break;

            }
        }
        else
        {
            switch (btncurt) {
                case 0:
                    brg1955.setBackgroundDrawable(null);
                    hamburger.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("햄버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 11;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                        }
                    });
                    break;
                case 1:
                    db1955brg.setBackgroundDrawable(null);
                    brg1955.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("1955버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 0;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 2:
                    eggcheese.setBackgroundDrawable(null);
                    db1955brg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("더블1955버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 1;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 3:
                    dbscheese.setBackgroundDrawable(null);
                    eggcheese.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("에그치즈버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 2;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 4:
                    megamac.setBackgroundDrawable(null);
                    dbscheese.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("더블쇠고기치즈버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 3;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 5:
                    bacontomatoderux.setBackgroundDrawable(null);
                    megamac.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("메가맥버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 4;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 6:
                    bigmac.setBackgroundDrawable(null);
                    bacontomatoderux.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("베이컨토마토디럭스버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 5;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 7:
                    scheese.setBackgroundDrawable(null);
                    bigmac.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("빅맥버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 6;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 8:
                    grillmushr.setBackgroundDrawable(null);
                    scheese.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("쇠고기치즈버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 7;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 9:
                    cheesebrg.setBackgroundDrawable(null);
                    grillmushr.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("그릴드머쉬룸버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 8;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 10:
                    hambak.setBackgroundDrawable(null);
                    cheesebrg.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("치즈버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 9;
                    scrollView.post(new Runnable() {
                        @Override
                        public void run() {
                            scrollView.smoothScrollBy(0, -900);
                        }
                    });
                    break;
                case 11:
                    hamburger.setBackgroundDrawable(null);
                    hambak.setBackgroundDrawable(getResources().getDrawable(R.drawable.btnshape));
                    tts.speak("함박버거를 선택하셨습니다", TextToSpeech.QUEUE_FLUSH, null);
                    btncurt = 10;
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

    private void decideBtn() {
        switch (btncurt) {
            case 0:
                brg1955.performClick();
                break;
            case 1:
                db1955brg.performClick();
                break;
            case 2:
                eggcheese.performClick();
                break;
            case 3:
                dbscheese.performClick();
                break;
            case 4:
                megamac.performClick();
                break;
            case 5:
                bacontomatoderux.performClick();
                break;
            case 6:
                bigmac.performClick();
                break;
            case 7:
                scheese.performClick();
                break;
            case 8:
                grillmushr.performClick();
                break;
            case 9:
                cheesebrg.performClick();
                break;
            case 10:
                hambak.performClick();
                break;
            case 11:
                hamburger.performClick();
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
