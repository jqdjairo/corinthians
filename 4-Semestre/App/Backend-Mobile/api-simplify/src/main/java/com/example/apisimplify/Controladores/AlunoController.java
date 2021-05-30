package com.example.apisimplify.Controladores;

import com.example.apisimplify.Modelos.Aluno;
import com.example.apisimplify.Repositorios.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/aluno")
public class AlunoController {


    @Autowired
    public AlunoRepository repository;

    private boolean logado = false;

    @GetMapping("/all")
    public  ResponseEntity getAll(){
        List aluno = repository.findAll();
        return ResponseEntity.ok(aluno);
    }

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


    @PostMapping("/criar")
    public ResponseEntity createGamer(@RequestBody Aluno newAluno){
        this.repository.save(newAluno);
        return created(null).build();
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






}
