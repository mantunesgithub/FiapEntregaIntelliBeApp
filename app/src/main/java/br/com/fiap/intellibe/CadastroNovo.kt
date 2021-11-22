package br.com.fiap.intellibe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CadastroNovo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_novo)

        var tipopesUsu: EditText = findViewById(R.id.edt_pj_pf)
        var nomeUsu: EditText = findViewById(R.id.edt_nome_cad)
        var cnpjOuCpfUsu: EditText = findViewById(R.id.edt_cnpj_cpf_cad)
        var emailUsu: EditText = findViewById(R.id.edt_email_cad)
        var senhalUsu: EditText = findViewById(R.id.edt_senha_cad)
        val btnCadastrarUsu: Button = findViewById(R.id.btn_cadastrar_usuario)

        // Cadastrar Usuário

    btnCadastrarUsu.setOnClickListener {

        var tipoPess = tipopesUsu.text.toString()
        var nome = nomeUsu.text.toString()
        var valueCnpjCpf: String = cnpjOuCpfUsu.getText().toString()
        var finalCnpjCpf = valueCnpjCpf.toLong()
        var email = emailUsu.text.toString()
        var senhalUsu = senhalUsu.text.toString()

        println("==> Cadastro = Tipo= " + tipoPess + " cnpj = " + finalCnpjCpf + " email = " + email
                    + " senha " + senhalUsu )
        val apiService = RestApiService()
        val usuario = Usuario(
            idUsuario = null,
            tipoUsuario = tipoPess,
            cnpjOuCpf = finalCnpjCpf,
            nomeUsuario = nome,
            descricaoEmail = email,
            senha = senhalUsu )
        println("==> Cadastro = Tipo= " + usuario.tipoUsuario + " cnpj = " + usuario.cnpjOuCpf +
                " nome " + usuario.nomeUsuario +
                " email = " + usuario.descricaoEmail  + " senha " + usuario.senha + " id " + usuario.idUsuario )

        apiService.addUser(usuario) {
        if (it?.idUsuario == null) {
            Toast.makeText(
                this@CadastroNovo, "Usuario Cadastrado com Sucesso !",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                this@CadastroNovo, "Atenção Usuario Não Cadastrado !",
                Toast.LENGTH_LONG
            ).show()
            }
        }
    }
  }
}