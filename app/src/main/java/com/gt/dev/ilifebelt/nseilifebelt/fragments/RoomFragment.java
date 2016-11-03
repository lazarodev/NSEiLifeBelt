package com.gt.dev.ilifebelt.nseilifebelt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.activity.NSEActivity;

/**
 * Created by Community on 27/10/16.
 */

public class RoomFragment extends AbstractStep implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    int varRoom, piBot;

    public int getVarRoom() {
        return varRoom;
    }

    public void setVarRoom(int varRoom) {
        this.varRoom = varRoom;
    }

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

        return v;
    }

    @Override
    public String name() {
        String hola = "Habitaciones";
        return hola;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01_room:
                NSEActivity nseActivity1 = new NSEActivity();
                nseActivity1.room = 1;
                break;
            case R.id.btn_02_room:
                NSEActivity nseActivity2 = new NSEActivity();
                nseActivity2.room = 2;
                break;
            case R.id.btn_03_room:
                NSEActivity nseActivity3 = new NSEActivity();
                nseActivity3.room = 3;
                break;
            case R.id.btn_04_room:
                NSEActivity nseActivity4 = new NSEActivity();
                nseActivity4.room = 4;
                break;
            case R.id.btn_05_room:
                NSEActivity nseActivity5 = new NSEActivity();
                nseActivity5.room = 5;
                break;
            case R.id.btn_06_room:
                NSEActivity nseActivity6 = new NSEActivity();
                nseActivity6.room = 6;
                break;
            case R.id.btn_07_room:
                NSEActivity nseActivity7 = new NSEActivity();
                nseActivity7.room = 7;
                break;
        }
    }

    public void llegaValor() {
        varRoom = piBot;
    }

    public void setValue1(int t) {
        piBot = t;
    }
}
