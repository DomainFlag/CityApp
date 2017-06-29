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
        arrayList.add(new ItemList("Contabilitatea în construcții. Seminar practic", "http://www" +
                ".civic.md/evenimente/37805-contabilitatea-in-constructii-seminar-practic.html"));
        arrayList.add(new ItemList("Seed Grant MBA Club / Ediție Specială", "http://www.civic" +
                ".md/evenimente/37799-seed-grant-mba-club-editie-speciala.html"));
        arrayList.add(new ItemList("Contabilitatea în organizații necomerciale. Seminar practic",
                "http://www.civic.md/evenimente/37769-contabilitatea-in-organizatii-necomerciale" +
                        "-seminar-practic.html"));
        arrayList.add(new ItemList("Spectacolul Magnificii / Die Glorreichen",
                "http://www.civic.md/evenimente/37764-spectacolul-magnificii-die-glorreichen" +
                        ".html"));
        arrayList.add(new ItemList("Comunicat de presă Forum: Eficiența Energetică", "http://www" +
                ".civic.md/evenimente/37109-comunicat-de-presa-saptamana-globala-pentru-siguranta" +
                "-rutiera-a-onu-in-republica-moldova.html"));
        arrayList.add(new ItemList("Tîrguri cu vînzare organizate de elevi cu spirit " +
                "antreprenorial.", "http://www.civic" +
                ".md/evenimente/37703-tirguri-cu-vinzare-organizate-de-elevi-cu-spirit" +
                "-antreprenorial-editia-2.html"));
        arrayList.add(new ItemList("„Genele geopolitice” ale moldovenilor: între mit şi " +
                "realitate, dezbateri", "http://www.civic" +
                ".md/evenimente/37682-genele-geopolitice-ale-moldovenilor-intre-mit-si-realitate" +
                "-dezbateri.html"));

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
