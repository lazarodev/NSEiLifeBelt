package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.activeandroid.query.Select;
import com.google.android.gms.analytics.Tracker;
import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.Library;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.LibraryAdapter;
import com.gt.dev.ilifebelt.nseilifebelt.controller.MyApplication;
import com.gt.dev.ilifebelt.nseilifebelt.model.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Actividad que muestra los registro de los usuarios.
 */
public class LibraryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvResults;
    private ArrayList<Library> inventoryItems = new ArrayList<>();
    //private ArrayAdapter inventoryItemsAdapter;
    private String name;
    private LibraryAdapter adapter;
    private MyApplication myApp;
    private TextView tvNoItem;
    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lista de resultados");

        tvNoItem = (TextView) findViewById(R.id.tv_message_no_item_library);
        lvResults = (ListView) findViewById(R.id.lv_library_result);
        lvResults.setOnItemClickListener(this);

        showInventorylist();

        startAnalytics();
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Para ver los resultados debes al menos registrar un resultado del calculo de nivel socio económico").show();
    }

    private void startAnalytics() {
        myApp = (MyApplication) getApplication();
        mTracker = myApp.getDefaultTracker();
    }

    /**
     * Metodo que muestra los registros de la base de datos
     */
    private void showInventorylist() {
        List<Results> inventories = getAll();

        //adding all items to the list
        for (int i = 0; i < inventories.size(); i++) {
            Results results = inventories.get(i);
            inventoryItems.add(new Library(results.name, results.email, results.nse));
            //inventoryItems.add(results.name);
            //inventoryItems.add(results.email);
            //inventoryItems.add(results.nse);
        }

        //creating own adapter
        adapter = new LibraryAdapter(inventoryItems, this);
        //adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, inventoryItems);
        //lvResults.setAdapter(adapter);

        // validacion barbara
        if (adapter.getCount() != 0) {
            lvResults.setAdapter(adapter);
        } else {
            showDialog();
            tvNoItem.setVisibility(View.VISIBLE);
        }

        updateList();
    }

    private List<Results> getAll() {
        return new Select().from(Results.class).orderBy("ID").execute();
    }

    private void updateList() {
        adapter.notifyDataSetChanged();
    }

    /**
     * Metodo nativo para indicar que envia a la siguiente actividad
     * segun el item que se seleccione
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Library cat = (Library) parent.getItemAtPosition(position);

        Bundle bundle = new Bundle();
        bundle.putString("name", cat.getLname());
        bundle.putString("email", cat.getLemail());
        bundle.putString("nse", cat.getLnse());
        startActivity(new Intent(LibraryActivity.this, UserResultActivity.class).putExtras(bundle));
    }

    /**
     * Metodo nativo cuando se presiona algun boton del actionbar
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Metodo nativo cuando la actividad entra en pausa.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Metodo nativo cuando la actividad regresa de la pausa.
     */
    @Override
    protected void onResume() {
        super.onResume();
    }
}
