package com.patient;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

interface PatientRepository extends CrudRepository<Patient, UUID> {}