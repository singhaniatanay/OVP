package com.byte_me.tanaysinghania.ovp;

import com.google.gson.annotations.SerializedName;

public class user {
    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("data")
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @SerializedName("answer1")
    private String answer1;

    @SerializedName("answer2")
    private String answer2;

    @SerializedName("answer3")
    private String answer3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("id")
    private String id;

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

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public user(String username, String password, String answer1, String answer2, String answer3) {

        this.username = username;
        this.password = password;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }
}
