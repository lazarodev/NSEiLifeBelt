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

public class SpotlightFragment extends AbstractStep implements View.OnClickListener {

    public static int spotligth;
    private Button btn05Spot, btn0610Spot, btn1115Spot, btn1620Spot, btn21Spot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.spotlights_fragment, container, false);

        btn05Spot = (Button) v.findViewById(R.id.btn_05_spot);
        btn0610Spot = (Button) v.findViewById(R.id.btn_610_spot);
        btn1115Spot = (Button) v.findViewById(R.id.btn_1115_spot);
        btn1620Spot = (Button) v.findViewById(R.id.btn_1620_spot);
        btn21Spot = (Button) v.findViewById(R.id.btn_21_spot);

        btn05Spot.setOnClickListener(this);
        btn0610Spot.setOnClickListener(this);
        btn1115Spot.setOnClickListener(this);
        btn1620Spot.setOnClickListener(this);
        btn21Spot.setOnClickListener(this);

        return v;
    }

    @Override
    public String name() {
        String text = "Focos";
        return text;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_05_spot:
                spotligth = 0;
                break;
            case R.id.btn_610_spot:
                spotligth = 15;
                break;
            case R.id.btn_1115_spot:
                spotligth = 27;
                break;
            case R.id.btn_1620_spot:
                spotligth = 32;
                break;
            case R.id.btn_21_spot:
                spotligth = 46;
                break;
        }
    }
}
