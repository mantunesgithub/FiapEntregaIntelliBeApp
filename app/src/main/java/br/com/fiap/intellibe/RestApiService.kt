package br.com.fiap.intellibe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun addUser(userData: Usuario, onResult: (Usuario?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userData).enqueue(
            object : Callback<Usuario> {
                override fun onFailure(call: Call<Usuario>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Usuario>, response: Response<Usuario>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}