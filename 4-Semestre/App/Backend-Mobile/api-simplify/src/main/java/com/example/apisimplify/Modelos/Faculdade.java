package com.example.apisimplify.Modelos;

import javax.persistence.*;

@Entity
public class Faculdade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFaculdade")
    private int idFaculdade;

    private String nome ;

    private String email;

    private String senha;

    public int getIdFaculdade() {
        return idFaculdade;
    }

    public void setIdFaculdade(int idFaculdade) {
        this.idFaculdade = idFaculdade;
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
}
