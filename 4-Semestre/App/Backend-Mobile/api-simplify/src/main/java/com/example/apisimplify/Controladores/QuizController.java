package com.example.apisimplify.Controladores;

import com.example.apisimplify.Modelos.Quiz;
import com.example.apisimplify.Repositorios.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizRepository repository;

    //verifica resposta certa
    @GetMapping("/resposta/{id}/{res}")
    public ResponseEntity getRespostaCerta(@PathVariable("id") int id,@PathVariable("res") String res){
        List<Quiz> quiz;
        quiz = repository.findById(id);
         String resposta = quiz.get(0).getResposta();

            if (!quiz.isEmpty()) {
                if (resposta.equals(res)){
                    return ResponseEntity.ok(true);
                }else {
                    return ResponseEntity.ok(false);
                }

            } else {
                return ResponseEntity.noContent().build();

            }
    }

    //trás todas as perguntas
    @GetMapping("/perguntas")
    public ResponseEntity getPerguntas(){
        List<Quiz> quiz;
        quiz = repository.findAll();
        List<String> perguntas = new ArrayList<>();
        if (!quiz.isEmpty()){
            for (int i = 0; i < quiz.size();i++) {
                perguntas.add(quiz.get(i).getQuestao());
            }
            return ResponseEntity.ok(perguntas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    //trás as opções
    @GetMapping("/opcao/{id}")
    public ResponseEntity getOpcao(@PathVariable("id") int id){
        List<Quiz> quiz;
        quiz = repository.findById(id);
        List<String> perguntas = new ArrayList<>();
        if (!quiz.isEmpty()){
            for (int i = 0; i < quiz.size();i++) {

                perguntas.add(quiz.get(i).getOpcao1());
                perguntas.add(quiz.get(i).getOpcao2());
                perguntas.add(quiz.get(i).getOpcao3());
                perguntas.add(quiz.get(i).getOpcao4());
                perguntas.add(quiz.get(i).getOpcao5());
            }
            return ResponseEntity.ok(perguntas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping()
    public  ResponseEntity cadastrarPerguntas(@RequestBody Quiz quiz) {
            this.repository.save(quiz);
            return created(null).build();
    }

}
