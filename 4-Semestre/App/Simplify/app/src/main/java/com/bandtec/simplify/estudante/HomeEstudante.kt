package com.bandtec.simplify.estudante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bandtec.simplify.R
import com.bandtec.simplify.SplashActivity
import com.bandtec.simplify.conexaoApiEstudante.ConexaoEstudanteApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeEstudante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_estudante)


//        btnProfile.setOnClickListener{
//            startActivity(Intent(this@HomeEstudante, ProfileEstudante::class.java))
//        }
//
//        btnConsulta.setOnClickListener{
//            startActivity(Intent(this@HomeEstudante, ConsultaEstudante::class.java))
//        }
//
//        btnHorarios.setOnClickListener{
//            startActivity(Intent(this@HomeEstudante, HorariosEstudante::class.java))
//        }

    }

    //fun navegarHorarios(view: View) {
    //      startActivity(Intent(this@HomeEstudante, HorariosEstudante::class.java))
    //    }

    fun navegarServicos(view: View) {
        startActivity(Intent(this@HomeEstudante, EstudanteInstrucoes::class.java))
    }

    fun navegarQuiz(view: View) {
        startActivity(Intent(this@HomeEstudante, EstudanteQuiz::class.java))
    }

    fun navegarPerfilAluno(view: View) {
        startActivity(Intent(this@HomeEstudante, ProfileEstudante::class.java))
    }

    fun navegarSolicitacao(view: View) {
        startActivity(Intent(this@HomeEstudante, ConsultaEstudante::class.java))
    }

    fun logOut(view: View) {
        ConexaoEstudanteApi.criar().logOut().enqueue(object : Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                startActivity(Intent(this@HomeEstudante, SplashActivity::class.java))
                Toast.makeText(this@HomeEstudante, "Usuário deslogado com sucesso.", Toast.LENGTH_SHORT).show()

            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@HomeEstudante, "Erro ao realizar logoff.", Toast.LENGTH_SHORT).show()
            }

        })
    }
}