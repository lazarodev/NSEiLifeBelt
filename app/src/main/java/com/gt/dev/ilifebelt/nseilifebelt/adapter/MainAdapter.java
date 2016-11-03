package com.gt.dev.ilifebelt.nseilifebelt.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gt.dev.ilifebelt.nseilifebelt.R;

import java.util.ArrayList;

/**
 * Created by Lazarus on 25/10/2016.
 */

public class MainAdapter extends BaseAdapter {

    private ArrayList<Main> categoria;
    LayoutInflater inflater;
    Context contexto;

    // Widgets
    ImageView picture;
    TextView tvTitle, tvDescription;

    public MainAdapter(ArrayList<Main> cat, Context con) {
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

        convertView = inflater.inflate(R.layout.main_adapter, null);
        Main cat = categoria.get(position);
        picture = (ImageView) convertView.findViewById(R.id.iv_main);
        tvTitle = (TextView) convertView.findViewById(R.id.tv_title_main);
        tvDescription = (TextView) convertView.findViewById(R.id.tv_description_main);

        picture.setImageResource(cat.getPicture());
        tvTitle.setText(cat.getTitle());
        tvDescription.setText(cat.getDescription());

        return convertView;
    }
}
