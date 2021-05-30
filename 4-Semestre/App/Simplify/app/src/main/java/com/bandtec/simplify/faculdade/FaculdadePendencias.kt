package com.bandtec.simplify.faculdade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bandtec.simplify.R

class FaculdadePendencias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculdade_pendencias)
    }

    fun navegarAluno(view: View) {
        val telaVaildacao = Intent(this, FaculdadeValidacao::class.java)
        startActivity(telaVaildacao)
    }
}