package com.leandro.marvelapp.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Bundle;

import com.leandro.marvelapp.models.MarvelResponse;
import com.leandro.marvelapp.networking.CharacterApi;
import com.leandro.marvelapp.networking.CharacterService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectedCharacterViewModel extends ViewModel {

    private final MutableLiveData<Character> selectedCharacter = new MutableLiveData<>();
    private Call<MarvelResponse> characterCall;

    public LiveData<Character> getSelectedCharacter() {
        return selectedCharacter;
    }

    void setSelectedCharacter(Character character) {
        selectedCharacter.setValue(character);
    }

    public void saveToBundle(Bundle outState) {
        if (selectedCharacter.getValue() != null) {
            outState.putStringArray("character_details", new String[]{
                    String.valueOf(selectedCharacter.getValue().getId())
            });
        }
    }

    public void restoreFromBundle(Bundle savedInstanceState) {
        if (selectedCharacter.getValue() == null) {
            if(savedInstanceState != null && savedInstanceState.containsKey("character_details")) {
                loadCharacter(savedInstanceState.getStringArray("character_details"));
            }
        }
    }

    private void loadCharacter(String[] character_details) {
        characterCall = CharacterApi.getInstance().getCharacter(character_details[0],
                CharacterService.apikey,
                CharacterService.ts
        );
        characterCall.enqueue(new Callback<MarvelResponse>() {
            @Override
            public void onResponse(Call<MarvelResponse> call, Response<MarvelResponse> response) {
                selectedCharacter.setValue(response.body().getData().getCharacters().get(0));
                characterCall = null;
            }

            @Override
            public void onFailure(Call<MarvelResponse> call, Throwable t) {
                //TODO handle this later
                characterCall = null;
            }
        });
    }

    @Override
    protected void onCleared() {
        if (characterCall != null) {
            characterCall.cancel();
            characterCall = null;
        }
    }
}
