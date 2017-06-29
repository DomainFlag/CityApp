package com.example.cchiv.cityapp;

/**
 * Created by Cchiv on 28/06/2017.
 */

public class ItemList {

    private String headerText;
    private String summaryText;
    private int backgroundImage;
    private String locationText;


    public ItemList(String header, String summary, int background, String location) {
        headerText = header;
        summaryText = summary;
        backgroundImage = background;
        locationText = location;
    }

    public ItemList(String header, String summary, int background) {
        headerText = header;
        summaryText = summary;
        backgroundImage = background;
    }

    public ItemList(String header, String link) {
        headerText = header;
        locationText = link;
    }

    public ItemList(String header, int background) {
        headerText = header;
        backgroundImage = background;
    }

    public String getHeaderText() {
        return headerText;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public int getBackgroundImage() {
        return backgroundImage;
    }

    public String getLocationText() {
        return locationText;
    }
}
