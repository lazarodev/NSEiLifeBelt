package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gt.dev.ilifebelt.nseilifebelt.R;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnShow;
    private TextView tvResult, tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnShow = (Button) findViewById(R.id.btn_show_info);
        tvResult = (TextView) findViewById(R.id.tv_result_nse);
        tvShow = (TextView) findViewById(R.id.tv_more_info);

        btnShow.setOnClickListener(this);

        getSource();
    }

    //Getting the data from the last activit with the nse result
    private void getSource() {
        Bundle bundle = getIntent().getExtras();
        String result = bundle.getString("result_nse");
        tvResult.setText(result);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_info:
                if (tvResult.getText().toString().trim().equals("C+")) {
                    btnShow.setVisibility(View.VISIBLE);
                    tvShow.setText("c+");
                } else if (tvResult.getText().toString().trim().equals("E")) {
                    btnShow.setVisibility(View.VISIBLE);
                    tvShow.setText("E");
                } else if (tvResult.getText().toString().trim().equals("A/B")) {
                    btnShow.setVisibility(View.VISIBLE);
                    tvShow.setText("A/B");
                }
                break;
        }
    }
}
