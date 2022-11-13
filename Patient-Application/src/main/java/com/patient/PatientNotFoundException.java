package com.patient;

public class PatientNotFoundException extends RuntimeException {

    PatientNotFoundException(Long id) {
        super("Could not find patient " + id);
    }
}