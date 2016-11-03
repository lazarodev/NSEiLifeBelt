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

public class StoveFragment extends AbstractStep {

    public int getVarStove() {
        return varStove;
    }

    public void setVarStove(int varStove) {
        this.varStove = varStove;
    }

    int varStove;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.stove_fragment, container, false);
        return v;
    }

    @Override
    public String name() {
        String text = "Estufa";
        return text;
    }

    public void stoveValor() {
        this.varStove = 2;
    }

}
