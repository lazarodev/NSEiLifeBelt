package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.activity.charts.ChartMainActivity;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.Library;

/**
 * En MainActivity se muestra el menu principal para que
 * el usuario pueda escoger una de las opciones presentadas.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fab;
    private Toolbar toolbar;
    private ImageButton ibCalcl, ibData, ibResult, ibAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        // Seteamos el titulo de la app
        getSupportActionBar().setTitle("iLifeBelt NSE");

        // Seteamos el subtitulo de la app
        getSupportActionBar().setSubtitle("Nivel Socio-Económico");

        startVars();
    }

    /**
     * Metodo que inicializa todas las variables
     */
    private void startVars() {
        fab = (FloatingActionButton) findViewById(R.id.fab_main);
        fab.setOnClickListener(this);

        ibData = (ImageButton) findViewById(R.id.ib_data_main);
        ibCalcl = (ImageButton) findViewById(R.id.ib_calculator_main);
        ibResult = (ImageButton) findViewById(R.id.ib_result_main);
        ibAbout = (ImageButton) findViewById(R.id.ib_about_main);

        ibData.setOnClickListener(this);
        ibCalcl.setOnClickListener(this);
        ibResult.setOnClickListener(this);
        ibAbout.setOnClickListener(this);
    }

    /**
     * Indicamos que hara el FloatingActionButton cuando es presionado.
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_main:
                //Do something the button when is pressed
                selectCountry();
                break;
            case R.id.ib_data_main:
                startActivity(new Intent(MainActivity.this, ChartMainActivity.class));
                break;
            case R.id.ib_calculator_main:
                selectCountry();
                break;
            case R.id.ib_result_main:
                startActivity(new Intent(MainActivity.this, LibraryActivity.class));
                break;
            case R.id.ib_about_main:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
    }

    private void selectCountry() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        startActivity(new Intent(MainActivity.this, GtNSEActivity.class));
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        startActivity(new Intent(MainActivity.this, NSEActivity.class));
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(R.string.country_select_question)).setPositiveButton(getString(R.string.guatemala_title), dialogClickListener)
                .setNegativeButton(getString(R.string.mexico_title), dialogClickListener).show();
    }

    /**
     * Metodo nativo cuando la actividad entra en segundo plano.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Metodo nativo cuando la actividad de regresa de
     * segundo plano hacia 1er plano.
     */
    @Override
    protected void onResume() {
        super.onResume();
    }
}
