package br.senai.lab365.demospringboot.Entitys;

import jakarta.persistence.*;

@Entity
public class TutorEntity {
// Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeTutor;
    private String rg;
    private String telefone;
    private String email;
    @OneToOne
    private PetEntity pet;

// Constructor
    public TutorEntity() {
    }

    public TutorEntity(Long id, String nomeTutor, String rg, String telefone, String email, PetEntity pet) {
        this.id = id;
        this.nomeTutor = nomeTutor;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.pet = pet;
    }

// Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

// FIM da classe TutorEntity
}
