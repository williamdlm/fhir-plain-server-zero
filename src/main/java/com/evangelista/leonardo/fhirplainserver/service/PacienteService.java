package com.evangelista.leonardo.fhirplainserver.service;

import com.evangelista.leonardo.fhirplainserver.models.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {

    Optional<Paciente> findPatientById(Long id);

    List<Paciente> findAllPatients();
}
