package com.bandtec.simplify.conexaoApiProfessor

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProfessorApi {

    @GET("professor")
    fun get(): Call<List<Professor>>

    @GET("professor/{id}")
    fun get(@Path("id")id: Int) : Call<Professor>
}