package com.example.apisimplify.Modelos;

import javax.persistence.*;

@Entity
public class Arquivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArquivo;

    @Column(length = 45, nullable = false)
    private String tipo;

    @Column(length = 45, nullable = false)
    private String statusArquivo;

    @ManyToOne
    @JoinColumn(name = "idMatricula")
    private Matricula idMatricula;



    public int getIdArquivo() {
        return idArquivo;
    }

    public void setIdArquivo(int idArquivo) {
        this.idArquivo = idArquivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatusArquivo() {
        return statusArquivo;
    }

    public void setStatusArquivo(String statusArquivo) {
        this.statusArquivo = statusArquivo;
    }

    public Matricula getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Matricula idMatricula) {
        this.idMatricula = idMatricula;
    }
}
