package com.leandro.marvelapp.home;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.leandro.marvelapp.models.MarvelResponse;
import com.leandro.marvelapp.networking.CharacterApi;
import com.leandro.marvelapp.networking.CharacterService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListViewModel extends ViewModel {

    private final MutableLiveData<List<Character>> characters = new MutableLiveData<>();
    private final MutableLiveData<Boolean> characterLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    private Call<MarvelResponse> dataCall;

    public ListViewModel() {
        fetchCharacters();
    }

    LiveData<List<Character>> getCharacters() {
        return characters;
    }

    LiveData<Boolean> getError() {
        return characterLoadError;
    }

    LiveData<Boolean> getLoading() {
        return loading;
    }

    private void fetchCharacters() {
        loading.setValue(true);
        dataCall = CharacterApi.getInstance().getCharacters(CharacterService.apikey,
                                                            CharacterService.hash,
                                                            CharacterService.ts
        );
        dataCall.enqueue(new Callback<MarvelResponse>() {
            @Override
            public void onResponse(Call<MarvelResponse> call, Response<MarvelResponse> response) {
                characterLoadError.setValue(false);
                characters.setValue(response.body().getData().getCharacters());
                loading.setValue(false);
                dataCall = null;
            }

            @Override
            public void onFailure(Call<MarvelResponse> call, Throwable t) {
                characterLoadError.setValue(true);
                loading.setValue(false);
                dataCall = null;
            }
        });
    }

    @Override
    protected void onCleared() {
        if (dataCall != null) {
            dataCall.cancel();
            dataCall = null;
        }
    }
}
