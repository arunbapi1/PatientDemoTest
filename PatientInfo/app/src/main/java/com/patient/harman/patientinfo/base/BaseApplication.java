package com.patient.harman.patientinfo.base;

import com.patient.harman.patientinfo.di.component.ApplicationComponent;
import com.patient.harman.patientinfo.di.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * Created by arupanig on 4/7/2019.
 */

public class BaseApplication extends DaggerApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        component.inject(this);

        return component;
    }
}
