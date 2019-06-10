package com.leandro.marvelapp.models;

import com.squareup.moshi.Json;

import java.util.Iterator;
import java.util.List;

public class Data {

    @Json(name = "offset")
    private int offset;
    @Json(name = "limit")
    private int limit;
    @Json(name = "total")
    private int total;
    @Json(name = "count")
    private int count;
    @Json(name = "results")
    private List<Character> characters = null;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Character> getCharacters() {
        for (Iterator<Character> it = characters.iterator(); it.hasNext(); ) {
            Character character = it.next();
            if (character.getThumbnail().getPath().toLowerCase().contains("image_not_available")) {
                it.remove();
            }
        }
        return characters;
    }

    public void setCharacters(List<Character> results) {
        this.characters = characters;
    }

}
