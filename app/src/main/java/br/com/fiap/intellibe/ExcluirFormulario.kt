package br.com.fiap.intellibe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExcluirFormulario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_excluir_formulario)

        val idFormulario: EditText = findViewById(R.id.edt_id_form)
        val valueIdform = idFormulario.getText()

        val buttonExcluir: Button = findViewById(R.id.btn_excluir_form)

    //-- Ao clicar no botão Excluir
    //-- Chamar o backend passando id do formulario para exclusão
    //-----------------------------------------------------------
    buttonExcluir.setOnClickListener {

        val call = RetrofitFactory().retrofitService2().deleteFORMULARIO(valueIdform.toString())
        call.enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                println("=========Deletou ")
                if (response.isSuccessful) {
                    println("=========Deletou suceess")
                    Toast.makeText(
                        this@ExcluirFormulario, " Excluido com Sucesso! ",
                        Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this@ExcluirFormulario, "Formulario não localizado ",
                        Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<Unit>?, t: Throwable?) {
                    Toast.makeText(applicationContext,"Erro no delete formulario! ", Toast.LENGTH_LONG)
                        .show()
            }
        })
    }
  }

}