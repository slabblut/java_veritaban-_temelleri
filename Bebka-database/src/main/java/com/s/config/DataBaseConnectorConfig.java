package com.s.config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnectorConfig {

    public static Connection connection;

    //setConnection
    public static void setConnection(){
        try{
            connection= DriverManager.getConnection( DataBaseConfig.DATABASE_URL, DataBaseConfig.DATABASE_USERNAME, DataBaseConfig.DATABASE_PASSWORD);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //getConnection
    public static Connection getConnection(){
        return connection;
    }
    //closeConnection
    public static void closeConnection() {
        try{
            connection.close();
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

}
