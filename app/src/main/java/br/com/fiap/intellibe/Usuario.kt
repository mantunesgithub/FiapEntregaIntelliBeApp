package br.com.fiap.intellibe

import com.google.gson.annotations.SerializedName

data class Usuario(

    @SerializedName("idUsuario")        val idUsuario: Long?,
    @SerializedName("tipoUsuario")      val tipoUsuario: String,
    @SerializedName("cnpjOuCpf")        val cnpjOuCpf: Long ,
    @SerializedName("nomeUsuario")      val nomeUsuario: String ,
    @SerializedName("descricaoEmail")   val descricaoEmail: String ,
    @SerializedName("senha")            val senha: String

)