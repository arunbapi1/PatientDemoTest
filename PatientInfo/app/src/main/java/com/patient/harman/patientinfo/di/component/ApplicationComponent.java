package com.patient.harman.patientinfo.di.component;

import android.app.Application;

import com.patient.harman.patientinfo.base.BaseApplication;
import com.patient.harman.patientinfo.di.modules.ActivityBindingModule;
import com.patient.harman.patientinfo.di.modules.ApplicationModule;
import com.patient.harman.patientinfo.di.modules.ContextModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import dagger.android.support.DaggerApplication;

/**
 * Created by arupanig on 4/7/2019.
 */

@Singleton
@Component(modules = {ContextModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(BaseApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
