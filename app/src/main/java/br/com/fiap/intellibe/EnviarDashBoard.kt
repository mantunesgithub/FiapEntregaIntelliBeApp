package br.com.fiap.intellibe
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EnviarDashBoard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

//        var imageView: ImageView = findViewById(R.id.imageView1)
//
//        val i1 =
//        "https://play-lh.googleusercontent.com/Qf_DfctF26j2yXlqoKxJeSP1rUdzJVIrd_Jq_wrZMnl4hQlkJ5PDO5RCM_MIXMY-AkQ=s180-rw"
//        Glide.with(this).load(i1).into(imageView)

        var cnpj : TextView = findViewById(R.id.txv_cnpj)
        var usuario: TextView = findViewById(R.id.txv_usuario)
        var totalTesteRealiz: TextView = findViewById(R.id.txv_total_teste_realiz)

        val btn_formulario: Button = findViewById(R.id.btn_formulario)

        usuario.text = getIntent().getStringExtra("chaveUsuario")
        cnpj.text =  getIntent().getStringExtra("chaveCnpj")

        // Chamar formulario

        btn_formulario.setOnClickListener {
            EnviarListaFormulario()
        }

        val call = RetrofitFactory().retrofitService2().getFORMULARIO(
            cnpj.text.toString())

        call.enqueue(object : Callback<List<Formulario>> {

            override fun onResponse(call: Call<List<Formulario>>, response: Response<List<Formulario>>) {

                response.body()?.let {
                    Log.i("Formulario", it.toString())
//                    Toast.makeText(this@EnviarDashBoard, it.toString(), Toast.LENGTH_LONG)
//                        .show()

                    totalTesteRealiz.text = "Qtde Formulários de Teste: " + it.size.toString()
//                                progressBar.visibility = View.INVISIBLE
                } ?: Toast.makeText(
                    this@EnviarDashBoard,"Formulario não localizado EnviarDash ",
                    Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<List<Formulario>>, t: Throwable) {
                t?.message?.let { it -> Log.e("Erro", it)
                }
                if (t != null) {
                    Toast.makeText(applicationContext,"Erro : +"+t.message,Toast.LENGTH_LONG)
                        .show()
                }
                //            progressBar.visibility = View.INVISIBLE
            }
        })
    }

    private fun EnviarListaFormulario() {
        var cnpjDoUsuario : TextView = findViewById(R.id.txv_cnpj)
        var nomeUsuario: TextView = findViewById(R.id.txv_usuario)

        val i = Intent(this, EnviarListaFormulario::class.java)
        i.putExtra("chvCnpjDoUsuario",  cnpjDoUsuario.text.toString())
        i.putExtra("chvNomeUsuario", nomeUsuario.text.toString())
        startActivity(i)
        finish()
    }
}
