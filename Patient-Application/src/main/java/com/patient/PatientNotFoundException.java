package com.patient;

import java.util.UUID;

public class PatientNotFoundException extends RuntimeException {

    PatientNotFoundException(UUID id) {
        super("Could not find patient " + id);
    }
}