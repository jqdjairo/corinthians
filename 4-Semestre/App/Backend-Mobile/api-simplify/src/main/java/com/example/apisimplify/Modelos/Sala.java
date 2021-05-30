package com.example.apisimplify.Modelos;

import javax.persistence.*;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSala;

    @Column(length = 2, nullable = false)
    private String codigo;

    @ManyToOne
    @JoinColumn(name = "idTurma")
    private Turma idTurma;

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Turma getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Turma idTurma) {
        this.idTurma = idTurma;
    }
}
