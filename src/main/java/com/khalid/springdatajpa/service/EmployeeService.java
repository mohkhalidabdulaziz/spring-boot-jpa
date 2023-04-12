package com.khalid.springdatajpa.service;

import com.khalid.springdatajpa.entity.Employee;
import com.khalid.springdatajpa.repo.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Employee> employeePagingAndSorting(Integer pageNumber, Integer pageSize, String sortProperty) {
        /*// sorting
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);*/
        Pageable pageable = null;
        if (sortProperty!=null) {
            pageable = PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC, sortProperty);
        } else {
            pageable = PageRequest.of(pageNumber,pageSize, Sort.Direction.ASC, "name");
        }
        return employeeRepo.findAll(pageable);
    }

    public List<Employee> getAllEmployeesByQuery() {
       return employeeRepo.getAllEmployeesQuery();
    }


    public List<Employee> getAllEmplByPhoneAndDes(Long phoneNumber, List<String> designationList) {
        return employeeRepo.getAllEmployeeByPhoneNumberAndDesignation(phoneNumber,designationList);
    }
}
