package com.gengar.justflow.room_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gengar.justflow.R;

import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<String> list;

    public RoomAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }


    class RoomCard extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView roomName;
        public TextView numOfPeople;

        public RoomCard(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.room_image);
            roomName = itemView.findViewById(R.id.room_name);
            numOfPeople = itemView.findViewById(R.id.number_of_users);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RoomCard(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_card,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
