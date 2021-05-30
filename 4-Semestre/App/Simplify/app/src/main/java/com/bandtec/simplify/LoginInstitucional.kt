package com.bandtec.simplify

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.bandtec.simplify.conexaoApiFaculdade.ConexaoApiFaculdade
import com.bandtec.simplify.conexaoApiFaculdade.Faculdade
import com.bandtec.simplify.faculdade.HomeFaculdade
import com.bandtec.simplify.professor.HomeProfessor

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginInstitucional : AppCompatActivity() {
    lateinit var preferenciasFaculdade: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_institucional)

        preferenciasFaculdade = getSharedPreferences("faculdade", MODE_PRIVATE)
    }

    fun login(view: View){
        val etLogin: EditText = findViewById(R.id.editTextEmailInstitucional)
        val etSenha: EditText = findViewById(R.id.editTextSenhaInstitcional)
        val dadosLogin : String = etLogin.text.toString()
        val dadosSenha: String = etSenha.text.toString()


        if(dadosLogin != "" && dadosSenha !="") {
            ConexaoApiFaculdade.criar().login(dadosLogin,dadosSenha)
                .enqueue(object : Callback<List<Faculdade>> {
                    override fun onResponse(
                        call: Call<List<Faculdade>>,
                        response: Response<List<Faculdade>>
                    ) {
                        val faculdadeResponse = response.body()
                        print(faculdadeResponse)
                        val statusCode = response.code()
                        if(statusCode.equals(200)){

                            val edit = preferenciasFaculdade.edit()

                            edit.putString("emailLogin",dadosLogin)
                            edit.commit()

                            startActivity(Intent(this@LoginInstitucional, HomeInstitucional::class.java))
                        }else if (statusCode.equals(204)){
                            Toast.makeText(this@LoginInstitucional, "Email ou Senhas incorretos.", Toast.LENGTH_SHORT).show()
                        }else if (statusCode.equals(404)){
                            Toast.makeText(this@LoginInstitucional, "Sistema temporiamente indisponivel, por favor tente novamente mais tarde", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<List<Faculdade>>, t: Throwable) {
                        Toast.makeText(this@LoginInstitucional,"Sistema Indisponivel, por favor comunique o seu administrador, ou entre em contato pelo suport" , Toast.LENGTH_SHORT).show()

                        println("onfailure message: " + t.message)
                    }
                })
        }else{
            Toast.makeText(this@LoginInstitucional, "Campos obrigatórios não informados.", Toast.LENGTH_SHORT).show()
        }
    }


    val professor:Boolean = false;

    fun back(view: View) {
        startActivity(Intent(this@LoginInstitucional, HomeInstitucional::class.java))
    }

    fun navegarPerfil(view: View) {
        if(professor == true){
            startActivity(Intent(this@LoginInstitucional, HomeProfessor::class.java))
        } else {
            startActivity(Intent(this@LoginInstitucional, HomeFaculdade::class.java))
        }
    }
}
