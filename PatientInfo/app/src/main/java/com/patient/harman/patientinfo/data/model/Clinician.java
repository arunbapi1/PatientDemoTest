package com.patient.harman.patientinfo.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arupanig on 4/9/2019.
 */

public class Clinician {
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("FullName")
    private String fullName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("Title")
    private String title;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
