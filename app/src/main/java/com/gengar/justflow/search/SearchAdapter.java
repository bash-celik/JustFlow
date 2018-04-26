package com.gengar.justflow.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gengar.justflow.R;
import com.gengar.justflow.pojo.com.gengar.justflow.Datum;
import com.gengar.justflow.pojo.com.gengar.justflow.Search;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Datum> list = new ArrayList<>();
    private Context context;

    public SearchAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<Datum> list) {
        this.list = list;
    }


    public SearchAdapter(Search search, Context context) {
        this.list = search.getData();
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchVH(LayoutInflater.from(context)
                .inflate(R.layout.search_card_layout,null));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((SearchVH) holder).artist.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class SearchVH extends RecyclerView.ViewHolder {

        public TextView title, artist,duration;
        public ImageView image;

        public SearchVH(View itemView) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.artist = itemView.findViewById(R.id.artist);
            this.image = itemView.findViewById(R.id.cover);
            this.duration = itemView.findViewById(R.id.duration);

        }
    }

}
