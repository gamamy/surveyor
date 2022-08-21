package com.example.surveryor;

import com.example.surveryor.entity.Employee;
import com.example.surveryor.service.CompanyService;
import com.example.surveryor.service.EmployeeService;
import com.example.surveryor.service.LocationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SurveryorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveryorApplication.class, args);

        // Using JAVA IOC
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        Employee employee = context.getBean("employee", Employee.class);

        System.out.println("\nHi nama saya " + employee.getName());
    }
}
