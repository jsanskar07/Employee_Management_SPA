package com.table.data.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class employee {

    @Id
    @SequenceGenerator(name = "EntityTwoSequence", initialValue = 1000)
	@GeneratedValue(generator = "EntityTwoSequence") 
    private Long EmpID;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    
    @Column(name = "email", unique=true, nullable = false)
    private String email;

    @Column(name = "Address")
    private String address;    
    
        
}
