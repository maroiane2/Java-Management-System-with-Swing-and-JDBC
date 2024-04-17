package com.mrwantesting.dao;


import com.mrwantesting.model.Employeestudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeestudentDaolmpl implements EmployeestudentDao {
    @Override
    public List<Employeestudent> findAll() {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return null;
        }

        List<Employeestudent> employeesstudent = new LinkedList<>();

        String query = "SELECT * FROM student;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employeestudent employeestudent = new Employeestudent(resultSet.getInt("id"), resultSet.getString("Firstname"),
                        resultSet.getString("Surname"),resultSet.getString("city"),resultSet.getString("fields"), resultSet.getInt("age"));
                employeesstudent.add(employeestudent);
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

        return employeesstudent;
    }

    @Override
    public Employeestudent findById(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        String query = "SELECT * FROM student WHERE id=?;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employeestudent employeestudent = new Employeestudent(resultSet.getInt("id"), resultSet.getString("Firstname"),
                        resultSet.getString("Surname"),resultSet.getString("city"),resultSet.getString("fields"), resultSet.getInt("age"));
                return employeestudent;
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
    public void save(Employeestudent employeestudent) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }

        if(employeestudent.getId() > 0){ // update
            String query = "UPDATE student SET Firstname=?, Surname=?, city=?, fields=?, age=? WHERE id=?;";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1,employeestudent.getFirstname());
                preparedStatement.setString(2,employeestudent.getSurname());
                preparedStatement.setString(3,employeestudent.getCity());
                preparedStatement.setString(4,employeestudent.getFields());
                preparedStatement.setInt(5,employeestudent.getAge());
                preparedStatement.setInt(6,employeestudent.getId());

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
            String query = "INSERT INTO student (Firstname, Surname, city, fields, age) VALUES (?, ?, ?, ?, ?);";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1,employeestudent.getFirstname());
                preparedStatement.setString(2,employeestudent.getSurname());
                preparedStatement.setString(3,employeestudent.getCity());
                preparedStatement.setString(4,employeestudent.getFields());
                preparedStatement.setInt(5,employeestudent.getAge());

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

        String query = "DELETE FROM student WHERE id=?;";
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
