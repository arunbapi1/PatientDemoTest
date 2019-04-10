package com.patient.harman.patientinfo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.patient.harman.patientinfo.data.model.Data;

import javax.inject.Inject;

/**
 * Created by arupanig on 4/10/2019.
 */

public class PatientDetailsViewModel extends BaseViewModel {
    private final MutableLiveData<Data> patientDetails = new MutableLiveData<>();

    public LiveData<Data> getSelectedPatientDetails() {
        return patientDetails;
    }

    @Inject
    public PatientDetailsViewModel() {
    }

    /*
    * Method to set required Patient Details.
    * */
    public void setSelectedPatientDetails(Data data) {
        if (data != null) {
            patientDetails.setValue(data);
        }
    }
}
