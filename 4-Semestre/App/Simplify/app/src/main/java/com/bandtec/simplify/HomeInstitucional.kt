package com.bandtec.simplify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeInstitucional : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_institucional)
    }

    fun loginFaculdade(view: View) {
        startActivity(Intent(this@HomeInstitucional, LoginInstitucional::class.java))
    }
    fun loginProfessor(view: View) {
        startActivity(Intent(this@HomeInstitucional, LoginInstitucional::class.java))
    }
}