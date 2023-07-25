package com.table.data.service.impl;

import java.util.List;
//import java.util.Optional;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.table.data.exception.resourceNotFound;
import com.table.data.model.employee;
import com.table.data.repository.employeeRepository;
import com.table.data.service.employeeService;

@Service
public class employeeServiceImpl implements employeeService {

    private employeeRepository EmpRepository;
    public employeeServiceImpl(employeeRepository empRepository) {
        super();
        EmpRepository = empRepository;
    }
    @Override
    public employee saveEmployee(employee emp) {
        // TODO Auto-generated method stub
        return EmpRepository.save(emp);
        //throw new UnsupportedOperationException("Unimplemented method 'saveEmployee'");
    }
    @Override
    public List<employee> getAllEmployees() {
        // TODO Auto-generated method stub
        return EmpRepository.findAll();
        //throw new UnsupportedOperationException("Unimplemented method 'getAllEmployees'");
    }
    @Override
    public employee getEmployeeById(long Id) {
        // TODO Auto-generated method stub
        //Lambda Expression
        System.out.println(EmpRepository.findById(Id));
        return EmpRepository.findById(Id).orElseThrow(() ->
                                        new resourceNotFound("Employee","Id",Id));

        // if(emp.isPresent()){
        //     return emp.get();
        // }else{
        //     throw new resourceNotFound("Employee", "Id", Id);
        // }
        
    }
    @Override
    public employee getEmployeeByEmail(String email) {
        // TODO Auto-generated method stub
        //System.out.println(EmpRepository.findByEmail(email));        
         employee exist = EmpRepository.findByEmail(email);         
         employee notexist = new employee();
         notexist.setFirstName("Not Found");
         notexist.setLastName("Not Found");
         notexist.setAddress("Not Found");
         notexist.setEmail("Not Found");
         notexist.setEmpID(000l);

         if(exist == null){
            return notexist;
         }
         return exist;

            
         
        //throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }
   
    @Override
    public employee updateEmployee(employee emp, long Id) {
        // TODO Auto-generated method stub
        employee existingEmployee = EmpRepository.findById(Id).orElseThrow(() -> new resourceNotFound("Employee","Id",Id));
        existingEmployee.setFirstName(emp.getFirstName());
        existingEmployee.setLastName(emp.getLastName());
        existingEmployee.setEmail(emp.getEmail());
        existingEmployee.setAddress(emp.getAddress());

        EmpRepository.save(existingEmployee);
        return existingEmployee;
        //throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }
    @Override
    public void deleteEmployee(long Id) {
        // TODO Auto-generated method stub
         EmpRepository.findById(Id).orElseThrow(() -> new resourceNotFound("Employee", "Id", Id));
         EmpRepository.deleteById(Id);
        //throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }
    @Override
    public employee getEmployeeByfirstName(String firstName) {
        // TODO Auto-generated method stub
        employee exist = EmpRepository.findByfirstName(firstName);
        employee notexist = new employee();
         notexist.setFirstName("Not Found");
         notexist.setLastName("Not Found");
         notexist.setAddress("Not Found");
         notexist.setEmail("Not Found");
         notexist.setEmpID(000l);
         if(exist == null){
            return notexist;
         }
         return exist;
        //throw new UnsupportedOperationException("Unimplemented method 'getEmployeeByfirstName'");
    }
       
   
}
