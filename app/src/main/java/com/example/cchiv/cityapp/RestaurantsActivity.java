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
        arrayList.add(new ItemList("Eli Pili", "Text 1", R.drawable.restaurant_1, "str. Bucuresti"));
        arrayList.add(new ItemList("Fusion Restaurant Jeraffe", "Text 1", R.drawable.restaurant_2, "Izmail st., 84, Chisinau 2001, Moldova"));
        arrayList.add(new ItemList("Popasul Dacilor", "Text 1", R.drawable.restaurant_3, "str. Valea Crucii, 13, Chisinau, Moldova"));
        arrayList.add(new ItemList("OSHO bar&kitchen", "Text 1", R.drawable.restaurant_4, "Bd. Decebal 7/1, Chisinau 2001, Moldova"));
        arrayList.add(new ItemList("La Sarkis", "Text 1", R.drawable.restaurant_5, "Nateevici 113 A, Chisinau 2009, Moldova"));
        arrayList.add(new ItemList("Mezzo Italian Restaurant", "Text 1", R.drawable.restaurant_6, "12 Dimitrie Cantemir, Chisinau 2012, Moldova"));
        arrayList.add(new ItemList("Fanconi Cafe", "Text 1", R.drawable.restaurant_7, "str. Renasterii Nationale,5, Chisinau 2005, Moldova"));
        arrayList.add(new ItemList("Marius", "Text 1", R.drawable.restaurant_8, "str. Mihai Eminescu 41 1, Chisinau 2012, Moldova"));

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
