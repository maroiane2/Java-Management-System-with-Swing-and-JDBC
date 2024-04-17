package com.mrwantesting.dao;

import com.mrwantesting.model.Employee;
import com.mrwantesting.utils.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDaolmpl implements EmployeeDao {
    @Override
    public List<Employee> findAll() {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return null;
        }

        List<Employee> employees = new LinkedList<>();

        String query = "SELECT * FROM employee;";
    try(PreparedStatement preparedStatement = con.prepareStatement(query)){

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getInt("age"), resultSet.getBoolean("gender"), resultSet.getDate("birth_Date"),
                    resultSet.getDouble("salary"));
            employees.add(employee);
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

        return employees;
    }


    @Override
    public Employee findById(int id) {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            return null;
        }

        String query = "SELECT * FROM employee WHERE id=?;";
        try(PreparedStatement preparedStatement = con.prepareStatement(query)){

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Employee employee = new Employee(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("age"), resultSet.getBoolean("gender"), resultSet.getDate("birth_Date"),
                        resultSet.getDouble("salary"));
                return employee;
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
    public void save(Employee employee) {
        Connection con = DBConnection.getConnection();
        if (con == null){
            return;
        }

        if(employee.getId() > 0){ // update
            String query = "UPDATE employee SET name=?, age=?, gender=?, birth_date=?, salray=? WHERE id=?;";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1,employee.getName());
                preparedStatement.setInt(2,employee.getAge());
                preparedStatement.setBoolean(3,employee.isGender());
                preparedStatement.setDate(4, Utils.getSqlDate(employee.getBirthDate()));
                preparedStatement.setDouble(5,employee.getSalary());
                preparedStatement.setInt(6,employee.getId());

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
            String query = "INSERT INTO employee (name, age, gender, birth_date, salary) VALUES (?, ?, ?, ?, ?);";
            try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setString(1,employee.getName());
                preparedStatement.setInt(2,employee.getAge());
                preparedStatement.setBoolean(3,employee.isGender());
                preparedStatement.setDate(4, Utils.getSqlDate(employee.getBirthDate()));
                preparedStatement.setDouble(5,employee.getSalary());

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


        String query = "DELETE FROM employee WHERE id=?;";
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
