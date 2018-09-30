package com.jengasoft.movietheater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by MoCoder#1956# on 4/1/2018.
 */

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.ViewHolder> {
    private List<Cinema> cinemaList;
    private Context mContext;


    public CinemaAdapter(Context mContext, List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public CinemaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CinemaAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_theater_list_item_view, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CinemaAdapter.ViewHolder holder, int position) {
        final Cinema cinema = cinemaList.get(position);

        holder.cinemaName.setText(cinema.getName());

        Glide.with(mContext).load(cinema.getPhoto()).into(holder.cinemaPhoto);

    }

    @Override
    public int getItemCount() {
        return cinemaList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView cinemaName;
        ProportionalImageView cinemaPhoto;

        ViewHolder(View itemView) {
            super(itemView);
            cinemaName = itemView.findViewById(R.id.name);
            cinemaPhoto = itemView.findViewById(R.id.photo);

        }
    }
}
