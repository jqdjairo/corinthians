package com.example.apisimplify.Controladores;


import com.example.apisimplify.Modelos.RespostasQuiz;
import com.example.apisimplify.Repositorios.RespostaQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/resposta")
public class RespostaQuizontroller {


    @Autowired
    private RespostaQuizRepository repository;


    @GetMapping("/all")
    public ResponseEntity allResposta() {
         return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity corretaByAluno(@PathVariable("idAluno") int idAluno) {
        List <RespostasQuiz> quiz = repository.findByPkAluno_idAlunoAndCorreta(idAluno,true);

        return ResponseEntity.ok(quiz.size());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastraResposta(@RequestBody RespostasQuiz resposta){
        repository.save(resposta);
        return created(null).build();
    }

}
