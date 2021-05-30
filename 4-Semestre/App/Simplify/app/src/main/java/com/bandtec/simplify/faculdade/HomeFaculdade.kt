package com.bandtec.simplify.faculdade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bandtec.simplify.R
import com.bandtec.simplify.SplashActivity
import com.bandtec.simplify.professor.HomeProfessor

class HomeFaculdade : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_faculdade)
    }

    fun navegarListaAluno(view: View) {
        val telaListaAlunos = Intent(this, FaculdadeListaAlunos::class.java)
        startActivity(telaListaAlunos)
    }

    fun voltar(view: View) {
        val homeFaculdade = Intent(this, HomeFaculdade::class.java)
        startActivity(homeFaculdade)
    }

    fun telaPendencias(view: View) {
        val telaPendencias = Intent(this, FaculdadePendencias::class.java)
        startActivity(telaPendencias)
    }

    fun sair(view: View) {
        val telaInicio = Intent(this, SplashActivity::class.java)
        startActivity(telaInicio)
    }
}