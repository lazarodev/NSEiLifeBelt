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

public class FloorFragment extends AbstractStep {

    int varFloor;

    public int getVarFloor() {
        return varFloor;
    }

    public void setVarFloor(int varFloor) {
        this.varFloor = varFloor;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.floor_fragment, container, false);
        return v;
    }

    @Override
    public String name() {
        String text = "Piso";
        return text;
    }

    public void floorValor() {
        this.varFloor = 2;
    }

}
