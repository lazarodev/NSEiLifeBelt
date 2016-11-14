package com.gt.dev.ilifebelt.nseilifebelt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.github.fcannizzaro.materialstepper.AbstractStep;
import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.activity.NSEActivity;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.Study;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.StudyAdapter;

import java.util.ArrayList;

/**
 * Created by Community on 27/10/16.
 */

public class StudyFragment extends AbstractStep implements AdapterView.OnItemClickListener {

    private ListView lvStudy;
    private ArrayList<Study> categoria = new ArrayList<>();
    public static int study;
    String getResult;
    String varInfo;
    private int click;

    private String title;

    public static final String TAG = "**NSE**";

    int valorRoom, valueBath, valueSpot, valueStove, valueCars, valueFloor, valueWater, finalCount;

    public String getVarFinal() {
        return varInfo;
    }

    public void setVarFinal(String varStudy) {
        this.varInfo = varStudy;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.studies_fragment, container, false);

        lvStudy = (ListView) v.findViewById(R.id.lv_studies);

        title = getString(R.string.study_title_fragment);

        // Items
        categoria.add(new Study(getString(R.string.no_study)));
        categoria.add(new Study(getString(R.string.primary_incomplete)));
        categoria.add(new Study(getString(R.string.primary_completed)));
        categoria.add(new Study(getString(R.string.secundary_incomplete)));
        categoria.add(new Study(getString(R.string.secundary_completed)));
        categoria.add(new Study(getString(R.string.commercial_carrer)));
        categoria.add(new Study(getString(R.string.technic_carrer)));
        categoria.add(new Study(getString(R.string.bachellor_incomplete)));
        categoria.add(new Study(getString(R.string.bachello_completed)));
        categoria.add(new Study(getString(R.string.licenciatura_incomplete)));
        categoria.add(new Study(getString(R.string.licenciatura_completed)));
        categoria.add(new Study(getString(R.string.diploma_master)));
        categoria.add(new Study(getString(R.string.doctor)));

        // Adaptador
        StudyAdapter adapter = new StudyAdapter(categoria, getActivity());
        lvStudy.setAdapter(adapter);
        lvStudy.setOnItemClickListener(this);

        return v;
    }

    @Override
    public String name() {
        return "Studios";
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                study = 0;
                click++;
                break;
            case 1:
                study = 0;
                click++;
                break;
            case 2:
                study = 22;
                click++;
                break;
            case 3:
                study = 22;
                click++;
                break;
            case 4:
                study = 22;
                click++;
                break;
            case 5:
                study = 38;
                click++;
                break;
            case 6:
                study = 38;
                click++;
                break;
            case 7:
                study = 38;
                click++;
                break;
            case 8:
                study = 38;
                click++;
                break;
            case 9:
                study = 52;
                click++;
                break;
            case 10:
                study = 52;
                click++;
                break;
            case 11:
                study = 72;
                click++;
                break;
            case 12:
                study = 72;
                click++;
                break;
        }
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

        finalCount = valorRoom + valueBath + valueWater + valueSpot + valueStove + valueCars + valueFloor + study;
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
