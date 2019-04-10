package com.patient.harman.patientinfo.activities;

import android.os.Bundle;

import com.patient.harman.patientinfo.R;
import com.patient.harman.patientinfo.base.BaseActivity;
import com.patient.harman.patientinfo.fragments.PatientListFragment;

/**
 * Created by arupanig on 4/6/2019.
 */

public class PatientAtHomeActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_patient_home;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            addFragment(new PatientListFragment(), R.id.container);
        }
    }
}
