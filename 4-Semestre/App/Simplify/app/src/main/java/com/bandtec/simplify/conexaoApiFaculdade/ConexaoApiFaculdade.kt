package com.bandtec.simplify.conexaoApiFaculdade

import com.bandtec.simplify.conexaoApiEstudante.EstudanteApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoApiFaculdade {

    fun criar(): FaculdadeApi {

        var baseHost ="";
        // Criamos um Builder do Retrofit (preparamos um conjunto de chamadas de EndPoints de uma API)
        val retrofit = Retrofit.Builder()
            .baseUrl("$baseHost/")
                //Adcionar endpoint da API, e oo base host, exemplo localhost:8080
            .addConverterFactory(GsonConverterFactory.create()) // quem será o "conversor" JSON <=> Classe
            .build()

        // recuperamos a implementação da interface com os EndPoints
        val api = retrofit.create<FaculdadeApi>(FaculdadeApi::class.java)

        return api
    }
}