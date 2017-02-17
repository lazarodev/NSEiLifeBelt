package com.gt.dev.ilifebelt.nseilifebelt.fragments.gt;

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
                btn0.setBackgroundResource(R.color.colorPrimary);
                btn0.setTextColor(getResources().getColor(R.color.white));
                cars = 0;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_1_gtcar:
                btn1.setBackgroundResource(R.color.colorPrimary);
                btn1.setTextColor(getResources().getColor(R.color.white));
                cars = 750;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_2_gtcar:
                btn2.setBackgroundResource(R.color.colorPrimary);
                btn2.setTextColor(getResources().getColor(R.color.white));
                cars = 1890;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_3_gtcar:
                btn3.setBackgroundResource(R.color.colorPrimary);
                btn3.setTextColor(getResources().getColor(R.color.white));
                cars = 3174;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_4_gtcar:
                btn4.setBackgroundResource(R.color.colorPrimary);
                btn4.setTextColor(getResources().getColor(R.color.white));
                cars = 4616;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_5_gtcar:
                btn5.setBackgroundResource(R.color.colorPrimary);
                btn5.setTextColor(getResources().getColor(R.color.white));
                cars = 6025;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_6_gtcar:
                btn6.setBackgroundResource(R.color.colorPrimary);
                btn6.setTextColor(getResources().getColor(R.color.white));
                cars = 7850;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
