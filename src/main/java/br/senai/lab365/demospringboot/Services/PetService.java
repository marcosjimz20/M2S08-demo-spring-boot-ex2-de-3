package br.senai.lab365.demospringboot.Services;

import br.senai.lab365.demospringboot.DTO.PetDto;
import br.senai.lab365.demospringboot.Entitys.PetEntity;
import br.senai.lab365.demospringboot.Repositorys.PetRepository;
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
public class PetService {
    private PetRepository petRepository;

// Constructor
    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

// Métodos

    public List<PetEntity> cadastrarPet(List<PetEntity> pet) {
        try {
            return petRepository.saveAll(pet);
        }  catch (ConstraintViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }


    public ResponseEntity<PetEntity> atualizarPet(Long id, PetDto petDto) {

        PetEntity petAtual = petRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não encontrado"));
        try {
            petAtual.setNome(petDto.getNome());
            petAtual.setEspecie(petDto.getEspecie());
            petAtual.setRaca(petDto.getRaca());
            petAtual.setPeso(petDto.getPeso());

            PetEntity petAtualizado = petRepository.save(petAtual);
            return ResponseEntity.ok(petAtualizado);
        }  catch (ConstraintViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    public List<PetEntity> getAll() {
        Optional<PetEntity> by =
                this.petRepository.findById(1L);
        by.get();
        return this.petRepository.findAll();
    }

    public ResponseEntity<PetEntity> deletar(Long id) {
        if (!petRepository.existsById(id) ) {
            return ResponseEntity.notFound().build();
        }
        petRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


// FIM da classe PetService
}
