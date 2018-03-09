package com.gengar.justflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.gengar.justflow.room_adapter.RoomAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

     private RecyclerView yourRoomRecycler;
     private RecyclerView popularInAreaRecycler;
     private RecyclerView topChartRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yourRoomRecycler = findViewById(R.id.you_rooms_recycler);


        /*
        coloring nav bar
         */
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));



        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add("aaa");
        }
        RoomAdapter adapter = new RoomAdapter(this,list);

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        yourRoomRecycler.setLayoutManager(horizontalLayoutManagaer);
        yourRoomRecycler.setAdapter(adapter);
/*
        RecyclerView.LayoutManager popularInAreaManager = new LinearLayoutManager(this);
        popularInAreaRecycler.setLayoutManager(popularInAreaManager);
        popularInAreaRecycler.setAdapter(adapter);

        RecyclerView.LayoutManager topChartsManager = new LinearLayoutManager(this);
        topChartRecycler.setLayoutManager(topChartsManager);
        topChartRecycler.setAdapter(adapter);*/

    }
}
