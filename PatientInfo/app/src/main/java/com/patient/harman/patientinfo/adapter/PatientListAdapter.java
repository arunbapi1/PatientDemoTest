package com.patient.harman.patientinfo.adapter;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.patient.harman.patientinfo.R;
import com.patient.harman.patientinfo.data.model.Data;
import com.patient.harman.patientinfo.manager.PatientSelectedListener;
import com.patient.harman.patientinfo.viewmodel.PatientListViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by arupanig on 4/7/2019.
 */

public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.PatientViewHolder> {

    private PatientSelectedListener patientSelectedListener;
    private final List<Data> data = new ArrayList<>();

    public PatientListAdapter(PatientListViewModel viewModel, LifecycleOwner lifecycleOwner, PatientSelectedListener patientSelectedListener) {
        this.patientSelectedListener = patientSelectedListener;
        viewModel.getPatientData().observe(lifecycleOwner, patientListData -> {
            data.clear();
            if (patientListData != null) {
                data.addAll(patientListData.getDataList());
                notifyDataSetChanged();
            }
        });
        setHasStableIds(true);
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_patient_list_item, parent, false);
        return new PatientViewHolder(view, patientSelectedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        holder.bind(data.get(position), ++position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static final class PatientViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_patient_name)
        TextView patientNameTextView;

        private Data data;

        PatientViewHolder(View itemView, PatientSelectedListener patientSelectedListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> {
                if (data != null) {
                    patientSelectedListener.onPatientSelected(data);
                }
            });
        }

        void bind(Data data, int count) {
            this.data = data;

            patientNameTextView.setText(new StringBuffer().append(count).append(". ").append(data.getPatientGivenName()).append(" ").append(data.getPatientFamilyName()));
        }
    }
}

