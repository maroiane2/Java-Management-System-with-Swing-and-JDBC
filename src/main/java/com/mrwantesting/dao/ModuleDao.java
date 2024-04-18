package com.mrwantesting.dao;

import com.mrwantesting.model.Module;

import java.util.List;

public interface ModuleDao {
    List<Module> findAll();

    Module findById(int id);

    void save(Module module);

    void deleteById(int id);


}
