package com.gengar.justflow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

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
        popularInAreaRecycler = findViewById(R.id.popular_in_area_recycler);
        topChartRecycler = findViewById(R.id.top_charts_recycler);


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
        final RoomAdapter adapter = new RoomAdapter(this,list);

        LinearLayoutManager horizontalLayoutManagaerRoom = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        yourRoomRecycler.setLayoutManager(horizontalLayoutManagaerRoom);
        yourRoomRecycler.setAdapter(adapter);

        LinearLayoutManager horizontalLayoutManagaerpopular = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        popularInAreaRecycler.setLayoutManager(horizontalLayoutManagaerpopular);
        popularInAreaRecycler.setAdapter(adapter);

        final LinearLayoutManager horizontalLayoutManagaerTop = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        topChartRecycler.setLayoutManager(horizontalLayoutManagaerTop);
        topChartRecycler.setAdapter(adapter);

        topChartRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                Log.e("FIRST VISIBLE NUMBER",horizontalLayoutManagaerTop.findFirstCompletelyVisibleItemPosition() + "");
                Log.e("LAST VISIBLE NUMBER",horizontalLayoutManagaerTop.findLastCompletelyVisibleItemPosition() + "");

                if(horizontalLayoutManagaerTop.findFirstCompletelyVisibleItemPosition() != -1) {
                    horizontalLayoutManagaerTop.findViewByPosition(horizontalLayoutManagaerTop.findFirstCompletelyVisibleItemPosition())
                            .setAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.zoom_in));

                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }
}
