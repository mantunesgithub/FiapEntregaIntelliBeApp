package br.com.fiap.intellibe

import com.google.gson.annotations.SerializedName
import java.time.LocalDate
import java.time.LocalTime


data class Formulario (
    @SerializedName("idFormulario") val  idFormulario: Long,
    @SerializedName("nomeFormulario")  val nomeFormulario : String,
    @SerializedName("descVaga")  val  descVaga : String,
    @SerializedName("dtInicioTeste")  val dtInicioTeste : String,
    @SerializedName("dtFinalTeste")  val dtFinalTeste : String,
    @SerializedName("formularioAtivo")  val formularioAtivo : String,
    @SerializedName("migracaoRespTeste")  val migracaoRespTeste : String,
    @SerializedName("hrTempoTeste")  val hrTempoTeste : String,
    @SerializedName("valorNotaMinima")  val valorNotaMinima : Double,
    @SerializedName("nomePublicoLink")  val nomePublicoLink : String,
    @SerializedName("qtQuestoesForm")  val qtQuestoesForm : Integer,
    @SerializedName("dtCriacaoForm")  val dtCriacaoForm : String)

