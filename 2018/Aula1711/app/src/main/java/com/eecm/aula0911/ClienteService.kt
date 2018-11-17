package com.eecm.aula0911

class ClienteService {

    companion object {
        fun getClientes(): List<Cliente>{
            val clientes = mutableListOf<Cliente>()
            for(i in 1..20){
                var cliente = Cliente("Cliente $i", "cliente$i@email.com", null, null, null)
                clientes.add(cliente)
            }
            return clientes
        }
    }

}