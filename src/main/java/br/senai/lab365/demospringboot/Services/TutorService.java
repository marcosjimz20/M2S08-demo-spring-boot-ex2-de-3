package br.senai.lab365.demospringboot.Services;

import br.senai.lab365.demospringboot.DTO.TutorDto;
import br.senai.lab365.demospringboot.Entitys.PetEntity;
import br.senai.lab365.demospringboot.Entitys.TutorEntity;
import br.senai.lab365.demospringboot.Repositorys.PetRepository;
import br.senai.lab365.demospringboot.Repositorys.TutorRepository;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {
// Atributos
    private TutorRepository tutorRepository;
    private PetRepository petRepository;

// Constructor
    @Autowired

    public TutorService(TutorRepository tutorRepository, PetRepository petRepository) {
        this.tutorRepository = tutorRepository;
        this.petRepository = petRepository;
    }

// Métodos
    public TutorEntity cadastrarTutor(TutorDto tutorDto) {

        PetEntity petAtual = petRepository.findById(tutorDto.getPetId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não registrado"));
        try {
            TutorEntity tutor = new TutorEntity();
            tutor.setNomeTutor(tutorDto.getNomeTutor());
            tutor.setRg(tutorDto.getRg());
            tutor.setTelefone(tutorDto.getTelefone());
            tutor.setEmail(tutorDto.getEmail());

            tutor.setPet(petAtual);

            return tutorRepository.save(tutor);

        } catch (ConstraintViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    public ResponseEntity<TutorEntity> atualizarTutor(Long id, TutorDto tutorDto) {

        PetEntity petAtual = petRepository.findById(tutorDto.getPetId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não registrado"));

        TutorEntity tutorAtual = tutorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor não encontrado"));

        try {

            tutorAtual.setNomeTutor(tutorDto.getNomeTutor());
            tutorAtual.setRg(tutorDto.getRg());
            tutorAtual.setTelefone(tutorDto.getTelefone());
            tutorAtual.setEmail(tutorDto.getEmail());

            tutorAtual.setPet(petAtual);

            TutorEntity tutorAtualizado = tutorRepository.save(tutorAtual);
            return ResponseEntity.ok(tutorAtualizado);
        }  catch (ConstraintViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    public List<TutorEntity> getAll() {
        Optional<TutorEntity> by =
                this.tutorRepository.findById(1L);
        by.get();
        return this.tutorRepository.findAll();
    }


    public ResponseEntity<TutorEntity> deletar(Long id) {
        if (!tutorRepository.existsById(id) ) {
            return ResponseEntity.notFound().build();
        }
        tutorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

// FIM da classe TutorService
}
