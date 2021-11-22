package br.com.fiap.intellibe

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RestApi {
    @Headers("Content-Type: application/json")
    @POST("/usuario")
    fun addUser(@Body userData: Usuario): Call<Usuario>

    @Headers("Content-Type: application/json")
    @POST("/form")
    fun addForm(@Body formData: Formulario): Call<Formulario>
}