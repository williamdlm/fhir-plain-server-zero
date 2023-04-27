package com.mv.course.fhirplainserver.service;

import com.mv.course.fhirplainserver.models.Patient;
import com.mv.course.fhirplainserver.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient findById(Long id){
         return patientRepository
                 .findById(id)
                 .orElseThrow(() -> new RuntimeException());
    }

}
