package br.com.fiap.intellibe

import retrofit2.Call
import retrofit2.http.*

interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("/usuario")
    fun addUser(@Body userData: Usuario): Call<Usuario>

    @Headers("Content-Type: application/json")
    @POST("/form")
    fun addForm(@Body formData: Formulario): Call<Formulario>

}