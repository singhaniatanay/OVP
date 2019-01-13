package com.byte_me.tanaysinghania.ovp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.byte_me.tanaysinghania.ovp.Rest.ApiClient;
import com.byte_me.tanaysinghania.ovp.Rest.ApiInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button signup = (Button) findViewById(R.id.signup);
        Button signin = (Button) findViewById(R.id.signin);
        final EditText voterid = (EditText) findViewById(R.id.voterid);
        final EditText password = (EditText) findViewById(R.id.password1);
        final EditText answer1 = (EditText) findViewById(R.id.answer1);
        final EditText answer2 = (EditText) findViewById(R.id.answer2);
        final EditText answer3 = (EditText) findViewById(R.id.answer3);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    EditText confirmpass = (EditText) findViewById(R.id.password2);
                    if(confirmpass.getVisibility()==View.GONE) {
                        confirmpass.setVisibility(View.VISIBLE);
                        answer1.setVisibility(View.VISIBLE);
                        answer2.setVisibility(View.VISIBLE);
                        answer3.setVisibility(View.VISIBLE);
                    }else{
                        user customer = new user(voterid.getText().toString(),password.getText().toString(),answer1.getText().toString(),answer2.getText().toString(),answer3.getText().toString());
                        final ApiInterface apiService =
                                ApiClient.getClient().create(ApiInterface.class);
                        Call<user> call = apiService.registerCustomer(customer);
                        call.enqueue(new Callback<user>() {

                            @Override
                            public void onResponse(Call<user> call, Response<user> response) {

                                Intent intent = new Intent(MainActivity.this, NavDrawer.class);
                                startActivity(intent);
                                intent.putExtra("id",""+response.body().getData());
                                finish();
                                return;

                            }

                            @Override
                            public void onFailure(Call call, Throwable t) {
                                // Log error here since request failed
                                Log.e("TAG", t.toString());
                            }
                        });

                        Intent intent = new Intent(MainActivity.this, NavDrawer.class);
                        startActivity(intent);

                }

                }

        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    loginHolder customer = new loginHolder(voterid.getText().toString(),password.getText().toString());
                    final ApiInterface apiService =
                            ApiClient.getClient().create(ApiInterface.class);
                    Call<loginHolder> call = apiService.getCustomer(customer);
                    call.enqueue(new Callback<loginHolder>() {

                        @Override
                        public void onResponse(Call<loginHolder> call, Response<loginHolder> response) {

                            Intent intent = new Intent(MainActivity.this, NavDrawer.class);
                            startActivity(intent);
                            intent.putExtra("id",""+response.body().getData());//+response.body().getId()
                            finish();
                            return;

                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {
                            // Log error here since request failed
                            Log.e("TAG", t.toString());
                        }
                    });



                }

            });



    }
}
