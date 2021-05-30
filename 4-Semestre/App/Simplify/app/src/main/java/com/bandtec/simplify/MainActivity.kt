package com.bandtec.simplify

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bandtec.simplify.estudante.HomeEstudante
import com.bandtec.simplify.estudante.LoginEstudante
import com.bandtec.simplify.professor.HomeProfessor


class MainActivity : AppCompatActivity() {

    lateinit var preferencias: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferencias = getSharedPreferences("autenticacao",MODE_PRIVATE)

        val usuarioLogado = preferencias.getString("usuario",null);
        val isProfessor = preferencias.getBoolean("isProfessor",true)

        if(usuarioLogado != null){
            if (!isProfessor)
            {
                val homeEstudante = Intent(this@MainActivity, HomeEstudante::class.java)
                startActivity(homeEstudante)
            }else{
                val homeProfessor = Intent(this@MainActivity, HomeInstitucional::class.java)
                startActivity(homeProfessor)
            }
        }

        val btnEstudante = findViewById<Button>(R.id.btnStudent)

        val btnProfessor = findViewById<Button>(R.id.btnTeach)

        btnEstudante.setOnClickListener{
           startActivity(Intent(this@MainActivity, LoginEstudante::class.java))
       }

        btnProfessor.setOnClickListener{
            startActivity(Intent(this@MainActivity, HomeInstitucional::class.java))
        }

    }


}