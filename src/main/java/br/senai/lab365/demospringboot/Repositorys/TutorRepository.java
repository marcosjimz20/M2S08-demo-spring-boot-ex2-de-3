package br.senai.lab365.demospringboot.Repositorys;

import br.senai.lab365.demospringboot.Entitys.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, Long> {

// FIM da classe TutorRepository
}
