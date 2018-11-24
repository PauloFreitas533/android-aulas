package com.eecm.weather

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CidadeClimaService {

    val BASE_URL = "http://api.openweathermap.org/data/2.5/"
    val service: CidadeClimaREST

    init{
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(CidadeClimaREST::class.java)
    }

    fun getClimaCidade(): Cidade?{
        var call = service.getClimaCidade("3402655",
            "SEU APPID FORNECIDO PELO SITE",
            "metric")
        var cidade = call.execute().body()
        return cidade
    }

}