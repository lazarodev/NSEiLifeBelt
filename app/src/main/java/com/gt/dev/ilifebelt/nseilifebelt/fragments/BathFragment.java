package com.gt.dev.ilifebelt.nseilifebelt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;

/**
 * Created by Community on 27/10/16.
 */

public class BathFragment extends AbstractStep {

    private TextView tvTest;

    public int getVarBath() {
        return varBath;
    }

    public void setVarBath(int varBath) {
        this.varBath = varBath;
    }

    int varBath, contador, sendValue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bath_fragment, container, false);
        tvTest = (TextView) v.findViewById(R.id.tv_test);

        //contador = 2;

        //sendValue = varBath + contador;
        //String mensaje = String.valueOf(sendValue);
        //Log.d("BATH FRAGMENT", mensaje);

        return v;
    }

    @Override
    public String name() {
        String banos = "Baños";
        return banos;
    }

    public void bathValor() {
        varBath = 3;
    }

    public void b_updateText(String t) {
        tvTest.setText(t);
    }
}
