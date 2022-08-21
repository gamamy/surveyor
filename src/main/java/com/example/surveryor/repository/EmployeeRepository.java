package com.example.surveryor.repository;

import com.example.surveryor.entity.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

    @Query("{ 'name' : ?0 }")
    Employee findEmployeesByName(String name);

    @Query("{ 'active' : 'Y' }")
    List<Employee> findActiveEmployees();
}
