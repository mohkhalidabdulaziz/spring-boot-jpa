package com.khalid.springdatajpa.controller;

import com.khalid.springdatajpa.entity.Employee;
import com.khalid.springdatajpa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public List<Employee> saveEmployees(@RequestBody List<Employee> employeeList) {
        return employeeService.saveEmployee(employeeList);
    }

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{empId}")
    public Employee getEmployeeById(@PathVariable Long empId) {

        return employeeService.getEmployeeById(empId);
    }

    @DeleteMapping("employee/{designation}")
    public List<Employee> getEmployeeByDesignation(@PathVariable String designation) {
        return employeeService.deleteEmployeeById(designation);
    }

    @GetMapping("/employee/getByDesignation")
    public Employee getEmployeeByDesignationDesc(@PathVariable String designation) {
        return employeeService.findEmployeeByDesignationByOrder(designation);
    }
}