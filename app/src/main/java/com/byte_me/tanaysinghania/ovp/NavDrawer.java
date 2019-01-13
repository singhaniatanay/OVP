package com.byte_me.tanaysinghania.ovp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.byte_me.tanaysinghania.ovp.Rest.ApiClient;
import com.byte_me.tanaysinghania.ovp.Rest.ApiInterface;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.HashMap;

import ss.com.bannerslider.Slider;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class NavDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private String userID;

    private RecyclerView mLeadersRecyclerView;
    private RecyclerView.Adapter mLeadersAdapter;
    private RecyclerView.LayoutManager mLeadersLayoutManager;
    private ArrayList leaderlist = new ArrayList<LinkedTreeMap<String,Object>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent intent = getIntent();
        userID = intent.getStringExtra("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PicassoImageLoadingService picasso = new PicassoImageLoadingService(this);
        Slider.init(picasso);
        Slider  slider = findViewById(R.id.banner_slider1);
        slider.setAdapter(new MainSliderAdapter());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        mLeadersRecyclerView = (RecyclerView) findViewById(R.id.leaderRecyclerView);
        mLeadersRecyclerView.setNestedScrollingEnabled(false);
        mLeadersRecyclerView.setHasFixedSize(true);
        mLeadersLayoutManager = new LinearLayoutManager(NavDrawer.this);
        mLeadersRecyclerView.setLayoutManager(mLeadersLayoutManager);
        mLeadersAdapter = new com.byte_me.tanaysinghania.ovp.LeaderRecyclerView.LeaderAdapter(leaderlist, NavDrawer.this);
        mLeadersRecyclerView.setAdapter(mLeadersAdapter);
        android.widget.Button castvote = (android.widget.Button) findViewById(R.id.castvote);
        castvote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View nav_home = findViewById(R.id.nav_home);
                View nav_guide =  findViewById(R.id.nav_layout_guideline);
                View polling2 = findViewById(R.id.nav_layout_polling2);
                View nav_leader =  findViewById(R.id.nav_layout_leaders);
                View polling3 = findViewById(R.id.nav_layout_polling3);
                View nav_manifesto =  findViewById(R.id.nav_layout_manifesto);
                View nav_about =  findViewById(R.id.nav_layout_about);
                View nav_poll =  findViewById(R.id.castvote);
                nav_guide.setVisibility(View.GONE);
                nav_leader.setVisibility(View.GONE);
                nav_manifesto.setVisibility(View.GONE);
                nav_poll.setVisibility(View.GONE);
                nav_home.setVisibility(View.GONE);
                nav_home.setVisibility(View.GONE);
                nav_guide.setVisibility(View.GONE);
                polling3.setVisibility(View.GONE);
                polling2.setVisibility(View.VISIBLE);


            }
        });
        android.widget.Button submit = (android.widget.Button) findViewById(R.id.submitquestion);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View nav_home = findViewById(R.id.nav_home);
                    View nav_guide = findViewById(R.id.nav_layout_guideline);
                    View polling2 = findViewById(R.id.nav_layout_polling2);
                    View polling3 = findViewById(R.id.nav_layout_polling3);
                    View nav_leader = findViewById(R.id.nav_layout_leaders);
                    View nav_manifesto = findViewById(R.id.nav_layout_manifesto);
                    View nav_about = findViewById(R.id.nav_layout_about);
                    View nav_poll = findViewById(R.id.castvote);
                    nav_guide.setVisibility(View.GONE);
                    nav_leader.setVisibility(View.GONE);
                    nav_manifesto.setVisibility(View.GONE);
                    nav_poll.setVisibility(View.GONE);
                    nav_home.setVisibility(View.GONE);
                    nav_home.setVisibility(View.GONE);
                    nav_guide.setVisibility(View.GONE);
                    polling2.setVisibility(View.GONE);
                    polling3.setVisibility(View.VISIBLE);


                }
            });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void casVote(){

    }
    private void getLeaders(String userID) {
//        ArrayList<HashMap<String,Object>> historyList = new ArrayList<HashMap<String, java.lang.Object>>();
//        HashMap<String,Object> obj = new HashMap<>();
//        obj.put("partyName","SBKI SOCH");
//        obj.put("name","SIDDHARTH DHAWAN");
//        obj.put("constituency","CHANDPUR, UTTARPRADESH");
//        obj.put("info","Most dignified candidate of up , Started his journey 2 years");
//        HashMap<String,Object> obj2 = new HashMap<>();
//        obj2.put("partyName","Hamari Party");
//        obj2.put("name","Anand");
//        obj2.put("constituency","Pitampura, delhi");
//        obj2.put("info","Most dignified candidate of up , Started his journey 2 years");
//        HashMap<String,Object> obj3 = new HashMap<>();
//        obj3.put("partyName","Sukhi Party");
//        obj3.put("name","SIDDHARTH DHAWAN");
//        obj3.put("constituency","CHANDPUR, UTTARPRADESH");
//        obj3.put("info","Most dignified candidate of up , Started his journey 2 years");
//        HashMap<String,Object> obj4 = new HashMap<>();
//        obj4.put("partyName","SNOTA");
//        obj4.put("name","N/A");
//        obj4.put("constituency","N/A");
//        obj4.put("info","N/A");
//
//        historyList.add(obj);
//        historyList.add(obj2);
//        historyList.add(obj3);
//        historyList.add(obj4);
//
//
//        leaderlist.addAll(historyList);
//                mLeadersAdapter.notifyDataSetChanged();

        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        retrofit2.Call<LeaderHolder> call = apiService.getLeader(userID);
        call.enqueue(new retrofit2.Callback<LeaderHolder>() {

            @Override
            public void onResponse(retrofit2.Call<LeaderHolder> call, retrofit2.Response<LeaderHolder> response) {
                try {
                    LinkedTreeMap<String,Object> data = response.body().getData();
                    ArrayList<LinkedTreeMap<String,Object>> historyList = (ArrayList<LinkedTreeMap<String, Object>>) data.get("data");
                    leaderlist.addAll(historyList);
                    mLeadersAdapter.notifyDataSetChanged();
                }
                catch (Exception e){
                    Log.d("TAG", "History NOt found, error : "+e.getLocalizedMessage());
                }
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {
                // Log error here since request failed
                Log.e("TAG", t.toString());
            }
        });


    }




    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {
            case 0:
                viewHolder.bindImageSlide("https://assets.materialup.com/uploads/dcc07ea4-845a-463b-b5f0-4696574da5ed/preview.jpg");
                break;
            case 1:
                viewHolder.bindImageSlide("https://assets.materialup.com/uploads/20ded50d-cc85-4e72-9ce3-452671cf7a6d/preview.jpg");
                break;
            case 2:
                viewHolder.bindImageSlide("https://assets.materialup.com/uploads/76d63bbc-54a1-450a-a462-d90056be881b/preview.png");
                break;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            View nav_home = findViewById(R.id.nav_home);
            View nav_guide =  findViewById(R.id.nav_layout_guideline);
            View nav_leader =  findViewById(R.id.nav_layout_leaders);
            View nav_manifesto =  findViewById(R.id.nav_layout_manifesto);
           View nav_about =  findViewById(R.id.nav_layout_about);
            View nav_poll =  findViewById(R.id.nav_layout_polling);
            nav_guide.setVisibility(View.GONE);
            nav_leader.setVisibility(View.GONE);
            nav_manifesto.setVisibility(View.GONE);
            nav_poll.setVisibility(View.GONE);
           nav_home.setVisibility(View.GONE);
           nav_about.setVisibility(View.VISIBLE);


        } else if (id == R.id.nav_guidelines) {
            View nav_home = findViewById(R.id.nav_home);
            View nav_guide =  findViewById(R.id.nav_layout_guideline);
            View nav_leader =  findViewById(R.id.nav_layout_leaders);
            View nav_manifesto =  findViewById(R.id.nav_layout_manifesto);
            View nav_about =  findViewById(R.id.nav_layout_about);
            View nav_poll =  findViewById(R.id.nav_layout_polling);
            nav_guide.setVisibility(View.GONE);
            nav_leader.setVisibility(View.GONE);
            nav_manifesto.setVisibility(View.GONE);
            nav_poll.setVisibility(View.GONE);
            nav_home.setVisibility(View.GONE);
            nav_home.setVisibility(View.GONE);
            nav_guide.setVisibility(View.VISIBLE);


        } else if (id == R.id.nav_leaders) {
            // Handle the camera action
            View nav_home = findViewById(R.id.nav_home);
            View nav_guide =  findViewById(R.id.nav_layout_guideline);
            View nav_leader =  findViewById(R.id.nav_layout_leaders);
            View nav_manifesto =  findViewById(R.id.nav_layout_manifesto);
            View nav_about =  findViewById(R.id.nav_layout_about);
            View nav_poll =  findViewById(R.id.nav_layout_polling);
            nav_guide.setVisibility(View.GONE);
            nav_leader.setVisibility(View.GONE);
            nav_manifesto.setVisibility(View.GONE);
            nav_poll.setVisibility(View.GONE);
            nav_home.setVisibility(View.GONE);
            getLeaders(userID);
            nav_home.setVisibility(View.GONE);
            nav_leader.setVisibility(View.VISIBLE);



        } else if (id == R.id.nav_manifesto) {
            View nav_home = findViewById(R.id.nav_home);
            View nav_guide =  findViewById(R.id.nav_layout_guideline);
            View nav_leader =  findViewById(R.id.nav_layout_leaders);
            View nav_manifesto =  findViewById(R.id.nav_layout_manifesto);
            View nav_about =  findViewById(R.id.nav_layout_about);
            View nav_poll =  findViewById(R.id.nav_layout_polling);
            nav_guide.setVisibility(View.GONE);
            nav_leader.setVisibility(View.GONE);
            nav_manifesto.setVisibility(View.GONE);
            nav_poll.setVisibility(View.GONE);
            nav_home.setVisibility(View.GONE);
            nav_home.setVisibility(View.GONE);
            nav_manifesto.setVisibility(View.VISIBLE);


        } else if (id == R.id.nav_polling) {
            View nav_home = findViewById(R.id.nav_home);
            View nav_poll =  findViewById(R.id.castvote);
            View nav_guide =  findViewById(R.id.nav_layout_guideline);
            View nav_leader =  findViewById(R.id.nav_layout_leaders);
            View nav_manifesto =  findViewById(R.id.nav_layout_manifesto);
            View nav_about =  findViewById(R.id.nav_layout_about);
            nav_guide.setVisibility(View.GONE);
            nav_leader.setVisibility(View.VISIBLE);
            nav_manifesto.setVisibility(View.GONE);
            nav_poll.setVisibility(View.GONE);
            nav_home.setVisibility(View.GONE);
            nav_home.setVisibility(View.GONE);
            getLeaders(userID);
            nav_poll.setVisibility(View.VISIBLE);



        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(NavDrawer.this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
