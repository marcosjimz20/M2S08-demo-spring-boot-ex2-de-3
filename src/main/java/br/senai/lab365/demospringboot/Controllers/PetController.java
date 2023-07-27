package br.senai.lab365.demospringboot.Controllers;

import br.senai.lab365.demospringboot.DTO.PetDto;
import br.senai.lab365.demospringboot.Entitys.PetEntity;
import br.senai.lab365.demospringboot.Repositorys.PetRepository;
import br.senai.lab365.demospringboot.Services.PetService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {
// Atributos
    private PetService petService;



// Constructor
    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

// Métodos
    @PostMapping("/pets")
    public ResponseEntity<?> cadastrarPet(@RequestBody List<PetEntity> pet) {
        try {
            List<PetEntity> petNovo = petService.cadastrarPet(pet);
            return ResponseEntity.status(HttpStatus.CREATED).body(petNovo);
        }  catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


    @PutMapping("/pets/{id}")
    public PetEntity atualizarPet(@PathVariable Long id, @RequestBody PetDto petDto) {
        return petService.atualizarPet(id, petDto).getBody();
    }

    @GetMapping("/pets")
    public List<PetEntity> getAll() {
        return this.petService.getAll();
    }


    @DeleteMapping("/pets/{id}")
    public ResponseEntity<PetEntity> deletar(@PathVariable Long id) {
        return this.petService.deletar(id);
    }


// FIM da classe PetController
}
