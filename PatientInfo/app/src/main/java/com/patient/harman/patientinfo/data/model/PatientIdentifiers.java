package com.patient.harman.patientinfo.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arupanig on 4/9/2019.
 */

public class PatientIdentifiers {
    @SerializedName("PrimaryIdentifier")
    private PrimaryIdentifier primaryIdentifier;

    public PrimaryIdentifier getPrimaryIdentifier() {
        return primaryIdentifier;
    }

    public void setPrimaryIdentifier(PrimaryIdentifier primaryIdentifier) {
        this.primaryIdentifier = primaryIdentifier;
    }
}
