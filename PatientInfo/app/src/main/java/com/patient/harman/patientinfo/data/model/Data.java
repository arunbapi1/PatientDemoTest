package com.patient.harman.patientinfo.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arupanig on 4/9/2019.
 */

public class Data {
    @SerializedName("Address")
    private String address;
    @SerializedName("AreaName")
    private String areaName;
    @SerializedName("Bay")
    private String bay;
    @SerializedName("Bed")
    private String bed;
    @SerializedName("PatientGivenName")
    private String patientGivenName;
    @SerializedName("PatientFamilyName")
    private String patientFamilyName;
    @SerializedName("Clinician")
    private Clinician clinician;
    @SerializedName("PatientIdentifiers")
    private PatientIdentifiers patientIdentifiers;
    @SerializedName("SiteName")
    private String siteName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBay() {
        return bay;
    }

    public void setBay(String bay) {
        this.bay = bay;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getPatientGivenName() {
        return patientGivenName;
    }

    public void setPatientGivenName(String patientGivenName) {
        this.patientGivenName = patientGivenName;
    }

    public String getPatientFamilyName() {
        return patientFamilyName;
    }

    public void setPatientFamilyName(String patientFamilyName) {
        this.patientFamilyName = patientFamilyName;
    }

    public Clinician getClinician() {
        return clinician;
    }

    public void setClinician(Clinician clinician) {
        this.clinician = clinician;
    }

    public PatientIdentifiers getPatientIdentifiers() {
        return patientIdentifiers;
    }

    public void setPatientIdentifiers(PatientIdentifiers patientIdentifiers) {
        this.patientIdentifiers = patientIdentifiers;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}
