package com.example.surveryor.service;

import com.example.surveryor.entity.dto.EmployeeDTO;

import java.util.List;

public interface CompanyService {

    List<EmployeeDTO> findEmployeesIsActiveWithCompanyNameAndLocationName();
}
