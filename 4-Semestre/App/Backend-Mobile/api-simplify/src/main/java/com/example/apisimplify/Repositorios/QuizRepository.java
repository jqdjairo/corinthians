package com.example.apisimplify.Repositorios;


import com.example.apisimplify.Modelos.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    List<Quiz> findById(int idQuiz);
    @Override
    List<Quiz> findAll();
}
