package com.patient.harman.patientinfo.data.rest;

/**
 * Response listener for API requests.
 * Created by arupanig on 4/7/2019.
 */

public interface ResponseListener<T> {
    void onSuccess(T t);

    void onError(String msg);
}
