package com.example.surveryor.repository;

import com.example.surveryor.entity.Company;
import com.example.surveryor.entity.dto.EmployeeDTO;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

    @Aggregation(pipeline = {"{ $lookup: { from: 'employees', localField: '_id', foreignField: 'companyId', as: 'employee' } }, { $unwind: '$employee' }, { $lookup: { from: 'locations', localField: 'locationId', foreignField: '_id', as: 'location' } }, { $unwind: '$location' }, { $match: { $and: [{ 'employee.active': 'Y' }] } }, { $project: { _id: 0, employeeName: '$employee.name', companyName: '$name', locationName: '$location.name' }}"})
    List<EmployeeDTO> findEmployeesIsActiveWithCompanyNameAndLocationName();
}
