package com.gt.dev.ilifebelt.nseilifebelt.fragments.gt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;

/**
 * Created by Community on 25/01/17.
 */

public class GTCarFragment extends AbstractStep implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6;
    private int click;
    private String title;
    public static int cars;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.gt_car_fragment, container, false);


        btn1 = (Button) v.findViewById(R.id.btn_1_gtcar);
        btn0 = (Button) v.findViewById(R.id.btn_0_gtcar);
        btn2 = (Button) v.findViewById(R.id.btn_2_gtcar);
        btn3 = (Button) v.findViewById(R.id.btn_3_gtcar);
        btn4 = (Button) v.findViewById(R.id.btn_4_gtcar);
        btn5 = (Button) v.findViewById(R.id.btn_5_gtcar);
        btn6 = (Button) v.findViewById(R.id.btn_6_gtcar);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

        return v;
    }

    @Override
    public String name() {
        return "Carros";
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
            case R.id.btn_0_gtcar:
                cars = 0;
                click++;
                break;
            case R.id.btn_1_gtcar:
                cars = 750;
                click++;
                break;
            case R.id.btn_2_gtcar:
                cars = 1890;
                click++;
                break;
            case R.id.btn_3_gtcar:
                cars = 3174;
                click++;
                break;
            case R.id.btn_4_gtcar:
                cars = 4616;
                click++;
                break;
            case R.id.btn_5_gtcar:
                cars = 6025;
                click++;
                break;
            case R.id.btn_6_gtcar:
                cars = 7850;
                click++;
                break;
        }
    }
}
