package com.example.apisimplify.Modelos;

import javax.persistence.*;

@Entity
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idServicos;

    @Column(length = 45, nullable = false)
    private String nome;

    @Column(length = 45, nullable = false)
    private String tipo;

    @Column(length = 45, nullable = false)
    private String documento;

    @Column(length = 45, nullable = false)
    private String serviCool;

    @ManyToOne
    @JoinColumn(name = "idFaculdade")
    private  Faculdade idFaculdade;

    @ManyToOne
    @JoinColumn(name = "idAluno")
    private  Aluno idAluno;

    public int getIdServicos() {
        return idServicos;
    }

    public void setIdServicos(int idServicos) {
        this.idServicos = idServicos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getServiool() {
        return serviCool;
    }

    public void setServiool(String serviool) {
        this.serviCool = serviool;
    }

    public Faculdade getIdFaculdade() {
        return idFaculdade;
    }

    public void setIdFaculdade(Faculdade idFaculdade) {
        this.idFaculdade = idFaculdade;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }
}
