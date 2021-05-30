package com.example.apisimplify.Modelos;

import javax.persistence.*;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurma;

    @Column(length = 2, nullable = false)
    private int semestre;

    @Column(length = 2, nullable = false)
    private int ano;

    @ManyToOne
    @JoinColumn(name = "idProfessor")
    private Professor idProfessor;

}