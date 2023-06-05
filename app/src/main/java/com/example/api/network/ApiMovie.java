package com.example.api.network;

import com.example.api.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiMovie {
   //Lista las peliculas
    @GET("movies/list.php")

    Call<List<Movie>> getMovies();
}
