package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.model.Results;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnShow, btnCancel, btnSave;
    private TextView tvResult, tvShow;
    private String resultNSE, resultName, resultEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnShow = (Button) findViewById(R.id.btn_show_info);
        btnSave = (Button) findViewById(R.id.btn_save_result);
        btnCancel = (Button) findViewById(R.id.btn_cancel_result);
        tvResult = (TextView) findViewById(R.id.tv_result_nse);
        tvShow = (TextView) findViewById(R.id.tv_more_info);

        btnShow.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        getSource();
    }

    //Getting the data from the last activit with the nse result
    private void getSource() {
        Bundle bundle = getIntent().getExtras();
        resultNSE = bundle.getString("result_nse");
        resultName = bundle.getString("result_name");
        resultEmail = bundle.getString("result_email");

        Log.d("**DATA_INFO**", resultName + "/" + resultEmail);

        tvResult.setText(resultNSE);
    }

    private void saveResult() {
        Results result = new Results();
        result.name = resultName;
        //result.email = resultEmail;
        //result.nse = resultNSE;
        result.save();
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_info:
                if (tvResult.getText().toString().trim().equals("C+")) {
                    tvShow.setText("C+");
                } else if (tvResult.getText().toString().trim().equals("E")) {
                    tvShow.setText("E");
                } else if (tvResult.getText().toString().trim().equals("A/B")) {
                    tvShow.setText("A/B");
                } else if (tvResult.getText().toString().trim().equals("C")) {
                    tvShow.setText("C");
                } else if (tvResult.getText().toString().trim().equals("C-")) {
                    tvShow.setText("C-");
                } else if (tvResult.getText().toString().trim().equals("D")) {
                    tvShow.setText("D");
                } else if (tvResult.getText().toString().trim().equals("D+")) {
                    tvShow.setText("D+");
                }
                break;
            case R.id.btn_save_result:
                saveResult();
                break;
            case R.id.btn_cancel_result:
                finish();
                break;
        }
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
