package com.example.surveryor.service.impl;

import com.example.surveryor.config.CustomProjectAggregationOperation;
import com.example.surveryor.entity.Employee;
import com.example.surveryor.entity.dto.EmployeeDTO;
import com.example.surveryor.repository.CompanyRepository;
import com.example.surveryor.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<EmployeeDTO> findEmployeesIsActiveWithCompanyNameAndLocationName() {
        //return companyRepository.findEmployeesIsActiveWithCompanyNameAndLocationName();

        String query =
                "{ $lookup: { from: 'companies', localField: 'companyId', foreignField: '_id', as: 'company' } }";
        TypedAggregation<Employee> aggregation = Aggregation.newAggregation(
                Employee.class,
                new CustomProjectAggregationOperation(query)
        );

        AggregationResults<Map> results =
                mongoTemplate.aggregate(aggregation, Map.class);
        results.getMappedResults();

        return null;
    }
}
