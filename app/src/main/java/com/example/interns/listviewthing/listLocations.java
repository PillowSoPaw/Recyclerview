package com.example.interns.listviewthing;

import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class listLocations extends ActionBarActivity {

    private RecyclerView recyclerView;
    private listLocations_Recyclerview_Adapter adapter;

    String[]locations;
   // String[] locations = {"ajkfa","adhaksjdhakjsdh","kdfhasjkdhaksjdh","askldhahkl","fuck me","fuck my life"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_locations);
        locations = getResources().getStringArray(R.array.locations);
        recyclerView = (RecyclerView) findViewById(R.id.listLocations);
        adapter = new listLocations_Recyclerview_Adapter(this,getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public List<location> getData(){
        List<location> data = new ArrayList<>();
        int icon = R.drawable.generic_building;

        for(int i = 0; i<locations.length;i++){
            location current = new location();
            current.name = locations[i];
            data.add(current);
        }

        return data;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_locations, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
