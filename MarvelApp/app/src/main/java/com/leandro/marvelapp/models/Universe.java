package com.leandro.marvelapp.models;

public class Universe {

    public final String publicKey;
    public final String privateKey;
    public final String name;

    public Universe(String publicKey, String privateKey, String name) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.name = name;
    }
}
