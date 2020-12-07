package com.entity;

import com.common.AppConfig;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public  Connection connection = null;
    public void testDriver() throws ClassNotFoundException{
        try {
            Class.forName(AppConfig.DRIVER.getValue());
        } catch (ClassNotFoundException e) {
            throw new ClassCastException();
        }
    }
    public Connection connection() throws ClassNotFoundException, SQLException {
        this.testDriver();
        try{
            connection= DriverManager.getConnection(AppConfig.URL_DATABASE.getValue(),
                    AppConfig.USERNAME.getValue(),AppConfig.PASSWORD.getValue());
            System.out.println("ket noi thanh cong");
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return connection;
    }

}
