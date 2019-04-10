package com.patient.harman.patientinfo.data.rest;

import com.google.gson.JsonObject;
import com.patient.harman.patientinfo.data.model.PatientListData;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Call;

/**
 * Created by arupanig on 4/7/2019.
 */

public class APIRepoRepository {

    private final APIRepo repoService;

    @Inject
    public APIRepoRepository(APIRepo repoService) {
        this.repoService = repoService;
    }

    public Call<Void> getAccessToken(String emailId, String password, String client_id, String redirect_uri, String response_type) {
        return repoService.getAccessToken(emailId, password, client_id, redirect_uri, response_type);
    }

    public Single<PatientListData> getPatientList(String token, String baseUrl, JsonObject body) {
        return repoService.getPatientList(token, baseUrl, body);
    }
}
