package com.bandtec.simplify.estudante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bandtec.simplify.R
import kotlinx.android.synthetic.main.activity_consulta_estudante.*

class ConsultaEstudante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta_estudante)


        btnVoltar.setOnClickListener{
            onBackPressed()
        }


    }

    fun navegarUpload(view: View) {
        startActivity(Intent(this@ConsultaEstudante, ProfileEstudante::class.java))
    }
}