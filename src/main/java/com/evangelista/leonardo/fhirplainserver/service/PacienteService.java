package com.evangelista.leonardo.fhirplainserver.service;

import com.evangelista.leonardo.fhirplainserver.entity.Paciente;

import java.util.Optional;

public interface PacienteService {
    Optional<Paciente> findPacienteById(Long id);
}
