package com.sangbu.superchallenge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.textservice.SpellCheckerSession;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.kakao.sdk.newtoneapi.SpeechRecognizeListener;
import com.kakao.sdk.newtoneapi.SpeechRecognizerClient;
import com.kakao.sdk.newtoneapi.SpeechRecognizerManager;
import com.kakao.sdk.newtoneapi.TextToSpeechClient;
import com.kakao.sdk.newtoneapi.TextToSpeechListener;
import com.kakao.sdk.newtoneapi.TextToSpeechManager;

import org.w3c.dom.Text;

import java.util.ArrayList;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

import static com.sangbu.superchallenge.MainActivity.bt;
import static com.sangbu.superchallenge.MainActivity.tts;

public class choicemenu extends AppCompatActivity implements SpeechRecognizeListener {

    Intent lastintent, newintent;
    ImageButton logo;

    SpeechRecognizerClient client;
    ArrayList<String> arraylist, save;
    boolean didmic = false;
    TextView mic;

    @Override
    protected void onDestroy() {
        TextToSpeechManager.getInstance().finalizeLibrary();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choicemenu);

        SpeechRecognizerManager.getInstance().initializeLibrary(this);

        tts.speak("어서오세요, 맥도날드입니다. 주문 시작하시려면 확인 버튼을 눌러주세요", TextToSpeech.QUEUE_FLUSH, null);

        save = new ArrayList<String>();

        lastintent = new Intent();
        newintent = new Intent(getApplicationContext(), activity_menubar.class);
        setResult(RESULT_OK, lastintent);

        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                int chk = Integer.parseInt(message);
                switch (chk) {
                    case 0:
                        finish();
                        break;
                    case 2:
                        logo.performClick();
                        break;
                    case 4:
                        pressBtn4();
                        break;
                }

            }
        });

        mic = (TextView) findViewById(R.id.mic);

        //버튼 연결 선택 시
        logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(newintent, 102);
            }
        });
    }

    private void pressBtn4() {
        SpeechRecognizerClient.Builder builder = new SpeechRecognizerClient.Builder().setServiceType(SpeechRecognizerClient.SERVICE_TYPE_DICTATION);

        SpeechRecognizerClient client = builder.build();
        client.setSpeechRecognizeListener(this);
        if (tts.isSpeaking()) tts.stop();
        client.startRecording(false);
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
                    case 2:
                        logo.performClick();
                        break;
                    case 4:
                        pressBtn4();
                        break;

                }
            }
        });
    }

    @Override
    public void onReady() {

    }

    @Override
    public void onBeginningOfSpeech() {
        Log.d("newtone", "speechbegin");

    }

    @Override
    public void onEndOfSpeech() {
        Log.d("newtone", "speechend");
    }

    @Override
    public void onError(int errorCode, String errorMsg) {
        Log.e("newtone", errorMsg);
    }

    @Override
    public void onPartialResult(String partialResult) {

    }

    @Override
    public void onResults(Bundle results) {
        final StringBuilder builder = new StringBuilder();

        final ArrayList<String> texts = results.getStringArrayList(SpeechRecognizerClient.KEY_RECOGNITION_RESULTS);
        ArrayList<Integer> confs = results.getIntegerArrayList(SpeechRecognizerClient.KEY_CONFIDENCE_VALUES);
        String[] textsArrays = texts.toArray(new String[texts.size()]);
        String[] apple = textsArrays;//음성-> 문자열
        final String hy = apple[0];
        final String jy = apple[0];
        arraylist = new ArrayList<String>();

        Log.d("home", "aa" + apple[0]);
        Log.d("newtone", "Result" + texts);

        for (int i = 0; i < texts.size(); i++) {
            builder.append(texts.get(i));
            builder.append(" (");
            builder.append(confs.get(i).intValue());
            builder.append(")\n");
        }

        final Activity activity = this;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (activity.isFinishing()) return;
                //Log.d("count","인식된 음성은=>"+hy);
            }
        });
        //menuCriteria
        //menuall : 기준으로 입력된 문자열 배열
        //apple: 음성인식으로 입력된 문자열 배열

        strchk(hy);
    }

    @Override
    public void onAudioLevel(float audioLevel) {

    }

    @Override
    public void onFinished() {

    }

    public void strchk(String hy) {
        mic.setText("확인된 메뉴입니다.");
        didmic = true;
        int count = 0;

        String[] menucriteria = {"세트",//1
                "버거", "햄버거", "치킨", "불고기", "치즈", "새우", "고기", "함박", "매콤한",//10
                "콜라", "사이다", "스프라이트", "커피", "쉐이크", "쥬스",//16
                "감자", "조각",//18
                "꾸엑 나는 오리가 좋아"//19

        };

        for (int j = 0; j < menucriteria.length; j++) {
            if (hy.contains(menucriteria[j])) {
                count++;
                Log.d("count", "나는 셌다" + count);
                break;
            } else {
                count++;
                Log.d("count", "나는 셌다" + count);
            }
        }

        //Log.d("count", "결론은-->" + count);

        //세트 메뉴 확인
        if (count == 1) {
            //criteriaView2.setText("세트 메뉴로 이동합니다");
            String[] menusets = {"빅맥 세트", "맥스파이시 상하이 버거 세트", "슈슈버거 세트", "1995 버거 세트", "더블 1995 버거 세트", "베이컨 토마토 디럭스 세트", "슈비버거 세트", "크리스피 오리엔탈 치킨 버거 세트", "메가맥 세트", "불고기 버거 세트", "쿼터 파운더 치즈 세트", "더블 쿼터 파운드 치즈 세트"};


            ArrayAdapter<String> Adapter;
            Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist);

            for (int i = 0; i < menusets.length; i++)
                if (menusets[i].contains(hy)) {
                    arraylist.add(menusets[i]);
                }

            ListView list = (ListView) findViewById(R.id.list);
            list.setAdapter(Adapter);
        }

        //햄버거 메뉴
        else if (count >= 2 && count <= 10) {
            //criteriaView2.setText("햄버거 메뉴로 이동합니다.");
            String[] menuburgers = {"불고기 버거", "더블 불고기 버거", "맥스파이시 상하이 버거", "크리스피 오리엔탈 치킨 버거", "슈슈 버거", "슈비 버거", "베이컨 토마토 디럭스", "쿼터 파운더 치즈", "더블 쿼터 파운더 치즈", "골든 에그 치즈 버거", "그릴드 머쉬룸 버거",//버섯이라고? 해야 하지 않나?
                    "함박 버거", "빅맥", "메가맥", "1955 버거", "더블 1955 버거", "치즈 버거", "햄버거",};

            for (int i = 0; i < menuburgers.length; i++) {
                if (menuburgers[i].contains(hy)) {
                    arraylist.add(menuburgers[i]);
                }
            }
            ArrayAdapter<String> Adapter;
            Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist);

            ListView list = (ListView) findViewById(R.id.list);
            list.setAdapter(Adapter);
        }

        //음료 메뉴
        else if (count >= 11 && count <= 16) {
            //criteriaView2.setText("음료 메뉴로 이동합니다");
            String[] menudrinks = {"콜라", "스프라이트", "환타", "바닐라 쉐이크", "딸기 쉐이크", "초코 쉐이크", "오렌지 쥬스", "커피"

            };

            for (int i = 0; i < menudrinks.length; i++)
                if (menudrinks[i].contains(hy)) {
                    arraylist.add(menudrinks[i]);
                }
            ArrayAdapter<String> Adapter;
            Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist);

            ListView list = (ListView) findViewById(R.id.list);
            list.setAdapter(Adapter);
        }

        //기타 메뉴
        else if (count == 17 || count == 18) {
            String[] menusides = {"감자 튀김", "옥수수 스프", "닭가슴살 조각", "모짜렐라 치즈 조각", "아이스크림", "ice cream", //외래어이기 때문에
                    "초코 아이스크림", "딸기 아이스크림"};
            for (int i = 0; i < menusides.length; i++)
                if (menusides[i].contains(hy)) {
                    arraylist.add(menusides[i]);
                }
            ArrayAdapter<String> Adapter;
            Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist);

            ListView list = (ListView) findViewById(R.id.list);
            list.setAdapter(Adapter);
        }

        //전체 메뉴
        else if (count >= 19) {
            //criteriaView2.setText("전체 메뉴로 이동합니다");
            //menuAll
            String[] menuall = {"빅백 세트", "맥스파이시 상하이 버거 세트", "슈슈 버거 세트", "1995 버거 세트", "더블 1995 버거 세트", "베이컨 토마토 디럭스 세트", "슈비 버거 세트", "크리스피 오리엔탈 치킨 버거 세트", "메가맥 세트", "불고기 버거 세트", "쿼터 파운더 치즈 세트", "더블 쿼터 파운드 치즈 세트", "불고기 버거", "더블 불고기 버거", "맥스파이시 상하이 버거", "크리스피 오리엔탈 치킨버거", "슈슈 버거", "슈비 버거", "베이컨 토마토 디럭스", "쿼터 파운더 치즈", "더블 쿼터 파운더 치즈", "골든 에그 치즈 버거", "그릴드 그릴드 버거", "함박 버거", "빅맥", "메가맥", "1955 버거", "더블 1955 버거", "치즈 버거", "햄버거", "콜라", "스프라이트", "환타", "바닐라 쉐이크", "딸기 쉐이크", "초코 쉐이크", "오렌지 쥬스", "커피", "감자 튀김", "옥수수 스프", "닭가슴살 조각", "모짜렐라 치즈 조각", "아이스크림", "ice cream", //외래어이기 때문에
                    "초코 아이스크림", "딸기 아이스크림"};

            for (int i = 0; i < menuall.length; i++) {
                if (menuall[i].contains(hy)) {
                    arraylist.add(menuall[i]);
                }
            }

            save = arraylist;
            Log.d("yes", String.valueOf(arraylist.size()));

            //출력을 하는 창
            ArrayAdapter<String> Adapter;
            Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist);


            ListView list = (ListView) findViewById(R.id.list);
            list.setAdapter(Adapter);


        }

    }

    public boolean blackCheck(String checkif, String original) {

        int count = 0;
        int count1 = 0;

        for (int i = 0; i < checkif.length(); i++) {
            if (checkif.charAt(i) == ' ') {
                Log.d("count", "공백의 갯수는" + count);
                count++;
            } else {
                Log.d("count", "공백이 존재하지 않는다" + i);
            }
        }


        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == ' ') {
                Log.d("count", "공백의 갯수는" + count);
                count1++;
            } else {
                Log.d("count", "공백이 존재하지 않는다" + i);
            }
        }

        if (count > count1) {
            return false;
        } else return true;
    }

}
