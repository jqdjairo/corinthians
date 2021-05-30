package com.example.apisimplify.Repositorios;



import com.example.apisimplify.Modelos.Faculdade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaculdadeRepository extends JpaRepository<Faculdade, Integer> {
    List<Faculdade> findOneByEmailAndSenha(String email, String senha);
}
