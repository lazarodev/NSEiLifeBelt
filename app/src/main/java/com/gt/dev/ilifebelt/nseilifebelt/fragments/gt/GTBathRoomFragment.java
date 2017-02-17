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

public class GTBathRoomFragment extends AbstractStep implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4, btn5;
    public static int bath;
    private int click;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.gt_bathroom_fragment, container, false);

        btn0 = (Button) v.findViewById(R.id.btn_0_gtbath);
        btn1 = (Button) v.findViewById(R.id.btn_01_gtbath);
        btn2 = (Button) v.findViewById(R.id.btn_2_gtbath);
        btn3 = (Button) v.findViewById(R.id.btn_3_gtbath);
        btn4 = (Button) v.findViewById(R.id.btn_4_gtbath);
        btn5 = (Button) v.findViewById(R.id.btn_5_gtbath);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

        return v;
    }

    @Override
    public String name() {
        return "Baños";
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
            case R.id.btn_0_gtbath:
                btn0.setBackgroundResource(R.color.colorPrimary);
                btn0.setTextColor(getResources().getColor(R.color.white));
                bath = 0;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_01_gtbath:
                btn1.setBackgroundResource(R.color.colorPrimary);
                btn1.setTextColor(getResources().getColor(R.color.white));
                bath = 250;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_2_gtbath:
                btn2.setBackgroundResource(R.color.colorPrimary);
                btn2.setTextColor(getResources().getColor(R.color.white));
                bath = 500;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                btn0.setTextColor(getResources().getColor(R.color.white));
                break;
            case R.id.btn_3_gtbath:
                btn3.setBackgroundResource(R.color.colorPrimary);
                btn3.setTextColor(getResources().getColor(R.color.white));
                bath = 1050;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_4_gtbath:
                btn4.setBackgroundResource(R.color.colorPrimary);
                btn4.setTextColor(getResources().getColor(R.color.white));
                bath = 1400;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_5_gtbath:
                btn5.setBackgroundResource(R.color.colorPrimary);
                btn5.setTextColor(getResources().getColor(R.color.white));
                bath = 2250;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
