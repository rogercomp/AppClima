package com.example.roger.restwebservice.service;


import com.example.roger.restwebservice.model.Clima;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ClimaService {

    @GET("forecast/8eeafa93fa171bb970bfac9b03caa3a3/{latitude},{longitude}?exclude=minutely,hourly,daily,flags,alerts")
    Call<Clima> consulta(@Path("latitude") double latitude,
                              @Path("longitude") double longitude);

}
