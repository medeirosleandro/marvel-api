package com.leandro.marvelapp.models;

import com.squareup.moshi.Json;

public class Item__ {

    @Json(name = "resourceURI")
    private String resourceURI;
    @Json(name = "name")
    private String name;
    @Json(name = "type")
    private String type;

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}