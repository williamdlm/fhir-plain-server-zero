package com.mv.course.fhirplainserver.converters;

import com.google.common.base.Converter;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

import java.util.Date;

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
    protected com.mv.course.fhirplainserver.models.Patient doBackward(Patient patient) {
        return null;
    }
}
