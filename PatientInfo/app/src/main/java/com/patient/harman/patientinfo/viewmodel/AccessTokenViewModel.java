package com.patient.harman.patientinfo.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.patient.harman.patientinfo.data.model.AccessToken;
import com.patient.harman.patientinfo.data.rest.APIRepoRepository;

import javax.inject.Inject;

import okhttp3.Headers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by arupanig on 4/7/2019.
 */

public class AccessTokenViewModel extends BaseViewModel {

    private MutableLiveData<String> accessToken = new MutableLiveData<>();
    private final APIRepoRepository repoRepository;

    @Inject
    public AccessTokenViewModel(APIRepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    public void makePassportTokenCall(String emailId, String password, String client_id, String redirect_uri, String response_type) {
        getProgressDialog().postValue(true);
        repoRepository.getAccessToken(emailId, password, client_id, redirect_uri, response_type).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                final String ACCESS_TOKEN = "access_token";
                getProgressDialog().postValue(false);
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    if (ACCESS_TOKEN.equalsIgnoreCase(headers.name(i))) {
                        try {
                            Gson gson = new GsonBuilder().create();
                            AccessToken mAccessToken = gson.fromJson(headers.value(i), AccessToken.class);
                            accessToken.postValue(mAccessToken.getToken());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                getProgressDialog().postValue(false);
                t.printStackTrace();
            }
        });
    }

    public MutableLiveData<String> getAccessToken() {
        return accessToken;
    }

}
