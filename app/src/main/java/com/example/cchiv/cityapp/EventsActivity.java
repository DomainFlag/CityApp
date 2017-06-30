package com.example.cchiv.cityapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);

        final ArrayList<ItemList> arrayList = new ArrayList<>();
        arrayList.add(new ItemList(getResources().getString(R.string.event_1), getResources().getString(R.string.event_location_1)));
        arrayList.add(new ItemList(getResources().getString(R.string.event_2), getResources().getString(R.string.event_location_2)));
        arrayList.add(new ItemList(getResources().getString(R.string.event_3),
                getResources().getString(R.string.event_location_3)));
        arrayList.add(new ItemList(getResources().getString(R.string.event_4),
                getResources().getString(R.string.event_location_4)));
        arrayList.add(new ItemList(getResources().getString(R.string.event_5), getResources().getString(R.string.event_location_5)));
        arrayList.add(new ItemList(getResources().getString(R.string.event_6), getResources().getString(R.string.event_location_6)));
        arrayList.add(new ItemList(getResources().getString(R.string.event_7), getResources().getString(R.string.event_location_7)));

        ItemListAdapter itemListAdapter = new ItemListAdapter(this, arrayList, ContextCompat
                .getColor(this, R.color.color_4));
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(itemListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(arrayList.get(position).getLocationText()));
                startActivity(i);
            }
        });
    }
}
