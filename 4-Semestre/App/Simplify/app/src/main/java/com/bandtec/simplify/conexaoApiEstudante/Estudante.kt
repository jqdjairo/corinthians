package com.bandtec.simplify.conexaoApiEstudante

import java.time.LocalDate

data class Estudante(
    val idAluno: Int?,

    val nome: String,

    val ra: String,

    val email: String,

    val senha: String,

    val cpf: String,

    val rg: String,

    val nomeResponsavel: String?,

    //val dataNascimento: String,

    val telefoneResponsavel: String?,

    val emailResponsavel: String?

    //val foto: String?
)