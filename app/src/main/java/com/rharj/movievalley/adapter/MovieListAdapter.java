package com.rharj.movievalley.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rharj.movievalley.R;
import com.rharj.movievalley.model.MovieListModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    List<MovieListModel> movieListModelList;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView movie_image;
        public TextView movie_title,movie_category,movie_rating,movie_3d,movie_2d,movie_language
                ,movie_details,movie_time,movie_release_date;
        public MyViewHolder(View view) {
            super(view);

            movie_image = (ImageView) view.findViewById(R.id.movie_image);
            movie_title = (TextView) view.findViewById(R.id.movie_title);
            movie_category = (TextView) view.findViewById(R.id.movie_category);
            movie_rating = (TextView) view.findViewById(R.id.movie_rating);
            movie_3d = (TextView) view.findViewById(R.id.movie_3d);
            movie_2d = (TextView) view.findViewById(R.id.movie_2d);
            movie_language = (TextView) view.findViewById(R.id.movie_language);
            movie_details = (TextView) view.findViewById(R.id.movie_details);
            movie_time = (TextView) view.findViewById(R.id.movie_time);
            movie_release_date = (TextView) view.findViewById(R.id.movie_release_date);
        }
    }

    public MovieListAdapter(List<MovieListModel> responseList, Context context) {
        this.movieListModelList = responseList;
        this.context = context;
    }

    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_now_showing_movie_item, parent, false);

        return new MovieListAdapter.MyViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return movieListModelList.size();
    }

    @Override
    public void onBindViewHolder(MovieListAdapter.MyViewHolder holder, int position) {
        final MovieListModel movieListModel = movieListModelList.get(position);
        holder.movie_title.setText(movieListModel.getTitle());
        holder.movie_release_date.setText(movieListModel.getReleaseDate());
        holder.movie_time.setText(movieListModel.getDuration());
        holder.movie_details.setText(movieListModel.getDetails());
        holder.movie_rating.setText(movieListModel.getRating());
        holder.movie_category.setText(movieListModel.getCategory());
        holder.movie_language.setText(movieListModel.getLanguage());
        Glide.with(context).load(movieListModel.getImageUrl()).into(holder.movie_image);
    }
}
