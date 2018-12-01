package com.example.roger.restwebservice.retrofit;

import com.example.roger.restwebservice.service.ClimaService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private  Retrofit retrofit;

    public RetrofitConfig() {
        // aqui vem a configuração

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.darksky.net/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public ClimaService getClimaService() {
        return this.retrofit.create(ClimaService.class);
    }
}
