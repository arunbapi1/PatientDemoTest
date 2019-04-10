package com.patient.harman.patientinfo.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.patient.harman.patientinfo.R;
import com.patient.harman.patientinfo.adapter.PatientListAdapter;
import com.patient.harman.patientinfo.base.BaseFragment;
import com.patient.harman.patientinfo.data.model.Data;
import com.patient.harman.patientinfo.data.model.PatientListData;
import com.patient.harman.patientinfo.manager.PatientSelectedListener;
import com.patient.harman.patientinfo.util.Constant;
import com.patient.harman.patientinfo.util.ViewModelFactory;
import com.patient.harman.patientinfo.viewmodel.AccessTokenViewModel;
import com.patient.harman.patientinfo.viewmodel.PatientDetailsViewModel;
import com.patient.harman.patientinfo.viewmodel.PatientListViewModel;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by arupanig on 4/7/2019.
 */

public class PatientListFragment extends BaseFragment implements PatientSelectedListener {

    @BindView(R.id.recyclerView)
    RecyclerView listView;
    @BindView(R.id.tv_error)
    TextView errorTextView;
    @BindView(R.id.loading_view)
    View loadingView;

    @Inject
    ViewModelFactory viewModelFactory;
    private PatientListViewModel viewModel;

    private String authToken;
    private PatientListData patientListDatas;

    @Override
    protected int layoutRes() {
        return R.layout.fragment_patient_list;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PatientListViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        listView.setAdapter(new PatientListAdapter(viewModel, this, this));
        listView.setLayoutManager(new LinearLayoutManager(getContext()));

        if (isNetworkConnected()) {
            if(authToken == null) {
                makeAccessTokenCall(Constant.EMAIL_ID, Constant.PASSWORD, Constant.CLIENT_ID, Constant.REDIRECT_URL, Constant.RESPONSE_TYPE);
            }else {
                loadingView.setVisibility(View.GONE);
            }
        } else {
            Toast.makeText(getContext(), getString(R.string.internet_error_msg), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onPatientSelected(Data data) {
        PatientDetailsViewModel detailsViewModel = ViewModelProviders.of(getBaseActivity(), viewModelFactory).get(PatientDetailsViewModel.class);
        detailsViewModel.setSelectedPatientDetails(data);
        getBaseActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, new PatientDetailsFragment())
                .addToBackStack(null).commit();
    }

    protected void makeAccessTokenCall(String emailId, String password, String client_id, String redirect_uri, String response_type) {

        AccessTokenViewModel accessTokenViewModel = ViewModelProviders.of(this, viewModelFactory).get(AccessTokenViewModel.class);
        accessTokenViewModel.getProgressDialog().observe(this, isLoading -> {
            if (isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                }
            }
        });
        accessTokenViewModel.getAccessToken().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String token) {
                authToken = token;
                if (isNetworkConnected()) {
                    if(authToken != null && patientListDatas == null) {
                        makePatientListCall(authToken);
                    }else {
                        loadingView.setVisibility(View.GONE);
                    }
                } else {
                    Toast.makeText(getContext(), getString(R.string.internet_error_msg), Toast.LENGTH_SHORT).show();
                }
            }
        });
        accessTokenViewModel.getErrorMsg().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                errorTextView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            }
        });

        accessTokenViewModel.makePassportTokenCall(emailId, password, client_id, redirect_uri, response_type);
    }

    protected void makePatientListCall(String token) {

        viewModel.getProgressDialog().observe(this, isLoading -> {
            if (isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    errorTextView.setVisibility(View.GONE);
                    listView.setVisibility(View.GONE);
                }
            }
        });
        viewModel.getPatientData().observe(this, new Observer<PatientListData>() {
            @Override
            public void onChanged(@Nullable PatientListData patientListData) {
                patientListDatas = patientListData;
                errorTextView.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
            }
        });
        viewModel.getErrorMsg().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                errorTextView.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            }
        });
        final String BASE_URL = "https://appdevapi.doccom.me/groups/3061/patients";
        final JsonObject jsonBody = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("HandoverNotes");
        try {

            jsonBody.addProperty("ItemsPerPage", 50);
            jsonBody.add("Include", jsonArray);
            jsonBody.addProperty("Page", 0);
        } catch (Exception e) {

        }
        String base = "Bearer %s";
        viewModel.makePatientListCall("3061", String.format(base, token), BASE_URL, jsonBody);
    }
}
