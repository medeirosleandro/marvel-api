package com.leandro.marvelapp.models;

import com.squareup.moshi.Json;

import java.util.List;

public class Stories {

    @Json(name = "available")
    private int available;
    @Json(name = "collectionURI")
    private String collectionURI;
    @Json(name = "items")
    private List<Item__> items = null;
    @Json(name = "returned")
    private int returned;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<Item__> getItems() {
        return items;
    }

    public void setItems(List<Item__> items) {
        this.items = items;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

}
