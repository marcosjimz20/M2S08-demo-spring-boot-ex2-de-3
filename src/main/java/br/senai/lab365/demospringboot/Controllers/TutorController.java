package br.senai.lab365.demospringboot.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutor-pet")
public class TutorController {
// Atributos
    @PostMapping
    public String cadastrarTutor() {
        return "Tutor do pet cadastrado";
    }

    @PutMapping
    public String atualizarTutor() {
        return "Dados do tutor atualizado";
    }

    @GetMapping
    public String buscaTutor() {
        return "Lista de tutores cadastrados";
    }

    @DeleteMapping
    public String deletarPet() {
        return "Tutor removido da lista";
    }


// FIM da classe TutorController
}
