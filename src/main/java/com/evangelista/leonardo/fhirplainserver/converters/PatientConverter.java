package com.evangelista.leonardo.fhirplainserver.converters;

import com.evangelista.leonardo.fhirplainserver.models.Paciente;
import com.google.common.base.Converter;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Patient;

public class PatientConverter extends Converter<Paciente,Patient> {

    @Override
    protected Patient doForward(Paciente paciente) {

        Patient patient = new Patient();

        patient.setId(paciente.getId().toString());

        patient.addIdentifier().setValue(paciente.getId().toString());
        patient.addName().addGiven(paciente.getNome());

        Extension ext = new Extension();
        ext.setUrl("http://example.com/extensions#vip");
        ext.setValue(new BooleanType(true));
        patient.addExtension(ext);


        return patient;
    }

    @Override
    protected Paciente doBackward(Patient patient) {
        return null;
    }
}
