package com.bandtec.simplify.conexaoApiEstudante

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.*


interface EstudanteApi {

    @Headers("Content-Type: application/json")
    @GET("aluno/{email}/{senha}")
    fun login(
        @Path("email") email: String,
        @Path("senha") senha: String
    ): Call<List<Estudante>>

    @Headers("Content-Type: application/json")
    @POST("aluno/criar")
    fun cadastro(@Body body: Estudante): Call<Void>

    @POST("aluno/logoff")
    fun logOut(): Call<Void>


    @Multipart
    @POST("/posts")
    fun uploadImage(@Part file:MultipartBody.Part): Call<Void>

}
