package com.example.surveryor.entity.dto;

import com.example.surveryor.entity.Company;

public class EmployeeDTO {

    private String name;
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
