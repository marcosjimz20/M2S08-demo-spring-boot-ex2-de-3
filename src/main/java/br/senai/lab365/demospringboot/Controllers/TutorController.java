package br.senai.lab365.demospringboot.Controllers;

import br.senai.lab365.demospringboot.DTO.TutorDto;
import br.senai.lab365.demospringboot.Entitys.TutorEntity;
import br.senai.lab365.demospringboot.Services.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorController {
// Atributos
    private TutorService tutorService;


// Constructor
    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }


// Métodos
    @PostMapping("/tutor")
    @ResponseStatus(HttpStatus.CREATED)
    public TutorEntity cadastrarTutor(@RequestBody TutorDto tutorDto) {
        return tutorService.cadastrarTutor(tutorDto);
    }

    @PutMapping("/tutor/{id}")
    public TutorEntity atualizarTutor(@PathVariable Long id, @RequestBody @Valid TutorDto tutorDto) {
        return tutorService.atualizarTutor(id, tutorDto).getBody();
    }

    @GetMapping("/tutor")
    public List<TutorEntity> getAll() {
        return this.tutorService.getAll();
    }

    @DeleteMapping("/tutor/{id}")
    public ResponseEntity<TutorEntity> deletar(@PathVariable Long id) {
        return this.tutorService.deletar(id);
    }


// FIM da classe TutorController
}
