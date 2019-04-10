package com.patient.harman.patientinfo.viewmodel;

import android.arch.lifecycle.MutableLiveData;

import com.google.gson.JsonObject;
import com.patient.harman.patientinfo.data.model.PatientListData;
import com.patient.harman.patientinfo.data.rest.APIRepoRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by arupanig on 4/7/2019.
 */

public class PatientListViewModel extends BaseViewModel {

    private final MutableLiveData<PatientListData> patientList = new MutableLiveData<>();
    private final APIRepoRepository repoRepository;
    private CompositeDisposable disposable;

    @Inject
    public PatientListViewModel(APIRepoRepository repoRepository) {
        this.repoRepository = repoRepository;
        disposable = new CompositeDisposable();
    }

    /*
    * Method to get get all the Patient List by hitting API.
    * */
    public void makePatientListCall(String token, String baseUrl, JsonObject jsonBody) {
        getProgressDialog().postValue(true);
        disposable.add(repoRepository.getPatientList(token, baseUrl, jsonBody).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<PatientListData>() {
                    @Override
                    public void onSuccess(PatientListData patientListData) {
                        patientList.postValue(patientListData);
                        getProgressDialog().postValue(false);

                    }

                    @Override
                    public void onError(Throwable e) {
                        getProgressDialog().postValue(false);
                        getErrorMsg().postValue("");
                    }
                }));
    }

    public MutableLiveData<PatientListData> getPatientData() {
        return patientList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
