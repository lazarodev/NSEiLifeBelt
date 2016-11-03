package com.gt.dev.ilifebelt.nseilifebelt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gt.dev.ilifebelt.nseilifebelt.R;

import java.util.ArrayList;

/**
 * Created by Community on 28/10/16.
 */

public class StudyAdapter extends BaseAdapter {

    private ArrayList<Study> categoria;
    LayoutInflater inflater;
    Context contexto;

    TextView tvTitle;

    public StudyAdapter(ArrayList<Study> cat, Context con) {
        this.categoria = cat;
        inflater = LayoutInflater.from(con);
        this.contexto = con;
    }

    @Override
    public int getCount() {
        return categoria.size();
    }

    @Override
    public Object getItem(int position) {
        return categoria.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.study_adapter, null);
        Study study = categoria.get(position);
        tvTitle = (TextView) convertView.findViewById(R.id.tv_study);
        tvTitle.setText(study.getTitle());

        return convertView;
    }
}
