package com.sangbu.superchallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

import static com.sangbu.superchallenge.MainActivity.bt;

public class final_ extends AppCompatActivity {

    LinearLayout layout;
    boolean istag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_final_);

        layout = findViewById(R.id.iamaburger);
        layout.setVisibility(View.INVISIBLE);

        bt.setOnDataReceivedListener(new BluetoothSPP.OnDataReceivedListener() {
            @Override
            public void onDataReceived(byte[] data, String message) {
                int chk = Integer.parseInt(message);
                switch (chk) {
                    case 4:
                        returnmain();
                        break;
                    case 5:
                        layout.setVisibility(View.VISIBLE);
                        istag = true;
                        break;
                }
            }
        });
    }

    private void returnmain() {
        if(istag)
        {
            Intent intent = new Intent(getApplicationContext(), First.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
