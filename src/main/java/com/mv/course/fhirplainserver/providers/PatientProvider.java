package com.mv.course.fhirplainserver.providers;

import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.server.IResourceProvider;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class PatientProvider implements IResourceProvider {

    @Override
    public Class<Patient> getResourceType() {
        return Patient.class;
    }

    @Read
    public Patient readResourceById(@IdParam IdType id){
        Patient patient = new Patient();
        patient.addName().addGiven("William").setFamily("Mota");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1997, 5,22);
        patient.setBirthDate(Date.from(calendar.toInstant()));

        return patient;
    }
}
