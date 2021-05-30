package com.example.apisimplify.Repositorios;

import com.example.apisimplify.Modelos.Aluno;
import com.example.apisimplify.Modelos.RespostasQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespostaQuizRepository extends JpaRepository<RespostasQuiz, Integer> {

    List<RespostasQuiz> findByPkAluno_idAlunoAndCorreta (int pkAluno, boolean correta);
}
