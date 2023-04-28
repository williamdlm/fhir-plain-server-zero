package com.mv.course.fhirplainserver.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@SequenceGenerator(name = "SEQ_PACIENTE", sequenceName = "SEQ_PACIENTE", allocationSize = 1)
@Table(name = "paciente")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_PACIENTE")
    @Column(name = "cd_paciente", nullable = false)
    private Long id;

    @Column(name = "nm_paciente",nullable = false)
    private String name;

    @Column(name= "dt_nascimento", nullable = false)
    private Date birthDate;

    public Patient(){

    }

    public Patient(Long id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }


}
