package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.gt.dev.ilifebelt.nseilifebelt.R;

public class UserResultActivity extends AppCompatActivity {

    private String name, email, nse;
    private FloatingActionButton fab;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout_result);

        getSource();
    }

    private void getSource() {
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        email = bundle.getString("email");
        nse = bundle.getString("nse");

        collapsingToolbarLayout.setTitle(name);

        if (nse.equals("E")) {
            collapsingToolbarLayout.setBackgroundResource(android.R.color.holo_red_dark);
        } else if (nse.equals("A/B")) {
            collapsingToolbarLayout.setBackgroundResource(android.R.color.holo_orange_dark);
        } else if (nse.equals("C")) {
            collapsingToolbarLayout.setBackgroundResource(android.R.color.holo_blue_dark);
        } else if (nse.equals("C+")) {
            collapsingToolbarLayout.setBackgroundResource(android.R.color.holo_purple);
        } else if (nse.equals("D")) {
            collapsingToolbarLayout.setBackgroundResource(android.R.color.holo_green_dark);
        } else if (nse.equals("D+")) {
            collapsingToolbarLayout.setBackgroundResource(android.R.color.white);
        } else if (nse.equals("C-")) {
            collapsingToolbarLayout.setBackgroundResource(android.R.color.black);
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
}