package com.patient.harman.patientinfo.di.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.patient.harman.patientinfo.di.util.ViewModelKey;
import com.patient.harman.patientinfo.util.ViewModelFactory;
import com.patient.harman.patientinfo.viewmodel.AccessTokenViewModel;
import com.patient.harman.patientinfo.viewmodel.PatientDetailsViewModel;
import com.patient.harman.patientinfo.viewmodel.PatientListViewModel;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by arupanig on 4/7/2019.
 */

@Singleton
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AccessTokenViewModel.class)
    abstract ViewModel bindAccessTokenViewModel(AccessTokenViewModel accessTokenViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PatientListViewModel.class)
    abstract ViewModel bindPatientListViewModel(PatientListViewModel patientListViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PatientDetailsViewModel.class)
    abstract ViewModel bindDetailsViewModel(PatientDetailsViewModel detailsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
