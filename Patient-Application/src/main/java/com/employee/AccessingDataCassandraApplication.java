package com.employee;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.core.CassandraTemplate;

@SpringBootApplication
public class AccessingDataCassandraApplication {

    private final static Logger log = LoggerFactory.getLogger(AccessingDataCassandraApplication.class);
  
    public static void main(String[] args) {
        SpringApplication.run(AccessingDataCassandraApplication.class, args);
    }
  
    @Bean
    public CommandLineRunner clr(EmployeeRepository employeeRepository) {
    return args -> {
        employeeRepository.deleteAll();

        Employee e1 = new Employee(UUID.randomUUID(), "Y'shtola", "Rhul", new HashSet<>(Arrays.asList("admin, surgery")), 1, 2, 3, "", "");
        Employee e2 = new Employee(UUID.randomUUID(), "Alphinaud", "Leveilleur", new HashSet<>(Arrays.asList("radiology, surgery")), "", "");

        Employee savede1 = employeeRepository.save(e1);
        Employee savede2 = employeeRepository.save(e2);

        employeeRepository.findAll()
            .forEach(v -> log.info("Employee: {}", v.getFirstName()));

        employeeRepository.findById(savede2.getId())
            .ifPresent(v -> log.info("Employee by id: {}", v.getFirstName()));
        };
    }
}
