package com.eecm.aula0911

import retrofit2.Call
import retrofit2.http.GET

interface ClienteREST {

    @GET("contatos/")
    fun getClientes(): Call<List<Cliente>>

}

