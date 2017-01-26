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

public class GTEmployesFragment extends AbstractStep implements View.OnClickListener {

    private Button btn0, btn1, btn2, btn3, btn4;
    public static int employe;
    private String title;
    private int click;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.gt_employes_fragment, container, false);

        btn0 = (Button) v.findViewById(R.id.btn_0_gtemployes);
        btn1 = (Button) v.findViewById(R.id.btn_1_gtemployes);
        btn2 = (Button) v.findViewById(R.id.btn_2_gtemployes);
        btn3 = (Button) v.findViewById(R.id.btn_3_gtemployes);
        btn4 = (Button) v.findViewById(R.id.btn_4_gtemployes);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        return v;
    }

    @Override
    public String name() {
        return "Empleados";
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
            case R.id.btn_0_gtemployes:
                employe = 0;
                click++;
                break;
            case R.id.btn_1_gtemployes:
                employe = 950;
                click++;
                break;
            case R.id.btn_2_gtemployes:
                employe = 2500;
                click++;
                break;
            case R.id.btn_3_gtemployes:
                employe = 4155;
                click++;
                break;
            case R.id.btn_4_gtemployes:
                employe = 6560;
                click++;
                break;
        }
    }
}
