package com.example.tvmoviesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.GridLayoutManager;


public class MoviesActivity extends AppCompatActivity {

    private RecyclerView movieList;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        movieList = findViewById(R.id.movie_list);
        movieList.setLayoutManager(new GridLayoutManager(this, 3));

        setUpFirebase();
    }

    private void setUpFirebase() {
        Query query = FirebaseDatabase.getInstance().getReference("movies");

        FirebaseRecyclerOptions<Movie> options =
                new FirebaseRecyclerOptions.Builder<Movie>()
                        .setQuery(query, Movie.class)
                        .build();

        adapter = new MovieAdapter(options, this);
        movieList.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
