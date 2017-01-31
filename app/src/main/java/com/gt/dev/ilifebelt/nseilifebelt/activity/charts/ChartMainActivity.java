package com.gt.dev.ilifebelt.nseilifebelt.activity.charts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.Main;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.MainAdapter;

import java.util.ArrayList;

public class ChartMainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton ibDefects, ibHappiness, ibQualities, ibReligion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_main);

        startVars();
    }

    private void startVars() {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Datos NSEx");

        ibDefects = (ImageButton) findViewById(R.id.ib_defects_chart);
        ibReligion = (ImageButton) findViewById(R.id.ib_relgion_chart);
        ibQualities = (ImageButton) findViewById(R.id.ib_qualities_chart);
        ibHappiness = (ImageButton) findViewById(R.id.ib_happiness_chart);

        ibDefects.setOnClickListener(this);
        ibReligion.setOnClickListener(this);
        ibQualities.setOnClickListener(this);
        ibHappiness.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_defects_chart:
                startActivity(new Intent(ChartMainActivity.this, DefectsActivity.class));
                break;
            case R.id.ib_qualities_chart:
                startActivity(new Intent(ChartMainActivity.this, QualitiesActivity.class));
                break;
            case R.id.ib_relgion_chart:
                startActivity(new Intent(ChartMainActivity.this, ReligionActivity.class));
                break;
            case R.id.ib_happiness_chart:
                startActivity(new Intent(ChartMainActivity.this, HappinessActivity.class));
                break;
        }
    }
}
