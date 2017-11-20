package com.wolneyhqf.aulas.wsretrofit.service;

import com.wolneyhqf.aulas.wsretrofit.model.Seriado;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by wolney on 15/11/17.
 */

public interface SeriadoService {

    @GET("api/v1/seriados")
    public Call<List<Seriado>> listar();

    @POST("api/v1/seriados")
    public Call<Seriado> salvar(@Body Seriado seriado);

}
