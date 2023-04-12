package com.khalid.springdatajpa.repo;

import com.khalid.springdatajpa.entity.Employee;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Employee findByEmpId(Long id);
    List<Employee> deleteByDesignation(String designation);

    Employee findTopByDesignationOrderBySalaryDesc(String designation);

    @Query("select e from Employee e")
    List<Employee> getAllEmployeesQuery();

    @Query("select e from Employee e where e.phoneNumber=:activePhoneNumber and e.designation in :desinationList")
    public List<Employee> getAllEmployeeByPhoneNumberAndDesignation(@Param("activePhoneNumber") Long activePhoneNumber,
                                                                    @Param("desinationList") List<String> desinationList);

}
