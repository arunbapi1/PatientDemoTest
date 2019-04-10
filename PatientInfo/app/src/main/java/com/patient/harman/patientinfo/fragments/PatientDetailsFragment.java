package com.patient.harman.patientinfo.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.patient.harman.patientinfo.R;
import com.patient.harman.patientinfo.base.BaseFragment;
import com.patient.harman.patientinfo.data.model.PatientDetailsModel;
import com.patient.harman.patientinfo.util.ViewModelFactory;
import com.patient.harman.patientinfo.viewmodel.PatientDetailsViewModel;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by arupanig on 4/9/2019.
 */

public class PatientDetailsFragment extends BaseFragment {
    @BindView(R.id.tv_patient_name)
    TextView patientNameTextView;
    @BindView(R.id.tv_clinician)
    TextView clinicianTextView;
    @BindView(R.id.tv_location)
    TextView locationTextView;
    @BindView(R.id.tv_state)
    TextView stateTextView;
    @BindView(R.id.tv_bay)
    TextView bayTextView;
    @BindView(R.id.tv_bed)
    TextView bedTextView;
    @BindView(R.id.tv_label)
    TextView labelTextView;
    @BindView(R.id.tv_value)
    TextView valueTextView;

    @BindView(R.id.card_view_clinician)
    CardView clinicianCardView;

    @Inject
    ViewModelFactory viewModelFactory;
    private PatientDetailsViewModel detailsViewModel;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_patient_details;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(PatientDetailsViewModel.class);
        displayPatientDetails();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(getString(R.string.patient_details));
    }

    private void displayPatientDetails() {
        detailsViewModel.getSelectedPatientDetails().observe(this, data -> {
            if (data != null) {
                PatientDetailsModel detailsModel = new PatientDetailsModel(data);

                clinicianCardView.setVisibility(detailsModel.getClinicianVisibility());
                locationTextView.setVisibility(detailsModel.getLocationVisibility());
                stateTextView.setVisibility(detailsModel.getSiteVisibility());
                bayTextView.setVisibility(detailsModel.getBayVisibility());
                bedTextView.setVisibility(detailsModel.getBedVisibility());
                labelTextView.setVisibility(detailsModel.getNHSLabelVisibility());
                valueTextView.setVisibility(detailsModel.getNHSValueVisibility());

                patientNameTextView.setText(detailsModel.getPatientName());
                clinicianTextView.setText(detailsModel.getClinician());
                locationTextView.setText(detailsModel.getLocation());
                stateTextView.setText(detailsModel.getSite());
                bayTextView.setText(detailsModel.getBay());
                bedTextView.setText(detailsModel.getBed());
                labelTextView.setText(detailsModel.getNHSLabel());
                valueTextView.setText(detailsModel.getNHSValue());
            }
        });
    }
}
