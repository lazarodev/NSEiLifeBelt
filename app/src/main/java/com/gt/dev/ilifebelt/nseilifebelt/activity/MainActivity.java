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

        getSupportActionBar().setTitle("iLifeBelt NSE");
        getSupportActionBar().setSubtitle("Nivel Socio Economico");
        getSupportActionBar().setIcon(R.drawable.iconoapp);

        startVars();
    }

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_main:
                //Do something the button when is pressed
                startActivity(new Intent(MainActivity.this, NSEActivity.class));
                break;
        }
    }

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
                startActivity(new Intent(MainActivity.this, ResultActivity.class));
                break;
            case 3:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
    }
}
