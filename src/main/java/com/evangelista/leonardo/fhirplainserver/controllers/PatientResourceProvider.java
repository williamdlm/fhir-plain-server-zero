package com.evangelista.leonardo.fhirplainserver.controllers;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.server.IResourceProvider;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import com.evangelista.leonardo.fhirplainserver.converters.PatientConverter;
import com.evangelista.leonardo.fhirplainserver.models.Paciente;
import com.evangelista.leonardo.fhirplainserver.service.PacienteService;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PatientResourceProvider implements IResourceProvider {

    @Autowired
    private PacienteService pacienteService;

    private PatientConverter patientConverter = new PatientConverter();

    @Override
    public Class<? extends IBaseResource> getResourceType() {
        return Patient.class;
    }

    @Search()
    public List<Patient> search() {
        return pacienteService
                .findAllPatients()
                .stream()
                .map(patientConverter::convert)
                .collect(Collectors.toList());
    }

    @Read()
    public Patient read(@IdParam IdType id) {
        return pacienteService
                .findPatientById(id.getIdPartAsLong())
                .map(paciente -> patientConverter.convert(paciente))
                .orElseThrow(()->new ResourceNotFoundException(id));
    }
}
