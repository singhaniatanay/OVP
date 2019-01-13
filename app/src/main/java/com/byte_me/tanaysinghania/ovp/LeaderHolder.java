package com.byte_me.tanaysinghania.ovp;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

public class LeaderHolder {

    public LeaderHolder(LinkedTreeMap<String, Object> data) {
        this.data = data;
    }

    public LinkedTreeMap<String, Object> getData() {
        return data;
    }

    public void setData(LinkedTreeMap<String, Object> data) {
        this.data = data;
    }

    @SerializedName("data")
    private LinkedTreeMap<String,Object> data;

}
