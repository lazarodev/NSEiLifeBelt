package com.gt.dev.ilifebelt.nseilifebelt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;

/**
 * Created by Community on 27/10/16.
 */

public class WateringCanFragment extends AbstractStep{

    int varWater;

    public int getVarWater() {
        return varWater;
    }

    public void setVarWater(int varWater) {
        this.varWater = varWater;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.wateringcan_fragment, container, false);
        return v;
    }

    @Override
    public String name() {
        String text = "Regadera";
        return text;
    }

    public void waterValor(){
        this.varWater = 3;
    }
}
