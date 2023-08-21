package com.spring.rest.democrud.service;

import com.spring.rest.democrud.DAO.IEmployeeDAO;
import com.spring.rest.democrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(IEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(int employeeId) {
        return employeeDAO.findById(employeeId);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        employeeDAO.deleteById(employeeId);
    }

}
