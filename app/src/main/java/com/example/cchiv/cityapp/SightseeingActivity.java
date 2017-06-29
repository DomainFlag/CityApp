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
        arrayList.add(new ItemList("Ștefan cel Mare Central Park", "Relaxed park with landscaped " +
                "gardens, monuments, a large fountain & busts of Romanian writers.", R.drawable
                .sightseeing_1));
        arrayList.add(new ItemList("National Museum of History of Moldova", "The National Museum " +
                "of History of Moldova is a museum in Central Chişinău, Moldova.", R.drawable
                .sightseeing_2));
        arrayList.add(new ItemList("Nativity Cathedral, Chișinău", "The Cathedral of Christ's " +
                "Nativity is the main cathedral of the Moldovan Orthodox Church in Central " +
                "Chișinău, Moldova.", R.drawable.sightseeing_3));
        arrayList.add(new ItemList("Chișinău Botanical Garden", "Large green space with " +
                "reservoirs & around 10,000 species of plants ranging from roses to trees.", R
                .drawable.sightseeing_4));
        arrayList.add(new ItemList("Triumphal arch, Chișinău", "The Triumphal arch is a monument " +
                "situated in Central Chişinău next to the Nativity Cathedral on Piața Marii " +
                "Adunǎri Naționale nr. 2 and directly opposite Government House.", R.drawable
                .sightseeing_5));
        arrayList.add(new ItemList("National Museum of Fine Arts, Chișinău", "The National Museum" +
                " of Fine Arts is a museum in Chișinău, Moldova, founded in November 1939 by " +
                "Alexandru Plămădeală and Auguste Baillayre.", R.drawable.sightseeing_6));
        arrayList.add(new ItemList("Chișinău City Hall", "Chişinău City Hall is a historical and " +
                "architectural monument built in Italian Gothic style located in Central " +
                "Chişinău, Moldova. Originally constructed to house the city Duma in 1901, the " +
                "building was nearly destroyed during World War II.", R.drawable.sightseeing_7));
        arrayList.add(new ItemList("St. Teodora de la Sihla Church", "The St. Teodora de la Sihla" +
                " Church is a cathedral in Central Chişinău, Moldova.", R.drawable.sightseeing_8));
        arrayList.add(new ItemList("Chișinău Water Tower", "The Chișinău Water Tower is an " +
                "architectural monument of Chișinău, Moldova, located at 2 Mitropolit " +
                "Bănulescu-Bodoni Street and built at the end of 19th century after a project by " +
                "Alexander Bernadazzi. It was a main part of Chişinău's water system.", R
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
