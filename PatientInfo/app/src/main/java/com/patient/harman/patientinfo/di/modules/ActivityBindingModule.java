package com.patient.harman.patientinfo.di.modules;

import com.patient.harman.patientinfo.activities.PatientAtHomeActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by arupanig on 4/7/2019.
 */

@Module
public abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = {FragmentBindingModule.class})
    abstract PatientAtHomeActivity bindPatientAtHomeActivity();
}