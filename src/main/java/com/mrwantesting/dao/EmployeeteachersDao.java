package com.mrwantesting.dao;

import com.mrwantesting.model.Employeeteachers;

import java.util.List;

public interface EmployeeteachersDao {
    List<Employeeteachers> findAll();

    Employeeteachers findById(int id);

    void save(Employeeteachers employeeteachers);

    void deleteById(int id);
}
