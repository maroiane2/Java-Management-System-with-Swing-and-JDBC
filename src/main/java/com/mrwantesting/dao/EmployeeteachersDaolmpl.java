package com.mrwantesting.dao;


import com.mrwantesting.model.Employeestudent;
import com.mrwantesting.model.Employeeteachers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeteachersDaolmpl implements EmployeeteachersDao {

    @Override
    public List<Employeeteachers> findAll() {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return null;
        }

        List<Employeeteachers> employeesteachers = new LinkedList<>();

        String query = "SELECT * FROM teachers;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employeeteachers employeeteachers = new Employeeteachers(resultSet.getInt("id"), resultSet.getString("Firstname"),
                        resultSet.getString("Surname"),resultSet.getString("city"), resultSet.getInt("age"));
                employeesteachers.add(employeeteachers);
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

        return employeesteachers;
    }

    @Override
    public Employeeteachers findById(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        String query = "SELECT * FROM teachers WHERE id=?;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employeeteachers employeeteachers = new Employeeteachers(resultSet.getInt("id"), resultSet.getString("Firstname"),
                        resultSet.getString("Surname"),resultSet.getString("city"),resultSet.getInt("age"));
                return employeeteachers;
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
    public void save(Employeeteachers employeeteachers) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }

        if(employeeteachers.getId() > 0){ // update
            String query = "UPDATE teachers SET Firstname=?, Surname=?, city=?, age=? WHERE id=?;";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1,employeeteachers.getFirstname());
                preparedStatement.setString(2,employeeteachers.getSurname());
                preparedStatement.setString(3,employeeteachers.getCity());
                preparedStatement.setInt(4,employeeteachers.getAge());
                preparedStatement.setInt(5,employeeteachers.getId());

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
            String query = "INSERT INTO teachers (Firstname, Surname, city, age) VALUES (?, ?, ?, ?);";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1,employeeteachers.getFirstname());
                preparedStatement.setString(2,employeeteachers.getSurname());
                preparedStatement.setString(3,employeeteachers.getCity());
                preparedStatement.setInt(4,employeeteachers.getAge());

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

        String query = "DELETE FROM teachers WHERE id=?;";
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
