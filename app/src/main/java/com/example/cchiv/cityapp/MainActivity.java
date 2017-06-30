package com.example.cchiv.cityapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static class ViewHolder {
        TextView restaurantsView;
        TextView sightseeingView;
        TextView parksView;
        TextView eventsView;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewHolder viewHolder = new ViewHolder();

        viewHolder.restaurantsView = (TextView) findViewById(R.id.restaurants);
        viewHolder.restaurantsView.setOnClickListener(this);

        viewHolder.sightseeingView = (TextView) findViewById(R.id.sightseeing);
        viewHolder.sightseeingView.setOnClickListener(this);

        viewHolder.parksView = (TextView) findViewById(R.id.parks);
        viewHolder.parksView.setOnClickListener(this);

        viewHolder.eventsView = (TextView) findViewById(R.id.events);
        viewHolder.eventsView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.restaurants:
                intent = new Intent(this, RestaurantsActivity.class);
                break;
            case R.id.sightseeing:
                intent = new Intent(this, SightseeingActivity.class);
                break;
            case R.id.parks:
                intent = new Intent(this, ParksActivity.class);
                break;
            case R.id.events:
                intent = new Intent(this, EventsActivity.class);
                break;
        }
        if(intent !=  null)
            startActivity(intent);
    }
}