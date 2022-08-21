package com.example.surveryor.controller;

import com.example.surveryor.entity.Employee;
import com.example.surveryor.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAllEmployee() {

        List<Employee> employees = employeeService.getActiveEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {

        employeeService.createEmployee(employee);

        return new ResponseEntity<>("Create Employee with name : " + employee.getName() + " , Success", HttpStatus.OK);
    }

    @GetMapping(value = "/find-by-name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findEmployeeByName(@RequestParam String employeeName) {

        Employee employee = employeeService.getEmployeeByName(employeeName);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteEmployee(@PathVariable(value = "id") String id) {

        employeeService.deleteEmployee(id);

        return new ResponseEntity<>("Delete Employee id : " + id + " , Success", HttpStatus.OK);
    }
}
