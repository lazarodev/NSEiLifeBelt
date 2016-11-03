package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gt.dev.ilifebelt.nseilifebelt.R;

public class SplashActivity extends AppCompatActivity {

    protected static final long TIEMPO = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        theTimer();
    }

    private void theTimer(){
        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    //2 segundos
                    sleep(TIEMPO);
                }catch (InterruptedException e){
                    e.printStackTrace();
                } finally{
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
