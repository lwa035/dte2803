package com.employee;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {
    Employee findByFirstName(String username);
}