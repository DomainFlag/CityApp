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

public class SightseeingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sightseeing);

        final ArrayList<ItemList> arrayList = new ArrayList<>();
        arrayList.add(new ItemList(getResources().getString(R.string.sightseeing_1), getResources().getString(R.string.sightseeing_summary_1), R.drawable
                .sightseeing_1));
        arrayList.add(new ItemList(getResources().getString(R.string.sightseeing_2), getResources().getString(R.string.sightseeing_summary_2), R.drawable
                .sightseeing_2));
        arrayList.add(new ItemList(getResources().getString(R.string.sightseeing_3), getResources().getString(R.string.sightseeing_summary_3) +
                "Chișinău, Moldova.", R.drawable.sightseeing_3));
        arrayList.add(new ItemList(getResources().getString(R.string.sightseeing_4), getResources().getString(R.string.sightseeing_summary_4), R
                .drawable.sightseeing_4));
        arrayList.add(new ItemList(getResources().getString(R.string.sightseeing_5), getResources().getString(R.string.sightseeing_summary_5), R.drawable
                .sightseeing_5));
        arrayList.add(new ItemList(getResources().getString(R.string.sightseeing_6), getResources().getString(R.string.sightseeing_summary_6), R.drawable.sightseeing_6));
        arrayList.add(new ItemList(getResources().getString(R.string.sightseeing_7), getResources().getString(R.string.sightseeing_summary_7), R.drawable.sightseeing_7));
        arrayList.add(new ItemList(getResources().getString(R.string.sightseeing_8), getResources().getString(R.string.sightseeing_summary_8), R.drawable.sightseeing_8));
        arrayList.add(new ItemList(getResources().getString(R.string.sightseeing_9), getResources().getString(R.string.sightseeing_summary_9), R
                .drawable.sightseeing_9));

        ItemListAdapter itemListAdapter = new ItemListAdapter(this, arrayList, ContextCompat
                .getColor(this, R.color.color_3));
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(itemListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + arrayList.get(position).getSummaryText());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }

}
