package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.Main;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.MainAdapter;

import java.util.ArrayList;

public class ChartMainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvChartMain;
    private ArrayList<Main> categoria = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_main);

        startVars();
    }

    private void startVars() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvChartMain = (ListView) findViewById(R.id.lv_chart_main);

        // Agregando items para el listview
        categoria.add(new Main("Cualidades", "Cualidades de los guatemaltecos", R.drawable.ic_border_color_white_48dp));
        categoria.add(new Main("Defectos", "Defectos de los guatemaltecos", R.drawable.ic_border_color_white_48dp));
        categoria.add(new Main("Religión", "Religiones entre los guatemaltecos", R.drawable.ic_border_color_white_48dp));
        categoria.add(new Main("Felicidad", "¿Los guatemaltecos son felices?", R.drawable.ic_border_color_white_48dp));

        // Adaptador
        MainAdapter adapter = new MainAdapter(categoria, this);
        lvChartMain.setAdapter(adapter);
        lvChartMain.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                startActivity(new Intent(ChartMainActivity.this, QualitiesActivity.class));
                break;
            case 1:
                startActivity(new Intent(ChartMainActivity.this, DefectsActivity.class));
                break;
            case 2:
                startActivity(new Intent(ChartMainActivity.this, ReligionActivity.class));
                break;
            case 3:
                startActivity(new Intent(ChartMainActivity.this, HappinessActivity.class));
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
