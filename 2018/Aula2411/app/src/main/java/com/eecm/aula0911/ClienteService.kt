package com.eecm.aula0911

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClienteService {

    private val BASE_URL_CLIENTES = "http://174.138.37.22/wolneyhqf/unifavip/5MOGE/WS/"
    private var service: ClienteREST

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL_CLIENTES)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ClienteREST::class.java)
    }

    fun getClientesREST(): List<Cliente>{
        val call = service.getClientes()
        var clientes: List<Cliente> = call.execute().body()!!
        return clientes
    }


    fun getClientes(): List<Cliente>{
        val clientes = mutableListOf<Cliente>()
        for(i in 1..20){
            var cliente = Cliente("Cliente $i", "($i$i)$i$i$i$i$i-$i$i$i$i")
            clientes.add(cliente)
        }
        return clientes
    }



}