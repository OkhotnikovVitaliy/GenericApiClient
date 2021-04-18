package com.app.genericapiclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeApi {
    @GET("/random_ten")
    Call<List<Model>> getData();

}
