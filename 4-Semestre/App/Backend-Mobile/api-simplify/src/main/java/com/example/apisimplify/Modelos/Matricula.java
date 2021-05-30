package com.example.apisimplify.Modelos;

import javax.persistence.*;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMatricula;

    @Column(length = 45, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "idTurma")
    private Turma idTurma;

    @ManyToOne
    @JoinColumn(name = "idAluno")
    private Aluno idAluno;


    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Turma getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Turma idTurma) {
        this.idTurma = idTurma;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }
}
