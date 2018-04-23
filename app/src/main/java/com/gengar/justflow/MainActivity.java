package com.gengar.justflow;

import android.animation.Animator;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.deezer.sdk.model.Permissions;
import com.gengar.justflow.room_adapter.RoomAdapter;
import com.gengar.justflow.search.Searchable;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

     private RecyclerView yourRoomRecycler;
     private RecyclerView popularInAreaRecycler;
     private RecyclerView topChartRecycler;
     private int current = 0;
     private FloatingActionButton fab;
     private SlidingUpPanelLayout bottom;
     private RelativeLayout playerPreview;
     private View tint;
     private SearchView searchView;
     private boolean isOpen = false;
     private static final String appID = "252922";
    String[] permissions = new String[] {
            Permissions.BASIC_ACCESS,
            Permissions.MANAGE_LIBRARY,
            Permissions.LISTENING_HISTORY };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchView = findViewById(R.id.searchView);
        searchView.setVisibility(View.GONE);
        tint =  findViewById(R.id.tint);
        tint.setVisibility(View.GONE);
        bottom = findViewById(R.id.root);
        playerPreview = findViewById(R.id.palyerPreview);
        yourRoomRecycler = findViewById(R.id.you_rooms_recycler);
        popularInAreaRecycler = findViewById(R.id.popular_in_area_recycler);
        topChartRecycler = findViewById(R.id.top_charts_recycler);
        fab = findViewById(R.id.fab_search);

        tint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gone();

            }
        });



        bottom.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                   // Log.e("OFFSET",slideOffset + "");
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                   if(newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
                       playerPreview.setVisibility(View.GONE);
                       findViewById(R.id.player).setVisibility(View.VISIBLE);

                   }else if(newState == SlidingUpPanelLayout.PanelState.COLLAPSED){
                       playerPreview.setVisibility(View.VISIBLE);
                       findViewById(R.id.player).setVisibility(View.GONE);

                   }

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                Intent i = new Intent(MainActivity.this,Searchable.class);
                i.putExtra("QUERY",query);
                startActivity(i);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        //coloring nav bar
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
       //yourRoomRecycler.scrollToPosition(4);
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

                reveal();

            }
        });

    }

    private void gone() {

        tint.setVisibility(View.GONE);
        searchView.setVisibility(View.GONE);
        reveal();
    }

    private void reveal(){
        ConstraintLayout layoutMain = findViewById(R.id.constr);
        RelativeLayout reveler = findViewById(R.id.reveler);

        int startRadius = 0;
        int endRadius = (int) Math.hypot(layoutMain.getWidth(), layoutMain.getHeight());

        int x,y;
        if(!isOpen) {
             x = reveler.getRight();
             y = reveler.getBottom();
             isOpen = !isOpen;
            searchView.setVisibility(View.VISIBLE);
            searchView.setFocusable(true);
            searchView.requestFocus();
            tint.setVisibility(View.VISIBLE);

        }else {
         x = reveler.getLeft();
         y = reveler.getTop();
            searchView.setVisibility(View.GONE);
            searchView.setFocusable(true);
            searchView.requestFocus();
            tint.setVisibility(View.GONE);
         isOpen = !isOpen;
        }
        Animator animator = ViewAnimationUtils.createCircularReveal(reveler,x,y,startRadius,endRadius);
        animator.start();

    }



}
