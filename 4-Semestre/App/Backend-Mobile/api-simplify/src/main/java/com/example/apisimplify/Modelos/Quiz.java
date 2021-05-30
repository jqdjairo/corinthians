package com.example.apisimplify.Modelos;

import javax.persistence.*;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idQuiz;


    private String questao;


    private String opcao1;


    private String opcao2;


    private String opcao3;


    private String opcao4;


    private String opcao5;

    private String resposta;

    @ManyToOne
    @JoinColumn(name = "pkProfessor")
    private Professor pkProfessor;


    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int idQuiz) {
        this.idQuiz = idQuiz;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public String getOpcao1() {
        return opcao1;
    }

    public void setOpcao1(String opcao1) {
        this.opcao1 = opcao1;
    }

    public String getOpcao2() {
        return opcao2;
    }

    public void setOpcao2(String opcao2) {
        this.opcao2 = opcao2;
    }

    public String getOpcao3() {
        return opcao3;
    }

    public void setOpcao3(String opcao3) {
        this.opcao3 = opcao3;
    }

    public String getOpcao4() {
        return opcao4;
    }

    public void setOpcao4(String opcao4) {
        this.opcao4 = opcao4;
    }

    public String getOpcao5() {
        return opcao5;
    }

    public void setOpcao5(String opcao5) {
        this.opcao5 = opcao5;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Professor getPkProfessor() {
        return pkProfessor;
    }

    public void setPkProfessor(Professor pkProfessor) {
        this.pkProfessor = pkProfessor;
    }
}
