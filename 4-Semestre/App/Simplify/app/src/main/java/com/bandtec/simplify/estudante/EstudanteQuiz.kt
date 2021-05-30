package com.bandtec.simplify.estudante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bandtec.simplify.R

class EstudanteQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estudante_quiz)
    }

    fun navegarResultadoQuiz(view: View) {
        startActivity(Intent(this@EstudanteQuiz, QuizRanking::class.java))
    }
}