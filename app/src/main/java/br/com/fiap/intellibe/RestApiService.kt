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

    fun addForm(formData: Formulario, onResult: (Formulario?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addForm(formData).enqueue(
            object : Callback<Formulario> {
                override fun onFailure(call: Call<Formulario>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<Formulario>, response: Response<Formulario>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }

}