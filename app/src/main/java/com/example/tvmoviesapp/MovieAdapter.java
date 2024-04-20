package com.example.tvmoviesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import android.content.Context;
import android.content.Intent;




public class MovieAdapter extends FirebaseRecyclerAdapter<Movie, MovieAdapter.MovieViewHolder> {

    private final Context context;

    public MovieAdapter(@NonNull FirebaseRecyclerOptions<Movie> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull MovieViewHolder holder, int position, @NonNull Movie movie) {
        holder.titleView.setText(movie.getTitle());
        Glide.with(holder.itemView.getContext())
                .load(movie.getThumbnailUrl())
                .into(holder.thumbnailView);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, VideoPlayerActivity.class);
            intent.putExtra("VIDEO_URL", movie.getVideoUrl());
            context.startActivity(intent);
        });
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);
        return new MovieViewHolder(view);
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;
        ImageView thumbnailView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.movie_title);
            thumbnailView = itemView.findViewById(R.id.movie_thumbnail);
        }
    }
}
