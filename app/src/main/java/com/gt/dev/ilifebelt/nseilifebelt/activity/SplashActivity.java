package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gt.dev.ilifebelt.nseilifebelt.R;

/**
 * SplashActiivty es la actividad que muestra como pantalla
 * de bienvenida la aplicacion
 */

public class SplashActivity extends AppCompatActivity {

    // Definimos el tiempo de tipo protegido, estatico
    // y final con un valor de 2 segundos
    protected static final long TIEMPO = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        theTimer();
    }

    /**
     * Metodo donde intenta pausar y matar la pantalla de bienvenida
     * durante el tiempo asignado (2 segundos).
     */
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

    /**
     * Metodo nativo cuando la actividad entre en segundo plano
     */
    @Override
    protected void onPause() {
        finish();
        super.onPause();
    }

    /**
     * Metodo nativo cuando el usuario presiona el boton de back
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
