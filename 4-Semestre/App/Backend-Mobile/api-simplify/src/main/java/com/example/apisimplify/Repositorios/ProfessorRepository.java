package com.example.apisimplify.Repositorios;


import com.example.apisimplify.Modelos.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer > {

    List<Professor> findOneByEmailAndSenha(String email, String senha);
}
