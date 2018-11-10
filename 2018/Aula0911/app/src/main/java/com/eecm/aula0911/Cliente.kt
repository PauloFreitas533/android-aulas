package com.eecm.aula0911

import java.io.Serializable

class Cliente(nome:String?,
              email:String?,
              sexo:Char?,
              receberEmail:Boolean?,
              observacao:String?) : Serializable {

    var nome:String?
    var email:String?
    var sexo:Char?
    var receberEmail:Boolean?
    var observacao:String?

    init{
        this.nome = nome
        this.email = email
        this.sexo = sexo
        this.receberEmail = receberEmail
        this.observacao = observacao
    }


}