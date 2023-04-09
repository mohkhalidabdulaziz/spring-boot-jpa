package com.khalid.springdatajpa.repo;

import com.khalid.springdatajpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Employee findByEmpId(Long id);
    List<Employee> deleteByDesignation(String designation);

    Employee findTopByDesignationOrderBySalaryDesc(String designation);

}
