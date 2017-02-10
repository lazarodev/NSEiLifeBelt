package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.analytics.Tracker;
import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.controller.MyApplication;
import com.gt.dev.ilifebelt.nseilifebelt.model.Results;

public class GTResultActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSave, btnCancel;
    private EditText etName, etEmail;
    private TextView tvResult;
    private String resultNSE, name, email;
    private MyApplication myApp;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gtresult);
        startVars();
        getSource();
    }

    private void startVars() {
        btnSave = (Button) findViewById(R.id.btn_gt_save_result);
        btnCancel = (Button) findViewById(R.id.btn_gt_cancel_result);
        etName = (EditText) findViewById(R.id.et_gt_name_nse);
        etEmail = (EditText) findViewById(R.id.et_gt_email_nse);
        tvResult = (TextView) findViewById(R.id.tv_gt_result);

        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        startAnalytics();
    }

    private void startAnalytics() {
        myApp = (MyApplication) getApplication();
        mTracker = myApp.getDefaultTracker();
    }

    private void getSource() {
        Bundle bundle = getIntent().getExtras();
        resultNSE = bundle.getString("result_nse");

        tvResult.setText(resultNSE);
    }

    // guardando el resultado en una base de datos
    private void saveResult() {
        Results result = new Results();
        name = etName.getText().toString().trim();
        email = etEmail.getText().toString().trim();
        result.name = name;
        result.email = email;
        result.nse = resultNSE;
        result.save();
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_gt_save_result:
                if (etEmail.getText().toString().equals("") | etName.getText().toString().equals("")) {
                    Toast.makeText(this, getString(R.string.validate_name_email), Toast.LENGTH_SHORT).show();
                } else {
                    saveResult();
                }
                break;
            case R.id.btn_gt_cancel_result:
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
