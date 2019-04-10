package com.patient.harman.patientinfo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by arupanig on 4/9/2019.
 */

public class PatientListData {
    @SerializedName("Messages")
    List<Messages> messages;
    @SerializedName("Data")
    List<Data> dataList;

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}
