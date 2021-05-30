package com.example.apisimplify.Modelos;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfessor")
    private int idProfessor;

    private String nome;

    private String email;

    private String senha;

    @ManyToOne
    @JoinColumn(name = "pkFaculdade")
    private Faculdade pkFaculdade;

    public int getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Faculdade getPkFaculdade() {
        return pkFaculdade;
    }

    public void setPkFaculdade(Faculdade pkFaculdade) {
        this.pkFaculdade = pkFaculdade;
    }
}
