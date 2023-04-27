package com.mv.course.fhirplainserver.service;

import com.mv.course.fhirplainserver.models.Patient;

public interface PatientService {
    Patient findById(Long id);
}
