package com.patient;

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
            log.info("Preloading " + repository.save(new Patient("Warrior of Light", "NA", 0)));
            log.info("Preloading " + repository.save(new Patient("Alphinaud Leveilleur", "Cough", 0)));
        };
    }
}