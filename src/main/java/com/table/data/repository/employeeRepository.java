package com.table.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.table.data.model.employee;
//import java.util.List;


public interface employeeRepository extends JpaRepository<employee, Long>{
    employee findByEmail(String email);  
    employee findByfirstName(String firstName);  
}

