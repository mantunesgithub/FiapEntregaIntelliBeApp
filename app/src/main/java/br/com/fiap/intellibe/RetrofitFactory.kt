package br.com.fiap.intellibe

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    val URL: String = "http://192.168.0.12:8085/usuario/"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitService(): RetrofitService {
        return retrofitFactory.create(RetrofitService::class.java)
    }

    val URL2: String = "http://192.168.0.12:8085/form/"

    val retrofitFactory2 = Retrofit.Builder()
        .baseUrl(URL2)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun retrofitService2(): RetrofitService {
        return retrofitFactory2.create(RetrofitService::class.java)
    }

}