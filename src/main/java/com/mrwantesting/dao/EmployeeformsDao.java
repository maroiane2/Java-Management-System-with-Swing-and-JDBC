package com.mrwantesting.dao;


import com.mrwantesting.model.Employeeforms;

import java.util.List;

public interface EmployeeformsDao {
    List<Employeeforms> findAll();

    Employeeforms findById(int id);

    void save(Employeeforms employeeforms);

    void deleteById(int id);
}
