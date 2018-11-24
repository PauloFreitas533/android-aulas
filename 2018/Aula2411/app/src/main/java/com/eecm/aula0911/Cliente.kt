package com.eecm.aula0911

import java.io.Serializable

class Cliente(nome:String?, telefone:String?) : Serializable {

    var nome:String?
    var telefone:String?

    init{
        this.nome = nome
        this.telefone = telefone
    }


}
