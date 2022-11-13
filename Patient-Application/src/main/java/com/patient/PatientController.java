package com.patient;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PatientController {

    private final PatientRepository repository;

    PatientController(PatientRepository repository) {
        this.repository = repository;
    }

    // GET all patients
    @GetMapping("/patients")
    List<Patient> all() {
        return repository.findAll();
    }

    // POST new patient
    @PostMapping("/patients")
    Patient newPatient(@RequestBody Patient newPatient) {
        return repository.save(newPatient);
    }

    // GET single patient by id
    @GetMapping("/patients/{id}")
    Patient getPatientById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new PatientNotFoundException(id));
    }

    // PUT patient
    @PutMapping("/patients/{id}")
    Patient replacePatient(@RequestBody Patient newPatient, @PathVariable Long id) {
        return repository.findById(id)
        .map(patient -> {
            patient.setName(newPatient.getName());
            patient.setSymptom(newPatient.getSymptom());
            return repository.save(patient);
        })
        .orElseGet(() -> {
            newPatient.setId(id);
            return repository.save(newPatient);
        });
    }

    // DELETE patient
    @DeleteMapping("/patients/{id}")
    void deletePatient(@PathVariable Long id) {
        repository.deleteById(id);
    }
}