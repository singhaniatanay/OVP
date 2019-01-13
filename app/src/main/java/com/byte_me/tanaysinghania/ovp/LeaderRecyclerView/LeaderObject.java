package com.byte_me.tanaysinghania.ovp.LeaderRecyclerView;

import com.google.gson.annotations.SerializedName;

/**
 * Created by manel on 10/10/2017.
 */

public class LeaderObject {


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getConstituency() {
        return constituency;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @SerializedName("name")
    private String name;

    @SerializedName("partyName")
    private String partyName;

    @SerializedName("constituency")
    private String constituency;

    @SerializedName("info")
    private String info;




    public LeaderObject(String name,String partyName,String constituency,String info) {

       this.name = name;
       this.constituency = constituency;
       this.partyName = partyName;
       this.info = info;
    }
}
