package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.Main;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.MainAdapter;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.RoomFragment;

import java.util.ArrayList;

/**
 * En MainActivity se muestra el menu principal para que
 * el usuario pueda escoger una de las opciones presentadas.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView lvMain;
    private FloatingActionButton fab;
    private ArrayList<Main> categoria = new ArrayList<>();
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);

        // Seteamos el titulo de la app
        getSupportActionBar().setTitle("iLifeBelt NSE");
        // Seteamos el subtitulo de la app
        getSupportActionBar().setSubtitle("Nivel Socio Economico");
        // seteamos un icono para la app
        getSupportActionBar().setIcon(R.drawable.iconoapp);

        startVars();
    }

    /**
     * Metodo que inicializa todas las variables
     */
    private void startVars() {
        fab = (FloatingActionButton) findViewById(R.id.fab_main);
        fab.setOnClickListener(this);

        lvMain = (ListView) findViewById(R.id.lv_main);

        // Items
        categoria.add(new Main("Datos NSE", "Estadisticas demograficas", R.drawable.ic_assessment_white_48dp));
        categoria.add(new Main("Calculadora NSE", "Calcula tus NSE en 1 minuto", R.drawable.ic_border_color_white_48dp));
        categoria.add(new Main("Resultados", "Lista de resultados NSE", R.drawable.ic_assignment_white_48dp));
        categoria.add(new Main("Acerca de iLifeBelt", "Informacion de iLifebelt", R.drawable.ic_person_pin_white_48dp));

        // Adaptador
        MainAdapter adapter = new MainAdapter(categoria, this);
        lvMain.setAdapter(adapter);
        lvMain.setOnItemClickListener(this);
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
                startActivity(new Intent(MainActivity.this, NSEActivity.class));
                break;
        }
    }

    /**
     * Seteamos las funciones que realizara cada item al momento de ser
     * presionado por posicion.
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(MainActivity.this, ChartsActivity.class));
                break;
            case 1:
                startActivity(new Intent(MainActivity.this, NSEActivity.class));
                break;
            case 2:
                startActivity(new Intent(MainActivity.this, LibraryActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
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
