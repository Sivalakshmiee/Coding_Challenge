package com.hexaware.ordermanagementsystem.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load 
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                String connectionString = PropertyUtil.getPropertyString();
                if (connectionString == null) {
                    System.err.println("Connection string is null. Unable to connect to the database.");
                    return null;
                }
                
                // Create the connection
                connection = DriverManager.getConnection(connectionString);
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
