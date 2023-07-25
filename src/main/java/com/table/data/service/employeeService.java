package com.table.data.service;

import java.util.List;

import com.table.data.model.employee;

public interface employeeService {
    employee saveEmployee(employee emp);    
    List<employee> getAllEmployees();    
    employee getEmployeeById(long Id);
    employee getEmployeeByEmail(String email);   
    employee getEmployeeByfirstName(String firstName); 
    employee updateEmployee(employee emp, long Id);
    void deleteEmployee(long id);
}
