package com.patient.harman.patientinfo.data.model;

/**
 * Created by arupanig on 4/8/2019.
 */

public class AccessToken {

    private String Token;
    private String Provider;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getProvider() {
        return Provider;
    }

    public void setProvider(String provider) {
        Provider = provider;
    }
}
