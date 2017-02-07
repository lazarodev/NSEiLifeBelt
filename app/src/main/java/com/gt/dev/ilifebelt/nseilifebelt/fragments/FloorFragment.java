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

public class FloorFragment extends AbstractStep implements View.OnClickListener {

    public static int floor;

    private Button btnYesFloor, btnNoFloor;

    private String title;

    private int click;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.floor_fragment, container, false);
        btnYesFloor = (Button) v.findViewById(R.id.btn_yes_floor);
        btnNoFloor = (Button) v.findViewById(R.id.btn_no_floor);

        btnYesFloor.setOnClickListener(this);
        btnNoFloor.setOnClickListener(this);

        title = getString(R.string.piso_title_fragment);

        return v;
    }

    @Override
    public String name() {
        return "Piso";
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
            case R.id.btn_yes_floor:
                floor = 11;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_no_floor:
                floor = 0;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
