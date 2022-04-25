package com.company.dbhelper;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection(){

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/students", "postgres", "s8*3viri");
            if (connection != null) System.out.println("Connection successful!");

        } catch (SQLException e) {
            System.out.println("There was a problem connecting to the database");
            e.printStackTrace();

        }
        return connection;
    }

}
