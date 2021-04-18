package com.app.genericapiclient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class App {

    static final String BASE_URL = "https://official-joke-api.appspot.com";

    public static JokeApi getApi() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        JokeApi jokeApi = retrofit.create(JokeApi.class);
        return jokeApi;

    }
}
