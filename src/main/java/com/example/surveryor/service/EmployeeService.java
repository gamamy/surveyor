package com.example.surveryor.service;

import com.example.surveryor.entity.Employee;
import org.bson.types.ObjectId;

import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee);
    Employee getEmployeeByName(String name);
    List<Employee> getActiveEmployees();
    void deleteEmployee(String employeeId);

}
