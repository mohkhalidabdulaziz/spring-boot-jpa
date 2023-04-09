package com.khalid.springdatajpa.service;

import com.khalid.springdatajpa.entity.Employee;
import com.khalid.springdatajpa.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public List<Employee> saveEmployee(List<Employee> employeeList) {
        return employeeRepo.saveAll(employeeList);
    }

    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long empId) {
            return employeeRepo.findByEmpId(empId);
    }

    public List<Employee> deleteEmployeeById(String designation) {
        return employeeRepo.deleteByDesignation(designation);
    }

    public Employee findEmployeeByDesignationByOrder(String designation) {
        return employeeRepo.findTopByDesignationOrderBySalaryDesc(designation);
    }
}
