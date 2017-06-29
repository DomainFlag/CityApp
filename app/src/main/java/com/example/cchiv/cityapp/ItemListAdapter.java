package com.example.cchiv.cityapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cchiv on 28/06/2017.
 */

public class ItemListAdapter extends ArrayAdapter<ItemList>{

    public int backgroundColor;

    public ItemListAdapter(Context context, ArrayList<ItemList> restaurants, int color) {
        super(context, 0, restaurants);
        backgroundColor = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ItemList restaurant = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_layout, parent, false);
        }

        LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.background_layout);
        linearLayout.setBackgroundColor(backgroundColor);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.background_image);
        if(restaurant.getBackgroundImage() != 0) {
            imageView.setImageResource(restaurant.getBackgroundImage());
        } else {
            imageView.setVisibility(View.GONE);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.title_text);
        textView.setText(restaurant.getHeaderText());

        textView = (TextView) convertView.findViewById(R.id.summary_text);
        textView.setText(restaurant.getSummaryText());

        textView = (TextView) convertView.findViewById(R.id.location_text);
        textView.setText(restaurant.getLocationText());

        return convertView;
    }
}
