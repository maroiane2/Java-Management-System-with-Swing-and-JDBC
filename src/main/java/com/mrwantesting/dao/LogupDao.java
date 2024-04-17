package com.mrwantesting.dao;

import com.mrwantesting.model.Logup;

import java.util.List;

public interface LogupDao {

        List<Logup> findAll();

        Logup findById(int id);

        void save(Logup logup);

        void deleteById(int id);

}
