package br.com.fiap.intellibe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class CadastrarFormulario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_formulario)

        var nomeForm: EditText = findViewById(R.id.edt_nome_form)
        var descrVagaForm: EditText = findViewById(R.id.edt_descr_vaga_form)
        var vlNotaMinForm: EditText = findViewById(R.id.edt_vlnota_min_form)
        var dtInicioTesteForm: EditText = findViewById(R.id.edt_dtinicio_test_form)
        var dtFinalTesteForm: EditText = findViewById(R.id.edt_dtfinal_test_form)
        val btnCadastrarForm: Button = findViewById(R.id.btn_cadastrar_form)


        // Cadastrar Formulário

        btnCadastrarForm.setOnClickListener {
            val nomeFormString: String = nomeForm.getText().toString()
            val descrVagaString: String = descrVagaForm.getText().toString()
            val vlNotaMinString: String = vlNotaMinForm.getText().toString()
            val dtInicioTesteString: String = dtInicioTesteForm.getText().toString()
            val dtFinalTesteString: String = dtFinalTesteForm.getText().toString()

            var erroValida: String = ""
            //Validar se os campos foram preenchidos
            if (nomeFormString.isEmpty()) {
                erroValida = "E"
                Toast.makeText(this@CadastrarFormulario, "Preencha nome do formulário!",
                Toast.LENGTH_SHORT).show()
            } else {
                if (descrVagaString.isEmpty()) {
                    erroValida = "E"
                    Toast.makeText(this@CadastrarFormulario, "Preencha descrição da vaga!",
                    Toast.LENGTH_SHORT).show()
                } else {
                    if (vlNotaMinString.isEmpty()) {
                        erroValida = "E"
                        Toast.makeText(this@CadastrarFormulario, "Preencha valor da nota mínima!",
                        Toast.LENGTH_SHORT).show()
                    } else {
                        if (dtInicioTesteString.isEmpty()) {
                            erroValida = "E"
                            Toast.makeText(
                                this@CadastrarFormulario, "Preencha data inicio!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            if (dtFinalTesteString.isEmpty()) {
                                erroValida = "E"
                                Toast.makeText(
                                    this@CadastrarFormulario, "Preencha data final!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }
            val c1 = Cliente(
                65039846000180L,
                "PJ",
                "Consultoria Estefani Ltda",
                "estefani@gmail.com",
                "Rua Bragança,92",
                "torre 1 apto 128",
                "Jd Abril",
                "SBCampo",
                "SP",
                "Brasil",
                "065000123",
                "(011)2323-7899"
            )
            if (erroValida != "E") {


                var valueNotaMinima = vlNotaMinForm.getText().toString()
                var finalNotaMinima: Double = valueNotaMinima.toDouble()

                val apiService = RestApiService()
                val formulario = Formulario(
                    idFormulario = 0L,
                    nomeFormulario = nomeForm.text.toString(),
                    descVaga = descrVagaForm.text.toString(),
                    dtInicioTeste = dtInicioTesteForm.text.toString(),
                    dtFinalTeste = dtFinalTesteForm.text.toString(),
                    formularioAtivo = "s",
                    migracaoRespTeste = "s",
                    hrTempoTeste = "10:00:00",
                    valorNotaMinima = finalNotaMinima,
                    nomePublicoLink = " ",
                    qtQuestoesForm = 10,
                    dtCriacaoForm = ("2021-11-11")
                )

                apiService.addForm(formulario) {
                    if (it?.idFormulario != null) {
                        Toast.makeText(
                            this@CadastrarFormulario, "Formulario Cadastrado com Sucesso !",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        Toast.makeText(
                            this@CadastrarFormulario, "Atenção Formulario Não Cadastrado !",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}
