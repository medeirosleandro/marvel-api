package com.leandro.marvelapp.models;

import com.squareup.moshi.Json;

public class Url {

    @Json(name = "type")
    private String type;
    @Json(name = "url")
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
