package com.byte_me.tanaysinghania.ovp;

import com.google.gson.annotations.SerializedName;

public class loginHolder {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @SerializedName("data")
    private String data;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public loginHolder(String username, String password) {

        this.username = username;
        this.password = password;
    }
}
