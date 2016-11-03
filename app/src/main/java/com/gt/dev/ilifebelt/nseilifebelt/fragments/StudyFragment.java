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

    int studyContador = 0;
    String getResult, varStudy;

    public static final String TAG = "**NSE**";

    public String getVarStudy() {
        return varStudy;
    }

    public void setVarStudy(String varStudy) {
        this.varStudy = varStudy;
    }

    int finalCount;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.studies_fragment, container, false);

        lvStudy = (ListView) v.findViewById(R.id.lv_studies);

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

        studyContador++;

        int value = 20 + studyContador;

        String result = String.valueOf(value);

        //Log.d("**FINAL_RESULT**", result);

        return v;
    }

    @Override
    public String name() {
        String text = "Estudios";
        return text;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    public void studyValor() {

        int valorRoom = 240;
        String finalResult = String.valueOf(valorRoom);
        Log.d("**ROOM_FRAGMENT**", finalResult);
        /*if (arguments != null && arguments.containsKey("key")){
            valorRoom = arguments.getInt("key");
            String finalResult = String.valueOf(valorRoom);
            Log.d("**ROOM_FRAGMENT**", finalResult);
        }*/

        BathFragment bathFragment = new BathFragment();
        bathFragment.bathValor();
        int valorBath = bathFragment.getVarBath();
        String bathString = String.valueOf(valorBath);
        Log.d("**BATH_FRAGMENT**", bathString);

        WateringCanFragment wateringCanFragment = new WateringCanFragment();
        wateringCanFragment.waterValor();
        int valorWater = wateringCanFragment.getVarWater();
        String waterString = String.valueOf(valorWater);
        Log.d("**WATER_FRAGMENT", waterString);

        finalCount = valorRoom + valorBath + valorWater;
        //this.varStudy = finalCount;

        if (finalCount <= 60) {
            Log.d(TAG, "E");
            getResult = "E";
        } else if (finalCount >= 61 && finalCount <= 101) {
            Log.d(TAG, "D");
            getResult = "D";
        } else if (finalCount >= 102 && finalCount <= 156) {
            Log.d(TAG, "D+");
            getResult = "D+";
        } else if (finalCount >= 157 && finalCount <= 191) {
            Log.d(TAG, "C");
            getResult = "C";
        } else if (finalCount >= 192 && finalCount <= 241) {
            Log.d(TAG, "C+");
            getResult = "C+";
        } else if (finalCount >= 242) {
            Log.d(TAG, "A/B");
            getResult = "A/B";
        }

        this.varStudy = getResult;
    }

}
