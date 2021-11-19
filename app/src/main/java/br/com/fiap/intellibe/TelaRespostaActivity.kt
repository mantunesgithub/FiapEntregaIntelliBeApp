package br.com.fiap.intellibe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.ImageView

class TelaRespostaActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resposta)
        val image: ImageView = findViewById(R.id.image)

        image.setImageBitmap(Biblioteca.decoder())
    }

    fun retornar(view: View) {

        val intent = Intent(this, EnviarDashBoard::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}