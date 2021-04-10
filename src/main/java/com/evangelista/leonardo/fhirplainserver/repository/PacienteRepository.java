package com.evangelista.leonardo.fhirplainserver.repository;

import com.evangelista.leonardo.fhirplainserver.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
