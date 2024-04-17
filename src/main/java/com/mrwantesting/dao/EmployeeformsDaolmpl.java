package com.mrwantesting.dao;

import com.mrwantesting.model.Employee;
import com.mrwantesting.model.Employeeforms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeformsDaolmpl implements EmployeeformsDao {

    @Override
    public List<Employeeforms> findAll() {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return null;
        }

        List<Employeeforms> employeesforms = new LinkedList<>();

        String query = "SELECT * FROM forms;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employeeforms employeeforms = new Employeeforms(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("teacher"), resultSet.getInt("times"));
                employeesforms.add(employeeforms);
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

        return employeesforms;
    }

    @Override
    public Employeeforms findById(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        String query = "SELECT * FROM forms WHERE id=?;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employeeforms employeeforms = new Employeeforms(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("teacher"), resultSet.getInt("times"));
                return employeeforms;
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
    public void save(Employeeforms employeeforms) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }

        if(employeeforms.getId() > 0){ // update
            String query = "UPDATE forms SET name=?, teacher=?, times=? WHERE id=?;";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1,employeeforms.getName());
                preparedStatement.setString(2,employeeforms.getTeacher());
                preparedStatement.setInt(3,employeeforms.getTimes());
                preparedStatement.setInt(4,employeeforms.getId());

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
            String query = "INSERT INTO forms (name, teacher, times) VALUES (?, ?, ?);";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1,employeeforms.getName());
                preparedStatement.setString(2,employeeforms.getTeacher());
                preparedStatement.setInt(3,employeeforms.getTimes());

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

        String query = "DELETE FROM forms WHERE id=?;";
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
