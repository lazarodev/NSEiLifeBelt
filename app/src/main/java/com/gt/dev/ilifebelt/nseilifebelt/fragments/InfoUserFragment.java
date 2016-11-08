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
    String getResult;
    String varInfo;
    String name;
    String email;

    public static final String TAG = "**NSE**";

    int valorRoom, valueBath, valueSpot, valueStove, valueCars, valueFloor, valueWater, valueStudy, finalCount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVarFinal() {
        return varInfo;
    }

    public void setVarFinal(String varStudy) {
        this.varInfo = varStudy;
    }

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
        name = "example";
    }

    public void theEmail() {
        email = "test@example.com";
    }

    public void finalValue() {

        valorRoom = RoomFragment.room;
        String roomString = String.valueOf(valorRoom);
        Log.d("**ROOM_FRAGMENT**", roomString);

        valueBath = BathFragment.bath;
        String bathString = String.valueOf(valueBath);
        Log.d("**BATH_FRAGMENT**", bathString);

        valueWater = WateringCanFragment.watering;
        String waterString = String.valueOf(valueWater);
        Log.d("**WATER_FRAGMENT**", waterString);


        valueSpot = SpotlightFragment.spotligth;
        String spotString = String.valueOf(valueSpot);
        Log.d("**SPOT_FRAGMENT**", spotString);

        valueCars = CarsFragment.cars;
        String carsString = String.valueOf(valueCars);
        Log.d("**CARS_FRAGMENT", carsString);

        valueStove = StoveFragment.stove;
        String stoveString = String.valueOf(valueStove);
        Log.d("**STOVE_FRAGMENT**", stoveString);

        valueFloor = FloorFragment.floor;
        String floorString = String.valueOf(valueFloor);
        Log.d("**FLOOR_FRAGMENT**", floorString);

        valueStudy = StudyFragment.study;
        String studyString = String.valueOf(valueStudy);
        Log.d("**STUDY_FRAGMENT**", studyString);

        finalCount = valorRoom + valueBath + valueWater + valueSpot + valueStove + valueCars + valueFloor + valueStudy;
        //this.varStudy = finalCount;
        String sumatorio = String.valueOf(finalCount);
        Log.d("**SUMATORIA_TOTAL**", sumatorio);

        if (finalCount <= 32) {
            Log.d(TAG, "E");
            getResult = "E";
        } else if (finalCount >= 33 && finalCount <= 79) {
            Log.d(TAG, "D");
            getResult = "D";
        } else if (finalCount >= 80 && finalCount <= 104) {
            Log.d(TAG, "D+");
            getResult = "D+";
        } else if (finalCount >= 105 && finalCount <= 127) {
            Log.d(TAG, "C-");
            getResult = "C-";
        } else if (finalCount >= 128 && finalCount <= 154) {
            Log.d(TAG, "C");
            getResult = "C";
        } else if (finalCount >= 155 && finalCount <= 192) {
            Log.d(TAG, "C+");
            getResult = "C+";
        } else if (finalCount >= 193) {
            Log.d(TAG, "A/B");
            getResult = "A/B";
        }

        this.varInfo = getResult;
    }
}
