package com.bandtec.simplify.conexaoApiProfessor

import com.bandtec.simplify.conexaoApiEstudante.EstudanteApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoProfessorApi {
    fun criar(): EstudanteApi {
        // Criamos um Builder do Retrofit (preparamos um conjunto de chamadas de EndPoints de uma API)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/")
            .addConverterFactory(GsonConverterFactory.create()) // quem será o "conversor" JSON <=> Classe
            .build()

        // recuperamos a implementação da interface com os EndPoints
        val api = retrofit.create(EstudanteApi::class.java)

        return api
    }
}