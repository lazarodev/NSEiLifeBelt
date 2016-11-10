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
 * Created by Community on 10/11/16.
 */

public class LibraryAdapter extends BaseAdapter {

    private ArrayList<Library> categoria;
    LayoutInflater inflater;
    Context contexto;

    private TextView tvName, tvEmail, tvNse;

    public LibraryAdapter(ArrayList<Library> cat, Context con) {
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

        convertView = inflater.inflate(R.layout.library_adapter, null);
        Library cat = categoria.get(position);

        tvName = (TextView) convertView.findViewById(R.id.tv_name_library);
        tvEmail = (TextView) convertView.findViewById(R.id.tv_email_library);
        tvNse = (TextView) convertView.findViewById(R.id.tv_nse_library);

        tvName.setText(cat.getLname());
        tvEmail.setText(cat.getLemail());
        tvNse.setText(cat.getLnse());

        return convertView;
    }
}
