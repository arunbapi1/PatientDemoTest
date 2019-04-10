package com.patient.harman.patientinfo.di.modules;

import com.patient.harman.patientinfo.fragments.PatientDetailsFragment;
import com.patient.harman.patientinfo.fragments.PatientListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by arupanig on 4/7/2019.
 */


@Module
public abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    public abstract PatientListFragment provideListFragment();

    @ContributesAndroidInjector
    public abstract PatientDetailsFragment provideDetailsFragment();


}
