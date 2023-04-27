package com.mv.course.fhirplainserver.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_paciente", nullable = false)
    private Long id;

    @Column(name = "nm_paciente",nullable = false)
    private String name;

    @Column(name= "dt_nascimento", nullable = false)
    private LocalDate birthDate;

    public Patient(){

    }

    public Patient(Long id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
