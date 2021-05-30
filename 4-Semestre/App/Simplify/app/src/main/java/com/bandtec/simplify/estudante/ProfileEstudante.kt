package com.bandtec.simplify.estudante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bandtec.simplify.R

class ProfileEstudante : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_estudante)
    }

    fun back(view: View) {
        onBackPressed()
    }
}