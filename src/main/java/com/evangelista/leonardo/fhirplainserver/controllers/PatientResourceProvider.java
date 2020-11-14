package com.evangelista.leonardo.fhirplainserver.controllers;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import com.evangelista.leonardo.fhirplainserver.entity.Paciente;
import com.evangelista.leonardo.fhirplainserver.service.PacienteService;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PatientResourceProvider implements IResourceProvider {

    @Autowired
    private PacienteService pacienteService;

    @Override
    public Class<? extends IBaseResource> getResourceType() {
        return Patient.class;
    }

    @Read()
    public Patient read(@IdParam IdType id) {
        Optional<Paciente> paciente = pacienteService.findPacienteById(id.getIdPartAsLong());
        if(paciente.isPresent()){
            Paciente p = paciente.get();
            Patient patient = new Patient();
            patient.addIdentifier().setValue(p.getId().toString());
            patient.addName().addGiven(p.getNome());
            return patient;
        }
        throw new ResourceNotFoundException(id);
    }
}
