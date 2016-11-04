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
                varRoom = setValue1(1);
                break;
            case R.id.btn_02_room:
                varRoom = setValue1(1);
                break;
            case R.id.btn_03_room:
                varRoom = setValue1(1);
                break;
            case R.id.btn_04_room:
                varRoom = setValue1(1);
                break;
            case R.id.btn_05_room:
                varRoom = setValue1(1);
                break;
            case R.id.btn_06_room:
                varRoom = setValue1(1);
                break;
            case R.id.btn_07_room:
                varRoom = setValue1(1);
                break;
        }
    }

    public void llegaValor() {
        //this.varRoom = setValue1(3);
    }

    public int setValue1(int l) {
        //this.varRo
        return l;
    }
}
