package com.table.data.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.table.data.model.employee;
import com.table.data.service.employeeService;


@CrossOrigin
@RestController
@RequestMapping("/api/employee/All")
public class controller {

    public employeeService empService;

    public controller(employeeService empService) {
        super();
        this.empService = empService;
    }
    
    //crearte employee restApi
    @PostMapping
    public ResponseEntity<employee> saveEmployee(@RequestBody employee emp){
        return new ResponseEntity<>(empService.saveEmployee(emp), HttpStatus.CREATED);
    }

    //to get all employee restApi
    @GetMapping
    public List<employee> getAllEmployees(){
        return empService.getAllEmployees();
    }

    //to get employee by Id
    @GetMapping("{Id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable("Id") long employeeId){
        return new ResponseEntity<>(empService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    
    //update employee rest Api
    @PutMapping("{Id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable("Id") long employeeId, @RequestBody employee emp){
        return new ResponseEntity<>(empService.updateEmployee(emp, employeeId), HttpStatus.OK);
    }

    //delete employee rest Api
    @DeleteMapping("{Id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("Id") long employeeId){
        empService.deleteEmployee(employeeId);
        return new ResponseEntity<String>("Employee deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<employee> getEmployeeByEmail(@PathVariable("email") String email){
        ResponseEntity<employee> emp  =  new ResponseEntity<>(empService.getEmployeeByEmail(email), HttpStatus.OK);
        //System.out.println(emp.notFound());
        return emp;
    }
    @GetMapping("/name/{firstName}")
    public ResponseEntity<employee> getEmployeeByfirstName(@PathVariable("firstName") String firstName){
        ResponseEntity<employee> emp  =  new ResponseEntity<>(empService.getEmployeeByfirstName(firstName), HttpStatus.OK);
        //System.out.println(emp);
        return emp;
    }
}
