package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.gt.dev.ilifebelt.nseilifebelt.R;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.Library;
import com.gt.dev.ilifebelt.nseilifebelt.adapter.LibraryAdapter;
import com.gt.dev.ilifebelt.nseilifebelt.model.Results;

import java.util.ArrayList;
import java.util.List;

public class LibraryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvResults;
    private ArrayList<Library> inventoryItems = new ArrayList<>();
    //private ArrayAdapter inventoryItemsAdapter;
    private String name;
    private LibraryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Lista de resultados");

        lvResults = (ListView) findViewById(R.id.lv_library_result);
        lvResults.setOnItemClickListener(this);
        showInventorylist();
    }

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
        lvResults.setAdapter(adapter);

        updateList();
    }

    private List<Results> getAll() {
        return new Select().from(Results.class).orderBy("ID").execute();
    }

    private void updateList() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Library cat = (Library) parent.getItemAtPosition(position);

        Bundle bundle = new Bundle();
        bundle.putString("name", cat.getLname());
        bundle.putString("email", cat.getLemail());
        bundle.putString("nse", cat.getLnse());
        startActivity(new Intent(LibraryActivity.this, UserResultActivity.class).putExtras(bundle));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
