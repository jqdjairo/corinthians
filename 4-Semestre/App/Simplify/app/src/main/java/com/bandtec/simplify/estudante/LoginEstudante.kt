package com.bandtec.simplify.estudante

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.bandtec.simplify.R
import com.bandtec.simplify.conexaoApiEstudante.ConexaoEstudanteApi
import com.bandtec.simplify.conexaoApiEstudante.Estudante
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginEstudante : AppCompatActivity() {

    lateinit var preferencias: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_estudante)
        val btnHome = findViewById<Button>(R.id.btnHome)
//
        preferencias = getSharedPreferences("autenticacao", MODE_PRIVATE)
//
//        val usuarioLogado = preferencias.getString("usuario",null);
//
//        if(usuarioLogado != null){
//            val tela2 = Intent(this@LoginEstudante, HomeEstudante::class.java)
//            startActivity(tela2)
//        }
    }

    fun back(view: View) {
        onBackPressed()
    }

    fun login(view:View){
        val etLogin: EditText = findViewById(R.id.edtLoginEstudante)
        val etSenha: EditText = findViewById(R.id.edtSenhaEstudante)
        val dadosEmail : String = etLogin.text.toString()
        val dadosSenha: String = etSenha.text.toString()

        startActivity(Intent(this@LoginEstudante, HomeEstudante::class.java))

        if(dadosEmail != "" && dadosSenha != "") {
            ConexaoEstudanteApi.criar().login(dadosEmail, dadosSenha)
                .enqueue(object : Callback<List<Estudante>> {
                    override fun onResponse(
                        call: Call<List<Estudante>>,
                        response: Response<List<Estudante>>
                    ) {
                        val estudanteResponse = response.body()
                        val statusCode = response.code()
                        if (statusCode.equals(200)) {
                            val edit = preferencias.edit()
                            println(estudanteResponse)
                      edit.putString("usuario", dadosEmail)
                         edit.putBoolean("isProfessor", false)
                            edit.commit()

                            startActivity(Intent(this@LoginEstudante, HomeEstudante::class.java))
                        } else if (statusCode.equals(204)) {
                            Toast.makeText(this@LoginEstudante, "Email ou Senha Incorretos.", Toast.LENGTH_SHORT).show()
                        } else if (statusCode.equals(404)) {
                            startActivity(Intent(this@LoginEstudante, HomeEstudante::class.java))
                        }
                        else {
                            Toast.makeText(this@LoginEstudante, "Ops... sistema temporariamente \n " +
                                    "indisponível tente novamente mais tarde.", Toast.LENGTH_SHORT).show()
                        }

                    }

                    override fun onFailure(call: Call<List<Estudante>>, t: Throwable) {
                        Toast.makeText(this@LoginEstudante,
                            "Ops... sistema temporariamente \n " +
                                    "indisponível tente novamente mais tarde \n ErrorMessage: ${t.message}", Toast.LENGTH_SHORT).show()
                        println("Mensagem Erro:" + t.message)
                    }
                })
        }else{
            Toast.makeText(this, "Preencha todos os campos corretamente", Toast.LENGTH_SHORT).show()
        }
    }

//        if(etLogin.text.toString() != "" && etSenha.text.toString() !=""){
//        if(etLogin.text.toString() == "admin" && etSenha.text.toString() == "admin"){
//            val edit = preferencias.edit()
//
//            edit.putString("usuario", etLogin.toString())
//            edit.putBoolean("isProfessor", false)
//            edit.commit()
//
//            val tela2 = Intent(this@LoginEstudante, HomeEstudante::class.java)
//            startActivity(tela2)
//        }else{
//            Toast.makeText(this, "Falha na autenticação, Tente novamente", Toast.LENGTH_SHORT).show()
//        }
//        }else{
//            Toast.makeText(this, "Por favor,Preencha todos os campos", Toast.LENGTH_SHORT).show()
//        }


    fun initCadastro(view: View) {
        startActivity(Intent(this@LoginEstudante, CadastroEstudante::class.java))
    }

}