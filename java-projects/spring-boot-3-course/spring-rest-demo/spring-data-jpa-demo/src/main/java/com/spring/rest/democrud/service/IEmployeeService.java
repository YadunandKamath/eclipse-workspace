package com.spring.rest.democrud.service;

import com.spring.rest.democrud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> findAllEmployees();
    Optional<Employee> findEmployeeById(int employeeId);
    Employee saveEmployee(Employee employee);
    void deleteEmployeeById(int employeeId);
}
