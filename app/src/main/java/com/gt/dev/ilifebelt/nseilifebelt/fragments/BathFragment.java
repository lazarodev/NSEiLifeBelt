package com.gt.dev.ilifebelt.nseilifebelt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;

/**
 * Created by Community on 27/10/16.
 */

public class BathFragment extends AbstractStep implements View.OnClickListener {

    public static int bath;
    private Button btn1, btn2, btn3, btn4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bath_fragment, container, false);

        btn1 = (Button) v.findViewById(R.id.btn_00_bath);
        btn2 = (Button) v.findViewById(R.id.btn_01_bath);
        btn3 = (Button) v.findViewById(R.id.btn_03_bath);
        btn4 = (Button) v.findViewById(R.id.btn_04_bath);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        return v;
    }

    @Override
    public String name() {
        String banos = "Baños";
        return banos;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_00_bath:
                bath = 0;
                break;
            case R.id.btn_01_bath:
                bath = 16;
                break;
            case R.id.btn_02_bath:
                bath = 36;
                break;
            case R.id.btn_03_bath:
                bath = 36;
                break;
            case R.id.btn_04_bath:
                bath = 52;
                break;
        }
    }
}
