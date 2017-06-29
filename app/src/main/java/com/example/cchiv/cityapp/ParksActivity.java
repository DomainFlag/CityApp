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

public class ParksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parks);

        final ArrayList<ItemList> arrayList = new ArrayList<>();
        arrayList.add(new ItemList("Stefan cel Mare Park ", R.drawable.park_1));
        arrayList.add(new ItemList("Dendrarium Park",  R.drawable.park_2));
        arrayList.add(new ItemList("Valea Morilor",  R.drawable.park_3));
        arrayList.add(new ItemList("Botanical Garden of the Academy of Sciences of Moldova", R.drawable.park_4));
        arrayList.add(new ItemList("Parcul Catedralei", R.drawable.park_5));
        arrayList.add(new ItemList("Parcul Alunelul",  R.drawable.park_6));
        arrayList.add(new ItemList("Goa Territory", R.drawable.park_7));

        ItemListAdapter itemListAdapter = new ItemListAdapter(this, arrayList, ContextCompat.getColor(this, R.color.color_2));
        ListView listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(itemListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + arrayList.get(position).getHeaderText());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
