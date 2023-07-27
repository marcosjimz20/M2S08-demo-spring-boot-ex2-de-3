package br.senai.lab365.demospringboot.Repositorys;

import br.senai.lab365.demospringboot.Entitys.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

// FIM da classe PetRepository
}
