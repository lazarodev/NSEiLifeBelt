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

public class GTTelevisorFragment extends AbstractStep implements View.OnClickListener {

    private int click;
    public static int tv;
    private Button btn0, btn1, btn2, btn3, btn4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.gt_televisor_fragment, container, false);

        btn0 = (Button) v.findViewById(R.id.btn_0_gttv);
        btn1 = (Button) v.findViewById(R.id.btn_1_gttv);
        btn2 = (Button) v.findViewById(R.id.btn_2_gttv);
        btn3 = (Button) v.findViewById(R.id.btn_3_gttv);
        btn4 = (Button) v.findViewById(R.id.btn_4_gttv);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        return v;
    }

    @Override
    public String name() {
        return "Televisor";
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
            case R.id.btn_0_gttv:
                btn0.setBackgroundResource(R.color.colorPrimary);
                btn0.setTextColor(getResources().getColor(R.color.white));
                tv = 0;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_1_gttv:
                btn1.setBackgroundResource(R.color.colorPrimary);
                btn1.setTextColor(getResources().getColor(R.color.white));
                tv = 145;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_2_gttv:
                btn2.setBackgroundResource(R.color.colorPrimary);
                btn2.setTextColor(getResources().getColor(R.color.white));
                tv = 290;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_3_gttv:
                btn3.setBackgroundResource(R.color.colorPrimary);
                btn3.setTextColor(getResources().getColor(R.color.white));
                tv = 435;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_4_gttv:
                btn4.setBackgroundResource(R.color.colorPrimary);
                btn4.setTextColor(getResources().getColor(R.color.white));
                tv = 580;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
