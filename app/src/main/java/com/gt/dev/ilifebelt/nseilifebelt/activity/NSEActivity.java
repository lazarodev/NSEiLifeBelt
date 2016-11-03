package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.github.fcannizzaro.materialstepper.style.TabStepper;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.BathFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.FloorFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.RoomFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.SpotlightFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.StoveFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.StudyFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.WateringCanFragment;

public class NSEActivity extends TabStepper {

    private int i = 1;
    public int room, bath, floor, spotlight, stov, study, watering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setErrorTimeout(1500);
        setLinear(false);
        setTitle("Tab Stepper <small>(Classic Tab) </small>");
        setAlternativeTab(false);
        setDisabledTouch();
        setPreviousVisible();

        addStep(createFragment(new RoomFragment()));
        addStep(createFragment(new BathFragment()));
        addStep(createFragment(new WateringCanFragment()));
        addStep(createFragment(new SpotlightFragment()));
        addStep(createFragment(new StoveFragment()));
        addStep(createFragment(new FloorFragment()));
        addStep(createFragment(new StudyFragment()));

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
        StudyFragment studyFragment = new StudyFragment();
        studyFragment.studyValor();
        String valorStudy = studyFragment.getVarStudy();
        //String finalResult = String.valueOf(valorStudy);
        Log.d("FINAL RESULT", valorStudy);
        finish();
    }

}
