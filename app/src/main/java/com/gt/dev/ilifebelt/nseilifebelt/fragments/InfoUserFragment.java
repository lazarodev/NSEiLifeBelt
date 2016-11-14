package com.gt.dev.ilifebelt.nseilifebelt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;

/**
 * Created by Community on 5/11/16.
 */

public class InfoUserFragment extends AbstractStep {

    private EditText etName, etEmail;
    static String name;
    static String email;

    //private static final String nombre = "Fernando";
    //private static final String correo = "lazaro@elcaldogt.com";

    public static final String TAG = "**NSE**";

    int valorRoom, valueBath, valueSpot, valueStove, valueCars, valueFloor, valueWater, valueStudy, finalCount;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.info_user_fragment, container, false);

        etName = (EditText) v.findViewById(R.id.et_name_nse);
        etEmail = (EditText) v.findViewById(R.id.et_email_nse);

        //name = etName.getText().toString().trim();
        //email = etEmail.getText().toString().trim();

        return v;
    }

    @Override
    public String name() {
        String info = "Informacion";
        return info;
    }

    public void theName() {
        this.name = etName.getText().toString();
        //name = nombre;
    }

    public void theEmail() {
        this.email = etName.getText().toString();
        //email = correo;
    }


}
