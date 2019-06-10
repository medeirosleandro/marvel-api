package com.leandro.marvelapp.models;

import com.squareup.moshi.Json;

public class Thumbnail {

    @Json(name = "path")
    private String path;
    @Json(name = "extension")
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

}
