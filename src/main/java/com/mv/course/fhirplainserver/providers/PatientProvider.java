package com.mv.course.fhirplainserver.providers;

import ca.uhn.fhir.rest.annotation.*;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.server.IResourceProvider;
import com.mv.course.fhirplainserver.converters.PatientConverter;
import com.mv.course.fhirplainserver.service.PatientService;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientProvider implements IResourceProvider {

    private static Logger logger = LoggerFactory.getLogger(PatientProvider.class);

    @Autowired
    PatientService patientService;

    @Autowired
    PatientConverter patientConverter;

    @Override
    public Class<Patient> getResourceType() {
        return Patient.class;
    }

    @Read
    public Patient readResourceById(@IdParam IdType id) {
        com.mv.course.fhirplainserver.models.Patient byId = patientService.findById(id.getIdPartAsLong());

        patientConverter.convert(byId);
        return patientConverter.convert(byId);
    }


    @Create
    public MethodOutcome createPatient(@ResourceParam Patient patient) {
        com.mv.course.fhirplainserver.models.Patient newPatient = patientService.createPatient(patientConverter.reverse().convert(patient));
        MethodOutcome methodOutcome = new MethodOutcome();
        methodOutcome.setCreated(true);
        methodOutcome.setResource(patientConverter.convert(newPatient));
        return methodOutcome;
    }

    @Update
    public MethodOutcome updatePatient(@IdParam IdType id, @ResourceParam Patient patient) {
        com.mv.course.fhirplainserver.models.Patient byId = patientService.findById(id.getIdPartAsLong());
        System.out.println(patient.getId());
        logger.info("PATIENT GETID: " + patient.getIdElement().getIdPartAsLong());
        //byId = patientService.updatePatient(patient.getIdElement().getIdPartAsLong(), patientConverter.reverse().convert(patient));
        byId = patientService.updatePatient(id.getIdPartAsLong(), patientConverter.reverse().convert(patient));
        MethodOutcome methodOutcome = new MethodOutcome();
        methodOutcome.setCreated(true);
        methodOutcome.setResource(patientConverter.convert(byId));
        return methodOutcome;
    }


}
