package com.patient.harman.patientinfo.data.model;

import android.view.View;

/**
 * Created by arupanig on 4/10/2019.
 */

public class PatientDetailsModel {
    private Data data;
    private final String emptyString = "";

    public PatientDetailsModel(Data data) {
        this.data = data;
    }


    private boolean isDataAvailable() {
        return data != null ? true : false;
    }

    public String getPatientName() {
        if (isDataAvailable()) {
            return new StringBuffer().append(data.getPatientFamilyName()).append(" ").append(data.getPatientGivenName()).toString();
        } else {
            return emptyString;
        }
    }

    public int getClinicianVisibility() {
        return data.getClinician().getFullName() != null ? View.VISIBLE : View.GONE;
    }

    public String getClinician() {
        if (isDataAvailable()) {
            return new StringBuffer().append("Clinician : ").append(data.getClinician().getFullName()).toString();
        } else {
            return emptyString;
        }
    }

    public int getSiteVisibility() {
        return data.getSiteName() != null && data.getSiteName().length() > 0 ? View.VISIBLE : View.GONE;
    }

    public String getSite() {
        if (isDataAvailable()) {
            return new StringBuffer().append("Site : ").append(data.getSiteName()).toString();
        } else {
            return emptyString;
        }
    }

    public int getLocationVisibility() {
        return data.getAddress() != null && data.getAddress().length() > 0 ? View.VISIBLE : View.GONE;
    }

    public String getLocation() {
        if (isDataAvailable()) {
            return new StringBuffer().append("Location : ").append(data.getSiteName()).toString();
        } else {
            return emptyString;
        }
    }

    public int getBayVisibility() {
        return data.getBay() != null && data.getBay().length() > 0 ? View.VISIBLE : View.GONE;
    }

    public String getBay() {
        if (isDataAvailable()) {
            return new StringBuffer().append("Bay : ").append(data.getBay()).toString();
        } else {
            return emptyString;
        }
    }

    public int getBedVisibility() {
        return data.getBed() != null && data.getBed().length() > 0 ? View.VISIBLE : View.GONE;
    }

    public String getBed() {
        if (isDataAvailable()) {
            return new StringBuffer().append("Bed : ").append(data.getBed()).toString();
        } else {
            return emptyString;
        }
    }

    private boolean isNHSAvailable() {
        return isDataAvailable() && data.getPatientIdentifiers() != null
                && data.getPatientIdentifiers().getPrimaryIdentifier() != null;
    }

    private PrimaryIdentifier getNHSData() {
        if (isDataAvailable()) {
            return data.getPatientIdentifiers().getPrimaryIdentifier();
        } else {
            return null;
        }
    }

    public int getNHSLabelVisibility() {
        return isNHSAvailable() && getNHSData().getLabel() != null && getNHSData().getLabel().length() > 0 ? View.VISIBLE : View.GONE;
    }

    public String getNHSLabel() {
        if (isNHSAvailable()) {
            return new StringBuffer().append("Label : ").append(getNHSData().getLabel()).toString();
        } else {
            return emptyString;
        }
    }

    public int getNHSValueVisibility() {
        return isNHSAvailable() && getNHSData().getValue() != null && getNHSData().getValue().length() > 0 ? View.VISIBLE : View.GONE;
    }

    public String getNHSValue() {
        if (isNHSAvailable()) {
            return new StringBuffer().append("Value : ").append(getNHSData().getValue()).toString();
        } else {
            return emptyString;
        }
    }
}
