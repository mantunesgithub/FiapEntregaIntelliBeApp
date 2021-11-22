package br.com.fiap.intellibe
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat

const val CHANNEL_ID = "notification"

class EnviarDashBoard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        createNotificationChannel()

//        var imageView: ImageView = findViewById(R.id.imageView1)
//
//        val i1 =
//        "https://play-lh.googleusercontent.com/Qf_DfctF26j2yXlqoKxJeSP1rUdzJVIrd_Jq_wrZMnl4hQlkJ5PDO5RCM_MIXMY-AkQ=s180-rw"
//        Glide.with(this).load(i1).into(imageView)

        var cnpj : TextView = findViewById(R.id.txv_cnpj)
        var usuario: TextView = findViewById(R.id.txv_usuario)
        var totalTesteRealiz: TextView = findViewById(R.id.txv_total_teste_realiz)

        val btnListarformulario: Button = findViewById(R.id.btn_listar_form)
        val btnCadastrarformulario: Button = findViewById(R.id.btn_cadastrar_form)
        val btnExcluirformulario: Button = findViewById(R.id.btn_excluir_form)

        usuario.text = getIntent().getStringExtra("chaveUsuario")
        cnpj.text =  getIntent().getStringExtra("chaveCnpj")

        // Listar formulario
        btnListarformulario.setOnClickListener {
            enviarListaFormulario()
        }
        // Cadastrar formulario
        btnCadastrarformulario.setOnClickListener {
            cadastrarFormulario()
        }
        // Excluir formulario
        btnListarformulario.setOnClickListener {
            excluirFormulario()
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

    private fun enviarListaFormulario() {
        var cnpjDoUsuario : TextView = findViewById(R.id.txv_cnpj)
        var nomeUsuario: TextView = findViewById(R.id.txv_usuario)

        val i = Intent(this, EnviarListaFormulario::class.java)
        i.putExtra("chvCnpjDoUsuario",  cnpjDoUsuario.text.toString())
        i.putExtra("chvNomeUsuario", nomeUsuario.text.toString())
        startActivity(i)
        finish()
    }
    private fun cadastrarFormulario() {
        var cnpjDoUsuario : TextView = findViewById(R.id.txv_cnpj)
        var nomeUsuario: TextView = findViewById(R.id.txv_usuario)

        val i = Intent(this, CadastrarFormulario::class.java)
        i.putExtra("chvCnpjDoUsuario",  cnpjDoUsuario.text.toString())
        i.putExtra("chvNomeUsuario", nomeUsuario.text.toString())
        startActivity(i)
        finish()
    }
    private fun excluirFormulario() {
        var cnpjDoUsuario : TextView = findViewById(R.id.txv_cnpj)
        var nomeUsuario: TextView = findViewById(R.id.txv_usuario)

        val i = Intent(this, EnviarListaFormulario::class.java)
        i.putExtra("chvCnpjDoUsuario",  cnpjDoUsuario.text.toString())
        i.putExtra("chvNomeUsuario", nomeUsuario.text.toString())
        startActivity(i)
        finish()
    }

    fun createNotificationChannel(){
        // Create Notification Channel , but only api 26+ because
        // the notificationChannel class is new and not in the support library

        if (Build.VERSION.SDK_INT >=  Build.VERSION_CODES.ECLAIR_0_1) {
            val name = getString(R.string.chennel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT

            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Register channel with system

            val notificationManager : NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }
    }
    fun gerarNotificacao(view: View?) {

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val p = PendingIntent.getActivity(this, 0,
                Intent(this, TelaRespostaActivity::class.java), 0)

            var mensagens = arrayOf("Reunião com equipe de Formulários ",
                "Desenvolvimeto Formulario novo em Grupo",
                "Apresentação do Formulário Novo")

            val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            builder.setContentTitle(mensagens[(Math.random()*mensagens.size).toInt()])
            builder.setSmallIcon(R.drawable.ponteiro)
            builder.setLargeIcon(Biblioteca.decoder())
            builder.priority = NotificationCompat.PRIORITY_DEFAULT
            builder.setContentIntent(p)

            val style = NotificationCompat.InboxStyle()

            val unidades = arrayOf(
                arrayOf("Presencial","Sede IntelliBe","Rua das Orquídeas, 186","Jardim das Flores","SBC"),
                arrayOf("Home","Remot","Via GoogleMeet"),
                arrayOf("Presencial","Campus Paulista","Av. Paulista, 1106","CEP: 01311-000")
            )

            var random = (Math.random()*unidades.size).toInt()
            var unidade = unidades[random]
            for (detalhe in unidade) {
                style.addLine(detalhe)
            }
            builder.setStyle(style)

            val notificacao = builder.build()
            notificacao.flags = Notification.FLAG_AUTO_CANCEL

            notificationManager.notify(R.drawable.ic_launcher_background,notificacao)

            try {

                val som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val toque = RingtoneManager.getRingtone(this, som)
                toque.play()

            } catch (e: Exception) {

                Log.i("ErrorSom", e.message.toString())
            }
    }
}

