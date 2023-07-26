package br.senai.lab365.demospringboot.Entitys;

public class TutorEntity {
// Atributos
    private int id;
    private String nomeTutor;
    private String Rg;
    private String Telefone;
    private String Email;

// Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public String getRG() {
        return Rg;
    }

    public void setRG(String RG) {
        this.Rg = Rg;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


// FIM da classe TutorEntity
}
