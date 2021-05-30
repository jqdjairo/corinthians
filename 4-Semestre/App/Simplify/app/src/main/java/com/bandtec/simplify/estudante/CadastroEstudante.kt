package com.bandtec.simplify.estudante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.bandtec.simplify.R
import com.bandtec.simplify.conexaoApiEstudante.ConexaoEstudanteApi
import com.bandtec.simplify.conexaoApiEstudante.Estudante
import kotlinx.android.synthetic.main.activity_cadastro_estudante.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class CadastroEstudante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_estudante)
    }

    fun back(view: View) {}

    fun cadastroResponsavel(view: View){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Atenção")
        builder.setMessage("Você é menor de idade ?")
        builder.setPositiveButton("Sim"){dialog,wich ->
            showFormPais()
        }
        builder.setNegativeButton("Não"){dialog,wich ->
            cadastra()
        }

        val dialog : AlertDialog = builder.create()

        dialog.show()
    }


    fun showFormPais(){
        val form : LinearLayout = findViewById(R.id.formResponsavel)
        form.visibility = View.VISIBLE

        val btn: Button = findViewById(R.id.btnDialog)
        btn.visibility = View.GONE

        val btnCad: Button = findViewById(R.id.btnCadastro)
        btnCad.visibility = View.VISIBLE
    }

    fun initCadastro(view: View){
        val btnCad: Button = findViewById(R.id.btnCadastro)
        if(btnCad.visibility == View.VISIBLE){
            cadastra()
        }else{
            Toast.makeText(this, "Erro Interno do servidor, por favor contate um administrador", Toast.LENGTH_SHORT).show()
        }
    }

    fun cadastra() {

        val nome : EditText = findViewById(R.id.edtNomecad)

        val ra =  Random(10000000).toString()

        val email :EditText = findViewById(R.id.edtEmail)

        val endereco: EditText = findViewById(R.id.edtEndereco)

        val senha :EditText = findViewById(R.id.edtCadSenha)

        val cpf: EditText = findViewById(R.id.edtCPF)

        val rg : EditText = findViewById(R.id.edtRG)

        val nomeResponsavel: EditText = findViewById(R.id.edtNomeResponsavel)

        val emailResponsavel: EditText = findViewById(R.id.edtEmailResponsavel)

        val telefoneResponsavel: EditText = findViewById(R.id.edtTelefoneResponsavel)

        val dataNascimento = "123"

        val foto = "123"

        val telefone = "asa"


        val users = Estudante(
            null,
            nome.text.toString(),
            ra,
            email.text.toString(),
            senha.text.toString(),
            cpf.text.toString(),
            rg.text.toString(),
            nomeResponsavel.text.toString(),
            emailResponsavel.text.toString(),
            telefoneResponsavel.text.toString()
        )
        if(
            users.nome != "" ||
            users.email != "" ||
            users.senha !=""||
            users.cpf != ""||
            users.rg != "" ||
            !cadCheckBox.isChecked
        ) {
            ConexaoEstudanteApi.criar().cadastro(users).enqueue(object :
                Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    val statusCode = response.code()
                    if (statusCode.equals(201)) {
                        Toast.makeText(
                            this@CadastroEstudante,
                            "Cadatro feito com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(this@CadastroEstudante,LoginEstudante::class.java))
                    } else {
                        Toast.makeText(
                            this@CadastroEstudante,
                            "Erro Ao cadastrar, tente novamente, se o problema persistir, contate o administrador",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    val builder =AlertDialog.Builder(this@CadastroEstudante)
                    builder.setTitle("Erro Interno :(")
                    builder.setMessage(t.message)
                    builder.setNeutralButton("Voltar"){_,_-> }
                    val dialog : AlertDialog = builder.create()
                    dialog.show()
                }
            })
        }
        else{
            val builder =AlertDialog.Builder(this)
            builder.setTitle("Atenção")
            builder.setMessage("Campos Obrigatórios não informados.")
            builder.setNeutralButton("Voltar"){_,_-> }
            val dialog : AlertDialog = builder.create()
            dialog.show()
        }
    }
}