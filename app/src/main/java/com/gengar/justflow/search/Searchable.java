package com.gengar.justflow.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gengar.justflow.R;
import com.gengar.justflow.network.Api;
import com.gengar.justflow.network.ApiUtill;
import com.gengar.justflow.pojo.com.gengar.justflow.Search;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Searchable extends AppCompatActivity {

    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        api = ApiUtill.getApi();

        api.getSearchArtist(getIntent().getStringExtra("QUERY"),"json").enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.raw());
                    System.out.println(response.body());


                }else {
                    Toast.makeText(Searchable.this, "Request has faild, just like u did your parents", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {


                t.printStackTrace();
            }
        });

    }

}
