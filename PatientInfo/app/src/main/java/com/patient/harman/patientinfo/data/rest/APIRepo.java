package com.patient.harman.patientinfo.data.rest;

import com.google.gson.JsonObject;
import com.patient.harman.patientinfo.data.model.PatientListData;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by arupanig on 4/7/2019.
 */

public interface APIRepo {
    @FormUrlEncoded
    @POST("Home/Login")
    Call<Void> getAccessToken(@Field("EmailAddress") String emailId, @Field("Password") String password, @Field("client_id") String client_id, @Field("redirect_uri") String redirect_uri, @Field("response_type") String response_type);

    @POST
    @Headers({"accept:application/json;version=10"})
    Single<PatientListData> getPatientList(@Header("Authorization") String token, @Url String baseUrl, @Body JsonObject jsonBody);

}
