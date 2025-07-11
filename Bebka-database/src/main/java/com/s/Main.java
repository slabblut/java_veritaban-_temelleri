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
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}