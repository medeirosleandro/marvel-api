package com.leandro.marvelapp.models;

import com.squareup.moshi.Json;

import java.util.List;

public class Character {

    @Json(name = "id")
    private int id;
    @Json(name = "name")
    private String name;
    @Json(name = "description")
    private String description;
    @Json(name = "modified")
    private String modified;
    @Json(name = "thumbnail")
    private Thumbnail thumbnail;
    @Json(name = "resourceURI")
    private String resourceURI;
    @Json(name = "comics")
    private Comics comics;
    @Json(name = "series")
    private Series series;
    @Json(name = "stories")
    private Stories stories;
    @Json(name = "events")
    private Events events;
    @Json(name = "urls")
    private List<Url> urls = null;

    public Character(int id, String name, String description, String modified, Thumbnail thumbnail, String resourceURI, Comics comics, Series series, Stories stories, Events events, List<Url> urls) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.thumbnail = thumbnail;
        this.resourceURI = resourceURI;
        this.comics = comics;
        this.series = series;
        this.stories = stories;
        this.events = events;
        this.urls = urls;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Comics getComics() {
        return comics;
    }

    public void setComics(Comics comics) {
        this.comics = comics;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Stories getStories() {
        return stories;
    }

    public void setStories(Stories stories) {
        this.stories = stories;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

}