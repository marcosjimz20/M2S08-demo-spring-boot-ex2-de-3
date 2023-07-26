package br.senai.lab365.demospringboot.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

// Métodos
    @PostMapping
    public String cadastrarPet() {
        return "pet cadastrado";
    }

    @PutMapping
    public String atualizarPet() {
        return "dados do pet atualizado";
    }

    @GetMapping
    public String buscaPets() {
        return "lista de pets cadastrados";
    }

    @DeleteMapping
    public String deletarPet() {
        return "pet removido da lista";
    }



// FIM da classe PetController
}
