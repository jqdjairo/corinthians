package com.bandtec.simplify.conexaoApiFaculdade

import com.bandtec.simplify.conexaoApiEstudante.Estudante
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface FaculdadeApi {
    @GET("faculdade")
    fun get(): Call<List<Faculdade>>

    @GET("faculdade/{id}")
    fun get(@Path("id")id: Int) : Call<Faculdade>

    @Headers("Content-Type: application/json")
    @GET("faculdade/{email}/{senha}")
    fun login(
        @Path(value = "email")email: String,
        @Path(value = "senha")senha: String):Call<List<Faculdade>>

    @POST("faculdade/logoff")
    fun logoff(): Call<String>

}