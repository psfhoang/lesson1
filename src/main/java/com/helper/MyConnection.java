package com.helper;

import com.common.Constant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public  Connection connection = null;
    public void testDriver() throws ClassNotFoundException{
        try {
            Class.forName(Constant.DRIVER.getValue());
        } catch (ClassNotFoundException e) {
            throw new ClassCastException();
        }
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        this.testDriver();
        try{
            connection= DriverManager.getConnection(Constant.URL_DATABASE.getValue(),
                    Constant.USERNAME.getValue(), Constant.PASSWORD.getValue());
            System.out.println("ket noi thanh cong");
        }catch (SQLException e){
            throw new SQLException(e.getMessage());
        }
        return connection;
    }

}
