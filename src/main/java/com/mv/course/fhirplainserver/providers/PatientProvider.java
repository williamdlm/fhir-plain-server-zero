package com.mv.course.fhirplainserver.providers;

import ca.uhn.fhir.rest.annotation.Create;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.ResourceParam;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.server.IResourceProvider;
import com.mv.course.fhirplainserver.converters.PatientConverter;
import com.mv.course.fhirplainserver.service.PatientService;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;

@Component
public class PatientProvider implements IResourceProvider {

    @Autowired
   PatientService patientService;

    @Autowired
    PatientConverter patientConverter;

    @Override
    public Class<Patient> getResourceType() {
        return Patient.class;
    }

    @Read
    public Patient readResourceById(@IdParam IdType id){
        com.mv.course.fhirplainserver.models.Patient byId = patientService.findById(id.getIdPartAsLong());

        patientConverter.convert(byId);
        return patientConverter.convert(byId);
    }


    @Create
    public MethodOutcome createPatient(@ResourceParam Patient patient){
        com.mv.course.fhirplainserver.models.Patient teste = patientConverter.reverse().convert(patient);
        com.mv.course.fhirplainserver.models.Patient newPatient = patientService.createPatient(teste);
        MethodOutcome methodOutcome = new MethodOutcome();
        methodOutcome.setCreated(true);
        methodOutcome.setResource(patientConverter.convert(newPatient));
        return methodOutcome;
    }
}
