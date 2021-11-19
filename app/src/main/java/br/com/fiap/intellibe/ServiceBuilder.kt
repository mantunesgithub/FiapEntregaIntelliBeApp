package br.com.fiap.intellibe
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object ServiceBuilder {
    val URL: String = "http://192.168.0.12:8085/usuario/"
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL) // change this IP for testing by your actual machine IP
        .addConverterFactory(GsonConverterFactory.create())
       .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}
