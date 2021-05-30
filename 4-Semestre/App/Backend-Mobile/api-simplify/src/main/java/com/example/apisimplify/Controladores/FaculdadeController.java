package com.example.apisimplify.Controladores;

import com.example.apisimplify.Modelos.Faculdade;
import com.example.apisimplify.Repositorios.FaculdadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.created;

@RestController
@RequestMapping("/faculdade")
public class FaculdadeController {

    @Autowired
    FaculdadeRepository faculdadeRepository;

    private boolean logado = false;

    @GetMapping("/{email}/{senha}")
    public ResponseEntity getUsuarioESenha(@PathVariable("email") String email, @PathVariable("senha") String senha){
        List faculdade;
        faculdade = faculdadeRepository.findAll();
        if(!logado) {
            if (faculdade.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                logado = true;
                return ResponseEntity.ok(faculdade);
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
    public ResponseEntity createProfessor(@RequestBody Faculdade newFacul){
        this.faculdadeRepository.save(newFacul);
        return created(null).build();
    }
}
