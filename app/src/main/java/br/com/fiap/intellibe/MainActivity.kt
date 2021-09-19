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

class MainActivity : AppCompatActivity() {
    var usuario : String = ""
    var cnpj    : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView1: ImageView = findViewById(R.id.imageView1)
        val i1 =
        "https://play-lh.googleusercontent.com/Qf_DfctF26j2yXlqoKxJeSP1rUdzJVIrd_Jq_wrZMnl4hQlkJ5PDO5RCM_MIXMY-AkQ=s180-rw"
        Glide.with(this).load(i1).into(imageView1)

        val login: EditText = findViewById(R.id.edt_email)
        val senha: EditText = findViewById(R.id.edt_senha)
        val buttonLogin: Button = findViewById(R.id.btn_login)
        var msg: TextView = findViewById(R.id.txt_msg)


        //-- Ao clicar no botão Login
        //-- Chamar o backend passando login e senha para validação da senha
        //-------------------------------------------------------------------
        buttonLogin.setOnClickListener {
            msg.text = " "

            println("==> Login = " + login.text.toString() + " senha = " + senha.text.toString())

            val call = RetrofitFactory().retrofitService().getUSUARIO(
                login.text.toString(), senha.text.toString())

            call.enqueue(object : Callback<Usuario> {

                override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {

                    response.body()?.let {
                        Log.i("Usuario", it.toString())
//                        Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_LONG)
//                            .show()
                        usuario = it.descricaoEmail
                        cnpj = it.cnpjOuCpf.toString()
                        enviarDashBoard()

//                                progressBar.visibility = View.INVISIBLE
                    } ?: Toast.makeText(
                        this@MainActivity,"Usuario não localizado ",
                        Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<Usuario>?, t: Throwable?) {
                    t?.message?.let { it -> Log.e("Erro", it)
                    }
                    msg.text = login.text.toString() + " Não Efetuou LOGIN !!"
                    if (t != null) {
                        Toast.makeText(applicationContext,"Erro : +"+t.message,Toast.LENGTH_LONG)
                            .show()
                    }
        //            progressBar.visibility = View.INVISIBLE
                }
            })

        }
    }

    private fun enviarDashBoard() {

        val i = Intent(this, EnviarDashBoard::class.java)
        i.putExtra("chaveUsuario", usuario)
        i.putExtra("chaveCnpj", cnpj)
        startActivity(i)
        finish()
    }
}

