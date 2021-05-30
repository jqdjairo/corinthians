package com.example.apisimplify.Modelos;

import javax.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "idFaculdade")
    private Faculdade idFaculdade;


    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Faculdade getIdFaculdade() {
        return idFaculdade;
    }

    public void setIdFaculdade(Faculdade idFaculdade) {
        this.idFaculdade = idFaculdade;
    }
}
