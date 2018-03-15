package com.gengar.justflow;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

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
     private int current = 0;
     private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yourRoomRecycler = findViewById(R.id.you_rooms_recycler);
        popularInAreaRecycler = findViewById(R.id.popular_in_area_recycler);
        topChartRecycler = findViewById(R.id.top_charts_recycler);
        fab = findViewById(R.id.fab_search);


        /*
        coloring nav bar
         */
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));



        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            list.add("aaa");
        }
        final RoomAdapter yourRoomAdapter = new RoomAdapter(this,list);
        LinearLayoutManager horizontalLayoutManagaerRoom = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        yourRoomRecycler.setLayoutManager(horizontalLayoutManagaerRoom);
        yourRoomRecycler.setAdapter(yourRoomAdapter);
        yourRoomRecycler.scrollToPosition(4);
        yourRoomAdapter.notifyItemChanged(4);

        final RoomAdapter popularAdapter = new RoomAdapter(this,list);
        LinearLayoutManager horizontalLayoutManagaerpopular = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        popularInAreaRecycler.setLayoutManager(horizontalLayoutManagaerpopular);
        popularInAreaRecycler.setAdapter(popularAdapter);


        final RoomAdapter topAdapter = new RoomAdapter(this,list);
        final LinearLayoutManager horizontalLayoutManagaerTop = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        topChartRecycler.setLayoutManager(horizontalLayoutManagaerTop);
        topChartRecycler.setAdapter(topAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HOHOHO PUN SAM PARA", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
