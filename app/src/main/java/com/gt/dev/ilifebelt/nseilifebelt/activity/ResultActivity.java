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

/**
 * Clase que muestra el resultado despues de finalizada la encuesta.
 */
public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnShow, btnCancel, btnSave;
    private TextView tvResult, tvShow;
    private EditText etName, etEmail;
    private String resultNSE;
    private String name, email;

    private MyApplication myApp;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnShow = (Button) findViewById(R.id.btn_show_info);
        btnSave = (Button) findViewById(R.id.btn_save_result);
        btnCancel = (Button) findViewById(R.id.btn_cancel_result);
        tvResult = (TextView) findViewById(R.id.tv_result_nse);
        tvShow = (TextView) findViewById(R.id.tv_more_info);
        etName = (EditText) findViewById(R.id.et_name_nse);
        etEmail = (EditText) findViewById(R.id.et_email_nse);

        btnShow.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnCancel.setOnClickListener(this);

        getSource();

        startAnalytics();
    }

    private void startAnalytics() {
        myApp = (MyApplication) getApplication();
        mTracker = myApp.getDefaultTracker();
    }

    //Getting the data from the last activit with the nse result
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

    /**
     * Metodo nativo para indicar la accion a cada boton segun el caso.
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_info:
                if (tvResult.getText().toString().trim().equals("C+")) {
                    tvShow.setText(getString(R.string.cplus_nse_text));
                } else if (tvResult.getText().toString().trim().equals("E")) {
                    tvShow.setText(getString(R.string.e_nse_text));
                } else if (tvResult.getText().toString().trim().equals("A/B")) {
                    tvShow.setText(getString(R.string.ab_nse_text));
                } else if (tvResult.getText().toString().trim().equals("C")) {
                    tvShow.setText(getString(R.string.c_nse_text));
                } else if (tvResult.getText().toString().trim().equals("C-")) {
                    tvShow.setText(getString(R.string.cless_nse_text));
                } else if (tvResult.getText().toString().trim().equals("D")) {
                    tvShow.setText(getString(R.string.d_nse_text));
                } else if (tvResult.getText().toString().trim().equals("D+")) {
                    tvShow.setText(getString(R.string.dplus_nse_text));
                }
                break;
            case R.id.btn_save_result:
                if (etEmail.getText().toString().equals("") | etName.getText().toString().equals("")) {
                    Toast.makeText(this, getString(R.string.validate_name_email), Toast.LENGTH_SHORT).show();
                } else {
                    saveResult();
                }
                break;
            case R.id.btn_cancel_result:
                finish();
                break;
        }
    }

    /**
     * Metodo nativo cuando la actividad entra background
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Metodo nativo cuando la actividad regresa de background
     */
    @Override
    protected void onResume() {
        super.onResume();
    }
}
