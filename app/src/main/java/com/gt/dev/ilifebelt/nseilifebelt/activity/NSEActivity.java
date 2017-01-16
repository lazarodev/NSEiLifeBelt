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
import com.gt.dev.ilifebelt.nseilifebelt.fragments.RoomFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.SpotlightFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.StoveFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.StudyFragment;
import com.gt.dev.ilifebelt.nseilifebelt.fragments.WateringCanFragment;

/**
 * Clase que extiende de la super clase TabStepper.
 */
public class NSEActivity extends TabStepper {

    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Obtenemos el toolbar y volvemos esta actividad
        // en modo fullscreen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean linear = getIntent().getBooleanExtra("linear", false);

        setErrorTimeout(1500);
        setLinear(linear);
        setTitle("Encuestador");
        //setAlternativeTab(true);

        ActiveAndroid.initialize(getApplication());

        // Agregamos cada uno de los fragmentos a utilizar
        addStep(createFragment(new RoomFragment()));
        addStep(createFragment(new BathFragment()));
        addStep(createFragment(new WateringCanFragment()));
        addStep(createFragment(new SpotlightFragment()));
        addStep(createFragment(new CarsFragment()));
        addStep(createFragment(new StoveFragment()));
        addStep(createFragment(new FloorFragment()));
        addStep(createFragment(new StudyFragment()));
        //addStep(createFragment(new InfoUserFragment()));

        super.onCreate(savedInstanceState);
    }

    /**
     * Metodo para crear fragment y setearlo en la actividad.
     *
     * @param fragment
     * @return
     */
    private AbstractStep createFragment(AbstractStep fragment) {
        Bundle b = new Bundle();
        b.putInt("position", i++);
        fragment.setArguments(b);
        return fragment;
    }

    /**
     * Metodo cuando el cuestionario es completado.
     */
    @Override
    public void onComplete() {
        super.onComplete();
        saveResult();
    }

    /**
     * Metodo para guardar el resultado en la base de datos.
     */
    private void saveResult() {
        StudyFragment studyFragment = new StudyFragment();
        studyFragment.finalValue();
        String finalString = studyFragment.getVarFinal();

        //String finalResult = String.valueOf(valorStudy);
        Log.d("FINAL RESULT", finalString);
        Bundle bundle = new Bundle();
        bundle.putString("result_nse", finalString);
        startActivity(new Intent(NSEActivity.this, ResultActivity.class).putExtras(bundle));
    }

    /**
     * Metodo nativo para ucando la app entra en 2do plano
     */
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
