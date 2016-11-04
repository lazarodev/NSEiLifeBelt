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
 * Created by Community on 4/11/16.
 */

public class CarsFragment extends AbstractStep implements View.OnClickListener {

    private Button btn00, btn01, btn02, btn03;
    public static int cars;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cars_fragment, container, false);

        btn00 = (Button) v.findViewById(R.id.btn_00_cars);
        btn01 = (Button) v.findViewById(R.id.btn_01_cars);
        btn02 = (Button) v.findViewById(R.id.btn_02_cars);
        btn03 = (Button) v.findViewById(R.id.btn_03_cars);

        btn00.setOnClickListener(this);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);

        return v;
    }

    @Override
    public String name() {
        String autos = "Autos";
        return autos;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_00_cars:
                cars = 0;
                break;
            case R.id.btn_01_cars:
                cars = 32;
                break;
            case R.id.btn_02_cars:
                cars = 41;
                break;
            case R.id.btn_03_cars:
                cars = 58;
                break;
        }
    }
}
