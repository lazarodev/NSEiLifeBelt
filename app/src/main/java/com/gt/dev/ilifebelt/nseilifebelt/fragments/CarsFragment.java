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
 * Created by Community on 4/11/16.
 */

public class CarsFragment extends AbstractStep implements View.OnClickListener {

    private Button btn00, btn01, btn02, btn03;
    public static int cars;
    private String title;
    private int click;

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

        title = getString(R.string.cars_title_fragment);

        return v;
    }

    @Override
    public String name() {
        return "Automoviles";
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
            case R.id.btn_00_cars:
                btn00.setBackgroundResource(R.color.colorPrimary);
                btn00.setTextColor(getResources().getColor(R.color.white));
                cars = 0;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_01_cars:
                btn01.setBackgroundResource(R.color.colorPrimary);
                btn01.setTextColor(getResources().getColor(R.color.white));
                cars = 32;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_02_cars:
                btn02.setBackgroundResource(R.color.colorPrimary);
                btn02.setTextColor(getResources().getColor(R.color.white));
                cars = 41;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_03_cars:
                btn03.setBackgroundResource(R.color.colorPrimary);
                btn03.setTextColor(getResources().getColor(R.color.white));
                cars = 58;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
