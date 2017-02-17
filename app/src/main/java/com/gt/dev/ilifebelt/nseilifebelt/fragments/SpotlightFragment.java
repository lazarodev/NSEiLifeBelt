package com.gt.dev.ilifebelt.nseilifebelt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;

/**
 * Created by Community on 27/10/16.
 */

public class SpotlightFragment extends AbstractStep implements View.OnClickListener {

    public static int spotligth;
    private Button btn05Spot, btn0610Spot, btn1115Spot, btn1620Spot, btn21Spot;
    private String title;
    private int click;

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

        title = getString(R.string.spotlight_title_fragment);

        return v;
    }

    @Override
    public String name() {
        return "Focos";
    }

    @Override
    public boolean nextIf() {
        return click > 0;
    }

    @Override
    public String error() {
        return getString(R.string.validate_click);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_05_spot:
                btn05Spot.setBackgroundResource(R.color.colorPrimary);
                btn05Spot.setTextColor(getResources().getColor(R.color.white));
                spotligth = 0;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_610_spot:
                btn0610Spot.setBackgroundResource(R.color.colorPrimary);
                btn0610Spot.setTextColor(getResources().getColor(R.color.white));
                spotligth = 15;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_1115_spot:
                btn1115Spot.setBackgroundResource(R.color.colorPrimary);
                btn1115Spot.setTextColor(getResources().getColor(R.color.white));
                spotligth = 27;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_1620_spot:
                btn1620Spot.setBackgroundResource(R.color.colorPrimary);
                btn1620Spot.setTextColor(getResources().getColor(R.color.white));
                spotligth = 32;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_21_spot:
                btn21Spot.setBackgroundResource(R.color.colorPrimary);
                btn21Spot.setTextColor(getResources().getColor(R.color.white));
                spotligth = 46;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
