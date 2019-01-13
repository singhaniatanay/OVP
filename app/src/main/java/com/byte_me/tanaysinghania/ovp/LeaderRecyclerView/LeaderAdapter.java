package com.byte_me.tanaysinghania.ovp.LeaderRecyclerView;

import android.content.Context;
import android.location.Geocoder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.internal.LinkedTreeMap;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by manel on 03/04/2017.
 */

public class LeaderAdapter extends RecyclerView.Adapter<LeaderViewHolders> {

    private List<HashMap<String,Object>> itemList;
    private Context context;

    public LeaderAdapter(List<HashMap<String,Object>> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public LeaderViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(com.byte_me.tanaysinghania.ovp.R.layout.item_history, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);
        LeaderViewHolders rcv = new LeaderViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(LeaderViewHolders holder, final int position) {

        if(itemList.get(position).get("name")!=null) {
            holder.name.setText(((String) itemList.get(position).get("name")));
        }
        if(itemList.get(position).get("partyName")!=null){
            holder.partyname.setText(((String)itemList.get(position).get("partyName")));
        }
        if(itemList.get(position).get("constituency")!=null){
            holder.constituency.setText(""+itemList.get(position).get("constituency"));
        }
        if(itemList.get(position).get("info")!=null){
            holder.info.setText(""+itemList.get(position).get("info"));
        }



    }
    @Override
    public int getItemCount() {
        return this.itemList.size();
    }


}