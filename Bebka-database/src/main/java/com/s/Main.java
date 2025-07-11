package com.s;

import com.s.config.DataBaseConfig;

import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
               "id SERIAL PRIMARY KEY, "+
                "name VARCHAR(100)," +
                "email VARCHAR(100)"+
                ")";

        try{
            Connection connection= DriverManager.getConnection(DataBaseConfig.DATABASE_URL,
                    DataBaseConfig.DATABASE_USERNAME, DataBaseConfig.DATABASE_PASSWORD);
            Statement statement=connection.createStatement();
            statement.execute(sql);
            System.out.println("Tablo oluşturuldu");


          //preparestatement
          String insertSql  = "INSERT INTO users(name,email) VALUES(?,?)";
          PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
          preparedStatement.setString(1,"sila");
          preparedStatement.setString(2, "silab@test");
          preparedStatement.executeUpdate();

          //resultset
            String selectSql="SELECT * FROM users WHERE email=?";
            PreparedStatement prepared = connection.prepareStatement(selectSql);
            prepared.setString(1,"silab@test");
            ResultSet resultSet=prepared.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getRowId("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("email"));
            }

            //Update işlemi
            String updateSql = "UPDATE users SET name =? WHERE email=?";
            PreparedStatement updateStament = connection.prepareStatement(updateSql);
            updateStament.setString(1,"Sıla Updated");
            updateStament.setString(2,"silab@test");
            int updatedRows = updateStament.executeUpdate();

            //Delete
            String deleteSql = "DELETE FROM users WHERE email = ?";
            PreparedStatement deleteStatment= connection.prepareStatement(deleteSql);
            deleteStatment.setString(1,"silab@test");
            int deletedRows = deleteStatment.executeUpdate();

            preparedStatement.close();
            resultSet.close();
            deleteStatment.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}