package com.patient.harman.patientinfo.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arupanig on 4/9/2019.
 */

public class Messages {
    @SerializedName("Code")
    private String Code;
    @SerializedName("Message")
    private String Message;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
