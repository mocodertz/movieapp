package com.jengasoft.movietheater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Objects;

/**
 * Created by MoCoder#1956# on 3/31/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter {
    private static final int MOVIE_COVER_VIEW_TYPE = 1;
    private static final int MOVIE_POSTER_VIEW_TYPE = 2;
    private Context mContext;
    private List<Movie> movieList;
    private String belongTo;

    public MovieAdapter(Context context, List<Movie> movieList, String belongTo) {
        mContext = context;
        this.movieList = movieList;
        this.belongTo = belongTo;
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Movie movie = movieList.get(position);

        if (Objects.equals(movie.getBelongTo().toLowerCase(), belongTo)) {

            return MOVIE_COVER_VIEW_TYPE;
        } else {

            return MOVIE_POSTER_VIEW_TYPE;
        }
    }

    // Inflates the appropriate layout according to the ViewType.

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        if (viewType == MOVIE_COVER_VIEW_TYPE) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.latest_movie_list_item_view, parent, false);
            return new MovieCover(view);
        } else if (viewType == MOVIE_POSTER_VIEW_TYPE) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.best_films_and_series_list_item_view, parent, false);
            return new MoviePoster(view);
        }
        return null;
    }

    // Passes the message object to a ViewHolder so that the contents can be bound to UI.
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);

        switch (holder.getItemViewType()) {
            case MOVIE_COVER_VIEW_TYPE:
                ((MovieCover) holder).bind(movie);
                break;
            case MOVIE_POSTER_VIEW_TYPE:
                ((MoviePoster) holder).bind(movie);
        }
    }

    private class MovieCover extends RecyclerView.ViewHolder {
        AppCompatTextView title;
        AppCompatImageView play;
        ProportionalImageView cover;

        MovieCover(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.movie_title);
            play = itemView.findViewById(R.id.play_movie_trailer);
            cover = itemView.findViewById(R.id.movie_cover);
        }

        void bind(Movie movie) {
            title.setText(movie.getTitle());
            Glide.with(mContext).load(movie.getCoverLink()).into(cover);
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    private class MoviePoster extends RecyclerView.ViewHolder {
        AppCompatTextView title, rating_count;
        ProportionalImageView poster;

        MoviePoster(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.movie_title);
            rating_count = itemView.findViewById(R.id.movie_rating_count);
            poster = itemView.findViewById(R.id.movie_poster);

        }

        void bind(Movie movie) {
            title.setText(movie.getTitle());
            rating_count.setText(movie.getRatingCount());
            Glide.with(mContext).load(movie.getPosterLink()).into(poster);
            poster.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
