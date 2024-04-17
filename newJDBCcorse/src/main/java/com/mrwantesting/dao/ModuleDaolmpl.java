package com.mrwantesting.dao;


import com.mrwantesting.model.Module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ModuleDaolmpl implements ModuleDao{

    @Override
    public List<Module> findAll() {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return null;
        }

        List<Module> sModule = new LinkedList<>();

        String query = "SELECT * FROM modules;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Module module = new Module(resultSet.getInt("id"), resultSet.getString("NameOfModules"),
                        resultSet.getString("formsOfModules1"),resultSet.getString("formsOfModules2"),resultSet.getString("formsOfModules3"));
                sModule.add(module);
            }

        }catch (SQLException se){
            se.printStackTrace();
        }finally{
            try{
                con.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }

        return sModule;
    }

    @Override
    public Module findById(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        String query = "SELECT * FROM modules WHERE id=?;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Module module = new Module(resultSet.getInt("id"), resultSet.getString("NameOfModules"),
                        resultSet.getString("formsOfModules1"),resultSet.getString("formsOfModules2"),resultSet.getString("formsOfModules3"));
                return module;
            }
        }catch (SQLException se){
            se.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }

        return null;
    }

    @Override
    public void save(Module module) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }

        if(module.getId() > 0){ // update
            String query = "UPDATE modules SET NameOfModules=?, formsOfModules1=?, formsOfModules2=?,formsOfModules3=? WHERE id=?;";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, module.getNameOfModules());
                preparedStatement.setString(2, module.getFormsOfModules1());
                preparedStatement.setString(3, module.getFormsOfModules2());
                preparedStatement.setString(4, module.getFormsOfModules3());
                preparedStatement.setInt(5, module.getId());

                preparedStatement.executeUpdate();
            }catch(SQLException se){
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }else { // Create
            String query = "INSERT INTO modules (NameOfModules, formsOfModules1, formsOfModules2, formsOfModules3) VALUES (?, ?, ?, ?);";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1, module.getNameOfModules());
                preparedStatement.setString(2, module.getFormsOfModules1());
                preparedStatement.setString(3, module.getFormsOfModules2());
                preparedStatement.setString(4, module.getFormsOfModules3());

                preparedStatement.executeUpdate();
            }catch(SQLException se){
                se.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }
    }


    @Override
    public void deleteById(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }

        String query = "DELETE FROM modules WHERE id=?;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException se){
            se.printStackTrace();
        }finally{
            try{
                con.close();
            }catch (SQLException se){
                se.printStackTrace();
            }
        }
    }
}
