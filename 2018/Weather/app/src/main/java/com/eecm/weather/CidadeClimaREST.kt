package com.eecm.weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CidadeClimaREST {

    // Acessa esse endereço: api.openweathermap.org/data/2.5/weather?id=3402655&units=metric&APPID=SEU_APPID
    // Troque o "SEU_APPID" no endereço pelo seu APPID informado pelo site
    // Retorna o clima atual de uma cidade pelo ID da cidade
    // Mais informações: https://openweathermap.org/current#cityid

    @GET("weather")
    fun getClimaCidade(@Query("id") id: String,
                       @Query("APPID") appid:String,
                       @Query("units") units: String): Call<Cidade>

}