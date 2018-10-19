package com.example.asus.tugas2_listmovie;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.WordViewHolder> {
    private final ArrayList<TampilMovie> movieList;
    private LayoutInflater mInflater;
    public MovieAdapter(Context context, ArrayList<TampilMovie> wordList) {
        mInflater = LayoutInflater.from(context);
        this.movieList = wordList;
    }
   
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.activity_word_list_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }
    public void onBindViewHolder(@NonNull MovieAdapter.WordViewHolder holder, int position) {
        TampilMovie mCurrent = movieList.get(position);
        holder.movieView.setText(mCurrent.judul);
        holder.movieRate.setText(String.valueOf(mCurrent.rate));
        holder.movieStatus.setText(mCurrent.status);
    }
    public int getItemCount() {
        return movieList.size();
    }
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView movieView;
        final MovieAdapter mAdapter;
        public final TextView movieRate;
        public final TextView movieStatus;

        public WordViewHolder(View itemView, MovieAdapter adapter) {
            super(itemView);
            movieView = itemView.findViewById(R.id.word);
            movieRate = itemView.findViewById(R.id.rating);
            movieStatus = itemView.findViewById(R.id.status);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in movieList.
           TampilMovie element = movieList.get(mPosition);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}
