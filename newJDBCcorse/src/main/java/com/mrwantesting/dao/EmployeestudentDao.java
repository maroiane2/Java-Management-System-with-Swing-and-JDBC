package com.mrwantesting.dao;

import com.mrwantesting.model.Employeestudent;

import java.util.List;

public interface EmployeestudentDao {
    List<Employeestudent> findAll();

    Employeestudent findById(int id);

    void save(Employeestudent employeestudent);

    void deleteById(int id);
}
