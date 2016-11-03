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

public class SpotlightFragment extends AbstractStep{

    int varSpot;

    public int getVarSpot() {
        return varSpot;
    }

    public void setVarSpot(int varSpot) {
        this.varSpot = varSpot;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.spotlights_fragment, container, false);
        return v;
    }

    @Override
    public String name() {
        String text = "Focos";
        return text;
    }

    public void spotValor(){
        this.varSpot = 2;
    }
}
