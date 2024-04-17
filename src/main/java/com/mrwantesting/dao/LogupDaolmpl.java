package com.mrwantesting.dao;

import com.mrwantesting.model.Logup;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LogupDaolmpl implements LogupDao{
    @Override
    public List<Logup> findAll() {
        return null;
    }

    @Override
    public Logup findById(int id) {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                return null;
            }

            String query = "SELECT * FROM logup WHERE id=?;";
            try(PreparedStatement preparedStatement = con.prepareStatement(query)){

                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    Logup logup = new Logup(resultSet.getInt("id"), resultSet.getString("Name"),
                            resultSet.getString("email"),resultSet.getString("password"));
                    return logup;
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
    public void save(Logup logup) {

            Connection con = DBConnection.getConnection();
            if (con == null){
                return;
            }

            if(logup.getId() > 0){ // update
                String query = "UPDATE logup SET Name=?, email=?, password=?, WHERE id=?;";
                try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                    preparedStatement.setString(1, logup.getName());
                    preparedStatement.setString(2, logup.getEmail());
                    preparedStatement.setString(3, logup.getPassword());
                    preparedStatement.setInt(4, logup.getId());

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
            else { // Create
                String query = "INSERT INTO logup (name, email, password) VALUES (?, ?, ?);";
                try( PreparedStatement preparedStatement = con.prepareStatement(query)){

                    preparedStatement.setString(1, logup.getName());
                    preparedStatement.setString(2, logup.getEmail());
                    preparedStatement.setString(3, logup.getPassword());

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

    }
}
