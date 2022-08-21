package com.example.surveryor.service.impl;

import com.example.surveryor.entity.Employee;
import com.example.surveryor.repository.EmployeeRepository;
import com.example.surveryor.service.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        Employee employeeList = employeeRepository.findEmployeesByName(name);
        return employeeList;
    }

    @Override
    public List<Employee> getActiveEmployees() {

        return employeeRepository.findActiveEmployees();
    }

    @Override
    public void deleteEmployee(String employeeId) {

        employeeRepository.deleteById(employeeId);
    }
}
