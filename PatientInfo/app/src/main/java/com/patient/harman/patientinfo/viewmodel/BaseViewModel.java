package com.patient.harman.patientinfo.viewmodel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by arupanig on 4/7/2019.
 */

public class BaseViewModel extends ViewModel {

    MutableLiveData<Boolean> progressDialog = new MutableLiveData<>();
    MutableLiveData<String> errorMsg = new MutableLiveData<>();

    public MutableLiveData<Boolean> getProgressDialog() {
        return progressDialog;
    }

    public MutableLiveData<String> getErrorMsg() {
        return errorMsg;
    }
}
