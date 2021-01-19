package com.h5190037.oguzhan_gunaydin_final.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.h5190037.oguzhan_gunaydin_final.R;
import com.h5190037.oguzhan_gunaydin_final.util.AlertDialogUtil;
import com.h5190037.oguzhan_gunaydin_final.util.NetworkUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();

        }
        public void init(){
            CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {
                @Override
                public void onTick(long l) {
                    Log.e("COUNTER", "TİCK");
                }

                @Override
                public void onFinish() {

                    if(NetworkUtil.networkControl(getApplicationContext())) {
                        openNextActivity();
                    }
                    else {
                        AlertDialogUtil.alertDialogShow(SplashActivity.this, getResources().getString(R.string.app_information),getResources().getString(R.string.app_netInformation),getResources().getString(R.string.app_goSettings),getResources().getString(R.string.app_no),getResources().getString(R.string.app_splashEkranBilgi));
                    }


                }
            };
            countDownTimer .start();

    }
        public void openNextActivity(){
            Log.e("COUNTER", "FİNİSH");
            Intent secondActivityIntent = new Intent(getApplicationContext(),ListeActivity.class);
            startActivity(secondActivityIntent);
            finish();

    }

}



