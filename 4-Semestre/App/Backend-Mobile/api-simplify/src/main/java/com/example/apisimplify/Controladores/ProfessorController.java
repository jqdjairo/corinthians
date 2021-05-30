package com.example.apisimplify.Controladores;


import com.example.apisimplify.Modelos.Aluno;
import com.example.apisimplify.Modelos.Professor;
import com.example.apisimplify.Repositorios.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.created;


import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired

    public ProfessorRepository repository;

    private boolean logado = false;

    @GetMapping("/{email}/{senha}")
    public ResponseEntity getUsuarioESenha(@PathVariable("email") String email, @PathVariable("senha") String senha ){
        List aluno;
        aluno = repository.findOneByEmailAndSenha(email, senha);
        if(!logado) {
            if (aluno.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                logado = true;
                return ResponseEntity.ok(aluno);
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/logoff")
    public ResponseEntity logoff() {
        if(logado) {
            logado = false;
            return ResponseEntity.ok("Você foi deslogado");
        } else {
            return ResponseEntity.ok("Não existe usuario logado");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity createProfessor(@RequestBody Professor newProfessor){
        this.repository.save(newProfessor);
        return created(null).build();
    }

}
