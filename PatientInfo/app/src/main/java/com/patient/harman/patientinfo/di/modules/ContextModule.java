package com.patient.harman.patientinfo.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by arupanig on 4/7/2019.
 */

@Module
public abstract class ContextModule {

    @Binds
    abstract Context provideContext(Application application);
}