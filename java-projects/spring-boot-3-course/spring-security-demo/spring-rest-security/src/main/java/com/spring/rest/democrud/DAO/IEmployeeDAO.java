package com.spring.rest.democrud.DAO;

import com.spring.rest.democrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeDAO extends JpaRepository<Employee, Integer> {

}
