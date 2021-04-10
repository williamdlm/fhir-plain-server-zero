package com.evangelista.leonardo.fhirplainserver.service.impl;

import com.evangelista.leonardo.fhirplainserver.models.Paciente;
import com.evangelista.leonardo.fhirplainserver.repository.PacienteRepository;
import com.evangelista.leonardo.fhirplainserver.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Optional<Paciente> findPatientById(Long id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public List<Paciente> findAllPatients() {
        return pacienteRepository.findAll();
    }
}
