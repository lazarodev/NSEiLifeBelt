package com.gt.dev.ilifebelt.nseilifebelt.fragments.gt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;

/**
 * Created by Community on 25/01/17.
 */

public class GTVisaFragment extends AbstractStep implements View.OnClickListener {

    private Button btnYes, btnNo;
    private int click;
    public static int visa;
    String varInfo, getResult;

    int valorGtBath, valueGtCar, valueGtCredit, valueGtEmploy, valueGtHome, valueGtLiving, valueGtPhone, valueGtSecadora, valueGtTv, valueGtVisa, finalCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.gt_visa_fragment, container, false);

        btnYes = (Button) v.findViewById(R.id.btn_si_gtvisa);
        btnNo = (Button) v.findViewById(R.id.btn_no_gtvisa);

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

        return v;
    }

    public String getVarFinal() {
        return varInfo;
    }

    @Override
    public String name() {
        return "Visa";
    }

    @Override
    public boolean nextIf() {
        return click > 0;
    }

    @Override
    public String error() {
        return getString(R.string.validate_click);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_si_gtvisa:
                visa = 5348;
                click++;
                break;
            case R.id.btn_no_gtvisa:
                visa = 0;
                click++;
                break;
        }
    }

    public void finalValue() {
        valorGtBath = GTBathRoomFragment.bath;
        String gtBathSTring = String.valueOf(valorGtBath);
        Log.d("**BATH_FRAGMENT", gtBathSTring);

        valueGtCar = GTCarFragment.cars;
        String gtCarString = String.valueOf(valueGtCar);
        Log.d("CAR_FRAGMENT", gtCarString);

        valueGtCredit = GTCreditCarFragment.credit;
        String gtCreditString = String.valueOf(valueGtCredit);
        Log.d("**CREDIT_FRAGMENT**", gtCreditString);

        valueGtEmploy = GTEmployesFragment.employe;
        String gtEmployString = String.valueOf(valueGtEmploy);
        Log.d("**EMPLOYE_FRAGMENT**", gtEmployString);

        valueGtHome = GTHomeBreakFragment.homebreak;

        valueGtLiving = GTLivingRoomFragment.living;

        valueGtPhone = GTPhoneFragment.phone;

        valueGtSecadora = GTSecadoraFragment.secadora;

        valueGtTv = GTTelevisorFragment.tv;

        valueGtVisa = GTVisaFragment.visa;

        finalCount = valorGtBath + valueGtCar + valueGtCredit + valueGtEmploy + valueGtHome + valueGtLiving + valueGtPhone + valueGtSecadora + valueGtTv + valueGtVisa;

        String sumatorio = String.valueOf(finalCount);
        Log.d("**SUMATORIA_TOTAL", sumatorio);

        if (finalCount <= 749) {
            getResult = "D2";
        } else if (finalCount >= 750 && finalCount <= 5999) {
            getResult = "D1";
        } else if (finalCount >= 6000 && finalCount <= 10499) {
            getResult = "C3";
        } else if (finalCount >= 10500 && finalCount <= 17999) {
            getResult = "C2";
        } else if (finalCount >= 18000 && finalCount <= 23999) {
            getResult = "C1";
        } else if (finalCount >= 24000 && finalCount <= 26249) {
            getResult = "B";
        } else if (finalCount >= 26250) {
            getResult = "A";
        }

        this.varInfo = getResult;
    }

}
