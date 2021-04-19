package com.app.genericapiclient;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Controller {

    private static JokeApi jokeApi;
    MainActivity view;
    private List<JokeModel> posts = new ArrayList<>();

    public Controller(MainActivity view) {
        this.view = view;
    }


    public void initData() {

        jokeApi = App.getApi();
        jokeApi.getData().enqueue(new Callback<List<JokeModel>>() {
            @Override
            public void onResponse(Call<List<JokeModel>> call, Response<List<JokeModel>> response) {
                posts.addAll(response.body());
                view.recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<JokeModel>> call, Throwable t) {
                Toast.makeText(view, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });
        view.btnAddComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posts.clear();
                jokeApi.getData().enqueue(new Callback<List<JokeModel>>() {
                    @Override
                    public void onResponse(Call<List<JokeModel>> call, Response<List<JokeModel>> response) {
                        posts.addAll(response.body());
                        view.recyclerView.getAdapter().notifyDataSetChanged();
                        view.recyclerView.smoothScrollToPosition(0);
                    }

                    @Override
                    public void onFailure(Call<List<JokeModel>> call, Throwable t) {
                        Toast.makeText(view, "An error occurred during networking", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        view.showRecyclerList();
    }

    public List<JokeModel> getMyJoke() {
        return posts;
    }
}
