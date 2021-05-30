package com.example.apisimplify.Modelos;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class RespostasQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespostaQuiz;

    @ManyToOne
    @JoinColumn(name = "pkAluno")
    private Aluno pkAluno;


    @ManyToOne
    @JoinColumn(name = "pkQuiz")
    private Quiz pkQuiz;

    private int resposta;

    @Type(type = "numeric_boolean")
    @Column(columnDefinition = "default 0")
    private boolean correta;

    public int getIdRespostaQuiz() {
        return idRespostaQuiz;
    }

    public void setIdRespostaQuiz(int idRespostaQuiz) {
        this.idRespostaQuiz = idRespostaQuiz;
    }

    public Aluno getPkAluno() {
        return pkAluno;
    }

    public void setPkAluno(Aluno pkAluno) {
        this.pkAluno = pkAluno;
    }

    public Quiz getPkQuiz() {
        return pkQuiz;
    }

    public void setPkQuiz(Quiz pkQuiz) {
        this.pkQuiz = pkQuiz;
    }

    public int getResposta() {
        return resposta;
    }

    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
}
