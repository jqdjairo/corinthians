package com.bandtec.simplify.conexaoApiEstudante

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ConexaoEstudanteApi {

    fun criar(): EstudanteApi{
        var retrofit = Retrofit.Builder()
        // Criamos um Builder do Retrofit (preparamos um conjunto de chamadas de EndPoints de uma API)
            .baseUrl("http://192.168.1.104:3001/")
            .addConverterFactory(GsonConverterFactory.create()) // quem será o "conversor" JSON <=> Classe
            .build()

        // recuperamos a implementação da interface com os EndPoints
        val api = retrofit.create<EstudanteApi>(EstudanteApi::class.java)

        return api
    }

}