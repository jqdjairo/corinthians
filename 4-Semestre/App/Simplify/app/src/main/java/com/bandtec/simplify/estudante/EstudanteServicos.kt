package com.bandtec.simplify.estudante

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.bandtec.simplify.R
import com.bandtec.simplify.SplashActivity

class EstudanteServicos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudante_servicos)

        val btnRealizarUpload = findViewById<Button>(R.id.btnRealizarUpload)

//        btnRealizarUpload.setOnClickListener{
//            startActivity(Intent(this@EstudanteServicos, EstudanteInstrucoes::class.java))
//        }
    }

    fun navegarUpload(view: View) {
        startActivity(Intent(this@EstudanteServicos, EstudanteInstrucoes::class.java))
    }

    fun sair(view: View) {
        startActivity(Intent(this@EstudanteServicos, SplashActivity::class.java))
    }
}