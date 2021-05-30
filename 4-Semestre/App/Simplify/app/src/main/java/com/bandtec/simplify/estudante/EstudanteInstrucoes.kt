package com.bandtec.simplify.estudante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bandtec.simplify.R

class EstudanteInstrucoes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudante_instrucoes)
    }

    fun navegarUpload(view: View) {
        startActivity(Intent(this@EstudanteInstrucoes, EstudanteEnvioDocumentos::class.java))
    }

    fun back(view: View) {
        onBackPressed()
    }
}