package com.byte_me.tanaysinghania.ovp.LeaderRecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.byte_me.tanaysinghania.ovp.R;
import com.google.gson.annotations.SerializedName;


/**
 * Created by manel on 10/10/2017.
 */

public class LeaderViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView name;
    public TextView partyname;
    public TextView constituency;
    public TextView info;

    public LeaderViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);

        name = (TextView) itemView.findViewById(R.id.nameField);
        partyname = (TextView) itemView.findViewById(R.id.partyField);
        constituency = (TextView) itemView.findViewById(R.id.constituencyField);
        info = (TextView) itemView.findViewById(R.id.infoField);


    }


    @Override
    public void onClick(View v) {
      //Do-nothing

    }
}
