package com.bandtec.simplify.faculdade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bandtec.simplify.R

class FaculdadeValidacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faculdade_validacao)
    }

    fun downloadDocumento(view: View) {}

    fun aceitar(view: View) {}

    fun negar(view: View) {}

    fun voltar(view: View) {
        val telaHomeFaculdade = Intent(this, HomeFaculdade::class.java)
        startActivity(telaHomeFaculdade)
    }
}