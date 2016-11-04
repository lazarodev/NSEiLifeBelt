package com.gt.dev.ilifebelt.nseilifebelt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;

/**
 * Created by Community on 27/10/16.
 */

public class WateringCanFragment extends AbstractStep implements View.OnClickListener {

    public static int watering;
    private Button btnYes, btnNo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.wateringcan_fragment, container, false);

        btnYes = (Button) v.findViewById(R.id.btn_yes_water);
        btnNo = (Button) v.findViewById(R.id.btn_no_water);

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
        return v;
    }

    @Override
    public String name() {
        String text = "Regadera";
        return text;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_yes_water:
                watering = 10;
                break;
            case R.id.btn_no_water:
                watering = 0;
                break;
        }
    }
}
