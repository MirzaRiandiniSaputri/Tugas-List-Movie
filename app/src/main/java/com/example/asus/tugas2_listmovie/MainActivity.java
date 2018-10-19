package com.example.asus.tugas2_listmovie;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.asus.tugas2_listmovie.Input_movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<TampilMovie> TampilMovie = new ArrayList<TampilMovie>();
    private RecyclerView mRecyclerView;
    private com.example.asus.tugas2_listmovie.MovieAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getIntent().hasExtra("nama") && getIntent().hasExtra("rating") && getIntent().hasExtra("status")){
            /*System.out.println("Error 1");*/
            ArrayList<String> nama = getIntent().getStringArrayListExtra("nama");
            ArrayList<String> rating = getIntent().getStringArrayListExtra("rating");
            ArrayList<String> status = getIntent().getStringArrayListExtra("status");
            /*System.out.println("Error 2");*/
            for (int i = 0; i < nama.size(); i++) {
                Double temp;
                try {
                    temp = Double.parseDouble(rating.get(i));
                    if(temp > Double.parseDouble("10.0")){
                        temp = 10.0;
                    }
                    else if(temp < Double.parseDouble("0.0")){
                        temp = 0.0;
                    }
                } catch (Error e) {
                    temp = 0.0;
                }
                TampilMovie.add(new TampilMovie(nama.get(i), temp, status.get(i)));
            }
            /*System.out.println("Error 3");*/
        }
        else{
            TampilMovie.add(new TampilMovie("Small Foot", 5.0, "NOW PLAYING"));
            TampilMovie.add(new TampilMovie("Dancing in the Rain", 5.0, "COMINGSOON"));
            TampilMovie.add(new TampilMovie("Pengabdi Setan", 4.9, "NOW PLAYING"));
            TampilMovie.add(new TampilMovie("Danur", 4.0, "COMINGSOON"));
        }
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new MovieAdapter(this, TampilMovie);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Input_movie.class);
                ArrayList<String> nama = new ArrayList<String>();
                ArrayList<String> rating = new ArrayList<String>();
                ArrayList<String> status = new ArrayList<String>();
                for(int i = 0; i < TampilMovie.size(); i++){
                    nama.add(TampilMovie.get(i).judul);
                    rating.add(String.valueOf(TampilMovie.get(i).rate));
                    status.add(TampilMovie.get(i).status);
                }
                intent.putStringArrayListExtra("nama", nama);
                intent.putStringArrayListExtra("rating", rating);
                intent.putStringArrayListExtra("status", status);
                v.getContext().startActivity(intent);
            }
        });
    }
}
