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

public class RestaurantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        final ArrayList<ItemList> arrayList = new ArrayList<>();
        arrayList.add(new ItemList(getResources().getString(R.string.restaurant_1), getResources().getString(R.string.random_string), R.drawable.restaurant_1, getResources().getString(R.string.restaurant_location_1)));
        arrayList.add(new ItemList(getResources().getString(R.string.restaurant_2), getResources().getString(R.string.random_string), R.drawable.restaurant_2, getResources().getString(R.string.restaurant_location_2)));
        arrayList.add(new ItemList(getResources().getString(R.string.restaurant_3), getResources().getString(R.string.random_string), R.drawable.restaurant_3, getResources().getString(R.string.restaurant_location_3)));
        arrayList.add(new ItemList(getResources().getString(R.string.restaurant_4), getResources().getString(R.string.random_string), R.drawable.restaurant_4, getResources().getString(R.string.restaurant_location_4)));
        arrayList.add(new ItemList(getResources().getString(R.string.restaurant_5), getResources().getString(R.string.random_string), R.drawable.restaurant_5, getResources().getString(R.string.restaurant_location_5)));
        arrayList.add(new ItemList(getResources().getString(R.string.restaurant_6), getResources().getString(R.string.random_string), R.drawable.restaurant_6, getResources().getString(R.string.restaurant_location_6)));
        arrayList.add(new ItemList(getResources().getString(R.string.restaurant_7), getResources().getString(R.string.random_string), R.drawable.restaurant_7, getResources().getString(R.string.restaurant_location_7)));
        arrayList.add(new ItemList(getResources().getString(R.string.restaurant_8), getResources().getString(R.string.random_string), R.drawable.restaurant_8, getResources().getString(R.string.restaurant_location_8)));

        ListView listView = (ListView) findViewById(R.id.list_item);
        ItemListAdapter itemListAdapter = new ItemListAdapter(this, arrayList, ContextCompat.getColor(this, R.color.color_1));

        listView.setAdapter(itemListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + arrayList.get(position).getLocationText());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
