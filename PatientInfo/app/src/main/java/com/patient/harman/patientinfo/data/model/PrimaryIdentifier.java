package com.patient.harman.patientinfo.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arupanig on 4/9/2019.
 */

public class PrimaryIdentifier {
    @SerializedName("Label")
    private String label;
    @SerializedName("Status")
    private String status;
    @SerializedName("Value")
    private String value;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
