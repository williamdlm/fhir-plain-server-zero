package com.mv.course.fhirplainserver.converters;

import com.google.common.base.Converter;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PatientConverter extends Converter<com.mv.course.fhirplainserver.models.Patient, Patient> {
    @Override
    protected Patient doForward(com.mv.course.fhirplainserver.models.Patient patientMv) {
        Patient patient = new Patient();

        patient.setId(patientMv.getId().toString());
        patient.addName().addGiven(patientMv.getName());

        Date birthDate = patientMv.getBirthDate();
        if(birthDate != null)
            patient.setBirthDate(birthDate);


        return patient;
    }

    @Override
    protected com.mv.course.fhirplainserver.models.Patient doBackward(Patient patientFhir) {
        com.mv.course.fhirplainserver.models.Patient patient = new com.mv.course.fhirplainserver.models.Patient();
        patient.setId(1l);
        List<HumanName> names = patientFhir.getName();
        patient.setName(names.get(0).getGiven().toString());
        patient.setBirthDate(patientFhir.getBirthDate());
        // Adicione outras conversões de campos Java para FHIR aqui, se necessário
        return patient;
    }
}
