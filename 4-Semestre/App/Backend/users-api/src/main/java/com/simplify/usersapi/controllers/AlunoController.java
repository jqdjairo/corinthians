package com.simplify.usersapi.controllers;


import com.simplify.usersapi.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    public AlunoRepository repository;


    @GetMapping("/all")
    public ResponseEntity getAll(){
        List aluno = repository.findAll();
        return ResponseEntity.ok(aluno);
    }
}
