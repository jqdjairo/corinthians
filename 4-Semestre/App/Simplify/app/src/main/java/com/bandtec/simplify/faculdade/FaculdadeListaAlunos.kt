package com.bandtec.simplify.faculdade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bandtec.simplify.R

class FaculdadeListaAlunos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculdade_lista_alunos)
    }

    fun telaAluno(view: View) {
        val telaAluno = Intent(this, FaculdadeValidacao::class.java)
        startActivity(telaAluno)
    }

    fun pesquisarAluno(view: View) {}

    fun navegarAluno(view: View) {}

}