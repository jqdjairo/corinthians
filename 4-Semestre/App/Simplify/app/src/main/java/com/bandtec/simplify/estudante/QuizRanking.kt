package com.bandtec.simplify.estudante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bandtec.simplify.R

class QuizRanking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_ranking)
    }

    fun voltar(view: View) {
        onBackPressed()
    }
}