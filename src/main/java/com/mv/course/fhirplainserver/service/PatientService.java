package com.mv.course.fhirplainserver.service;

import com.mv.course.fhirplainserver.models.Patient;

public interface PatientService {
    Patient findById(Long id);

    Patient createPatient(Patient patient);

    void deletePatientById(Long id);

    Patient updatePatient(Long id, Patient patient);
}
