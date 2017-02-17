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

public class GTHomeBreakFragment extends AbstractStep implements View.OnClickListener {

    private Button btnYes, btnNo;
    private int click;
    public static int homebreak;
    int whiteColor = R.color.white;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.gt_homebreak_fragment, container, false);

        btnYes = (Button) v.findViewById(R.id.btn_si_homebreak);
        btnNo = (Button) v.findViewById(R.id.btn_no_gthomebreak);

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

        return v;
    }

    @Override
    public String name() {
        return "Casa de desacanso";
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
            case R.id.btn_si_homebreak:
                btnYes.setBackgroundResource(R.color.colorPrimary);
                btnYes.setTextColor(getResources().getColor(R.color.white));
                homebreak = 944;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_no_gthomebreak:
                btnNo.setBackgroundResource(R.color.colorPrimary);
                btnNo.setTextColor(getResources().getColor(R.color.white));
                homebreak = 0;
                click++;
                Toast.makeText(mStepper, "Puedes continuar", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
