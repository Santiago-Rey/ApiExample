package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.api.adapter.MovieAdapter;
import com.example.api.model.Movie;
import com.example.api.network.ApiClient;
import com.example.api.network.ApiMovie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies;
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_movies);
        //Como quiero que se muestre
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        showMovies();


    }

    public void showMovies(){
        Call<List<Movie>> call = ApiClient.getclient().create(ApiMovie.class).getMovies();
        call.enqueue(new Callback<List<Movie>>(){

            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                //Permite pasar la el json al objeto y poder visualizarlo con el adapter
                if(response.isSuccessful()){
                    movies= response.body();
                    movieAdapter=new MovieAdapter(movies, getApplicationContext());
                    recyclerView.setAdapter(movieAdapter);

                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();

            }
        });

    }
}