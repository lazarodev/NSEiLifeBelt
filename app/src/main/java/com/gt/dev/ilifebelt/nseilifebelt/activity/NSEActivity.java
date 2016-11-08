package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.activeandroid.ActiveAndroid;
import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.github.fcannizzaro.materialstepper.style.TabStepper;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.BathFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.CarsFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.FloorFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.InfoUserFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.RoomFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.SpotlightFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.StoveFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.StudyFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.WateringCanFragment;
import com.gt.dev.ilifebelt.nseilifebelt.model.Results;

public class NSEActivity extends TabStepper {

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean linear = getIntent().getBooleanExtra("linear", false);

        setErrorTimeout(1500);
        setLinear(linear);
        setTitle("Tab Stepper <small>(" + (linear ? "" : "Non ") + "Linear)</small>");
        setAlternativeTab(true);

        ActiveAndroid.initialize(getApplication());

        addStep(createFragment(new RoomFragment()));
        addStep(createFragment(new BathFragment()));
        addStep(createFragment(new WateringCanFragment()));
        addStep(createFragment(new SpotlightFragment()));
        addStep(createFragment(new CarsFragment()));
        addStep(createFragment(new StoveFragment()));
        addStep(createFragment(new FloorFragment()));
        addStep(createFragment(new StudyFragment()));
        addStep(createFragment(new InfoUserFragment()));

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

        InfoUserFragment infoUserFragment = new InfoUserFragment();
        infoUserFragment.finalValue();
        String finalString = infoUserFragment.getVarFinal();
        infoUserFragment.theName();
        String theName = infoUserFragment.getName();
        infoUserFragment.theEmail();
        String theEmail = infoUserFragment.getEmail();

        //String finalResult = String.valueOf(valorStudy);
        Log.d("FINAL RESULT", finalString);
        Bundle bundle = new Bundle();
        bundle.putString("result_nse", finalString);
        bundle.putString("result_name", theName);
        bundle.putString("result_email", theEmail);
        startActivity(new Intent(NSEActivity.this, ResultActivity.class).putExtras(bundle));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
