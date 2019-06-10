package com.leandro.marvelapp.networking;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class CharacterApi {

    private static final String BASE_URL = "https://gateway.marvel.com";

    private static Retrofit retrofit;
    private static CharacterService characterService;

    private CharacterApi() {

    }

    public static CharacterService getInstance() {
        if (characterService != null) {
            return characterService;
        }
        if (retrofit == null){
            initializeRetrofit();
        }
        characterService = retrofit.create(CharacterService.class);
        return characterService;
    }

    private static void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build();
    }
}
