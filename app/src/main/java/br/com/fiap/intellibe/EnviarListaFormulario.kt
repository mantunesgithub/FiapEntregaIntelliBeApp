package br.com.fiap.intellibe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import br.com.fiap.intellibe.activity.RecyclerViewFormulario
import br.com.fiap.intellibe.model.CarregarListaFormulario
import br.com.fiap.intellibe.model.FormularioLista
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnviarListaFormulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_lista_formulario)

        val usuario = getIntent().getStringExtra("chvNomeUsuario")
        val cnpj = getIntent().getStringExtra("chvCnpjDoUsuario")

        val call = RetrofitFactory().retrofitService2().getFORMULARIO(
            cnpj.toString())

        call.enqueue(object : Callback<List<Formulario>> {

            override fun onResponse(call: Call<List<Formulario>>, response: Response<List<Formulario>>) {

                response.body()?.let {
                    Log.i("Formulario", it.toString())
//                    Toast.makeText(this@EnviarListaFormulario, it.toString(), Toast.LENGTH_LONG)
//                        .show()

                    val cargaForm  = CarregarListaFormulario()

                    for (index in 0 until it.size) {

                        val formularioLista = FormularioLista()
                        formularioLista.idFormulario = it[index].idFormulario
                        formularioLista.nomeFormulario = it[index].nomeFormulario
                        formularioLista.descVaga = it[index].descVaga
                        formularioLista.valorNotaMinima = it[index].valorNotaMinima
                        formularioLista.dtInicioTeste = it[index].dtInicioTeste
                        formularioLista.dtFinalTeste = it[index].dtFinalTeste

                        cargaForm.cargaFormularioLista(formularioLista)

                    }
                    guardarRecyclerViewFormulario(cargaForm.formulariosListas)


                } ?: Toast.makeText(
                    this@EnviarListaFormulario,"Formulario não localizado EnviarLista",
                    Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<List<Formulario>>, t: Throwable) {
                t?.message?.let { it -> Log.e("Erro", it)
                }
                if (t != null) {
                    Toast.makeText(applicationContext,"Erro : +"+t.message, Toast.LENGTH_LONG)
                        .show()
                }
                //            progressBar.visibility = View.INVISIBLE
            }
        })
    }
    private fun guardarRecyclerViewFormulario( formulariosListas :ArrayList<FormularioLista>?) {

        val i = Intent(this, RecyclerViewFormulario::class.java)
        i.putExtra("LIST", formulariosListas as java.io.Serializable)
        startActivity(i)

    }

}
