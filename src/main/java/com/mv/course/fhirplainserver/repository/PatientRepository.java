package com.mv.course.fhirplainserver.repository;

import com.mv.course.fhirplainserver.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
