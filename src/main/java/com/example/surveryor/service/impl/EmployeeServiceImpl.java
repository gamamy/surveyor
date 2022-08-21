package com.example.surveryor.service.impl;

import com.example.surveryor.entity.Employee;
import com.example.surveryor.repository.EmployeeRepository;
import com.example.surveryor.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {

        employeeRepository.insert(employee);
    }

    @Override
    public Employee getEmployeeByName(String name) {

        return employeeRepository.findEmployeesByName(name);
    }

    @Override
    public List<Employee> getActiveEmployees() {

        List<Employee> employeeList = employeeRepository.findAll();

        // Using java stream
        return employeeList.stream().filter(emp -> emp.getActive().equalsIgnoreCase("Y")).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(String employeeId) {

        employeeRepository.deleteById(employeeId);
    }
}
