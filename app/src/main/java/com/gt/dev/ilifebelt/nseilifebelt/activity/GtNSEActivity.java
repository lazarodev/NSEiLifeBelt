package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.activeandroid.ActiveAndroid;
import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.github.fcannizzaro.materialstepper.style.TabStepper;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTBathRoomFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTCarFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTCreditCarFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTEmployesFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTHomeBreakFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTLivingRoomFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTPhoneFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTSecadoraFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTTelevisorFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.gt.GTVisaFragment;

public class GtNSEActivity extends TabStepper {

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Obtenemos el toolbar y volvemos esta actividad
        // en modo fullscreen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean linear = getIntent().getBooleanExtra("linear", false);

        setErrorTimeout(1500);
        setLinear(linear);
        setTitle("Encuestador GT");

        ActiveAndroid.initialize(getApplication());

        // Agregamos cada uno de los fragmentos a utilizar
        addStep(createFragment(new GTBathRoomFragment()));
        addStep(createFragment(new GTCarFragment()));
        addStep(createFragment(new GTCreditCarFragment()));
        addStep(createFragment(new GTEmployesFragment()));
        addStep(createFragment(new GTHomeBreakFragment()));
        addStep(createFragment(new GTLivingRoomFragment()));
        addStep(createFragment(new GTPhoneFragment()));
        addStep(createFragment(new GTSecadoraFragment()));
        addStep(createFragment(new GTTelevisorFragment()));
        addStep(createFragment(new GTVisaFragment()));

        super.onCreate(savedInstanceState);

    }

    private AbstractStep createFragment(AbstractStep fragment) {
        Bundle b = new Bundle();
        b.putInt("position", i++);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onComplete() {
        super.onComplete();
        saveResult();
    }

    private void saveResult() {
        GTVisaFragment visaFragment = new GTVisaFragment();
        visaFragment.finalValue();
        String finalString = visaFragment.getVarFinal();

        Bundle bundle = new Bundle();
        bundle.putString("result_nse", finalString);
        startActivity(new Intent(GtNSEActivity.this, GTResultActivity.class).putExtras(bundle));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
