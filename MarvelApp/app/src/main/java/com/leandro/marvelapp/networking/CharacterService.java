package com.leandro.marvelapp.networking;

import com.leandro.marvelapp.models.MarvelResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static java.lang.System.currentTimeMillis;

public interface CharacterService {

    //pubkey = apikey
    String apikey = "1a2a6b2b530da5269430bad823bf7d99";
    String privatekey = "b1d87544fcb8efa54aab332d5b59d9c0321d5fb0";
    String ts = String.valueOf(currentTimeMillis());

    @GET("/v1/public/characters")
    Call<MarvelResponse> getCharacters(@Query("apikey") String apikey,
                                       @Query("hash") String hash,
                                       @Query("ts") String ts
    );

    @GET("/v1/public/characters/{characterId}")
    Call<MarvelResponse> getCharacter(@Path("characterId") String characterId,
                                      @Query("apikey") String apikey,
                                      @Query("hash") String hash,
                                      @Query("ts") String ts
    );
}
