package com.patient;

import java.util.UUID;
import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // Repository Container
    @Bean
    CommandLineRunner initDatabase(PatientRepository repository) {
        return args -> {
            Patient p1 = new Patient(UUID.randomUUID(), "Warrior of Light", new HashSet<>(Arrays.asList("NA")), 1, 2, 3);
            Patient p2 = new Patient(UUID.randomUUID(), "Alisaie Leveilleur", new HashSet<>(Arrays.asList("Runny Nose, Cough")));
    
            Patient savedp1 = repository.save(p1);
            Patient savedp2 = repository.save(p2);
        };
    }
}