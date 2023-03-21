package com.example.basicguiexercise.Utility;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/petstore";
    private static final String user = "root";
    private static final String password = "1234";

    public static java.sql.Connection getCon() {
        java.sql.Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, user, password);
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            e.printStackTrace();
        }
        return connection;
    }
}
