package br.com.fiap.intellibe
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    //        http://localhost:8085/usuario/fiap@gmail.com/123456/json/

    @GET("{descricaoEmail}/{senha}")
    fun getUSUARIO (@Path("descricaoEmail") descricaoEmail: String,
                    @Path("senha") senha: String) : Call<Usuario>

    @GET("{cpfOuCnpj}")
    fun getFORMULARIO (@Path("cpfOuCnpj") cpfOuCnpj: String) : Call<List<Formulario>>

    @DELETE("{idFormulario}")
    fun deleteFORMULARIO (@Path("idFormulario") idFormulario: String) : Call<Unit>

}