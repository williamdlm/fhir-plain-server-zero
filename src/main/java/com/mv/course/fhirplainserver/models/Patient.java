package com.mv.course.fhirplainserver.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@SequenceGenerator(name = "SEQ_PACIENTE", sequenceName = "SEQ_PACIENTE", allocationSize = 1)
@Table(name = "paciente", schema = "dbamv")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PACIENTE")
    @Column(name = "cd_paciente", nullable = false)
    private Long id;

    @Column(name = "nm_paciente")
    @ApiModelProperty(value = "Patient's name")
    private String name;

    @Column(name = "dt_nascimento")
    @Temporal(TemporalType.TIMESTAMP)
    @ApiModelProperty(value = "Patient's birth date")
    private Date birthDate;


}
