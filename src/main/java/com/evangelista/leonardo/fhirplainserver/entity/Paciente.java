package com.evangelista.leonardo.fhirplainserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue
    @Column(name = "CD_PACIENTE")
    private Long id;

    @Column(name = "NM_PACIENTE")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
