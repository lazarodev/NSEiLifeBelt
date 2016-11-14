package com.gt.dev.ilifebelt.nseilifebelt.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.activity.NSEActivity;

/**
 * Created by Community on 27/10/16.
 */

public class RoomFragment extends AbstractStep implements View.OnClickListener {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;

    public static int room;
    private int click;
    private String title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.room_fragment, container, false);

        btn1 = (Button) v.findViewById(R.id.btn_01_room);
        btn2 = (Button) v.findViewById(R.id.btn_02_room);
        btn3 = (Button) v.findViewById(R.id.btn_03_room);
        btn4 = (Button) v.findViewById(R.id.btn_04_room);
        btn5 = (Button) v.findViewById(R.id.btn_05_room);
        btn6 = (Button) v.findViewById(R.id.btn_06_room);
        btn7 = (Button) v.findViewById(R.id.btn_07_room);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);

        title = getString(R.string.room_title_fragment);

        return v;
    }

    @Override
    public String name() {
        //return getString(R.string.room_title_fragment);
        return "Habitaciones";
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
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01_room:
                onNext();
                room = 0;
                click++;
                break;
            case R.id.btn_02_room:
                room = 0;
                click++;
                break;
            case R.id.btn_03_room:
                room = 0;
                click++;
                break;
            case R.id.btn_04_room:
                room = 0;
                click++;
                break;
            case R.id.btn_05_room:
                room = 8;
                click++;
                break;
            case R.id.btn_06_room:
                room = 8;
                click++;
                break;
            case R.id.btn_07_room:
                room = 14;
                click++;
                break;
        }
    }
}
