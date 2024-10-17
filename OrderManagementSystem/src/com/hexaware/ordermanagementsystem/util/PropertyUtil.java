package com.hexaware.ordermanagementsystem.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    public static String getPropertyString() {
        Properties properties = new Properties();
        try (InputStream input = PropertyUtil.class.getClassLoader().getResourceAsStream("dbconfig.properties")) {
            if (input == null) {
                System.err.println("Sorry, unable to find dbconfig.properties");
                return null;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Fetch properties
        String host = properties.getProperty("hostname");
        String dbname = properties.getProperty("dbname");
        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        String port = properties.getProperty("port");

        // Validate and log properties for debugging
        if (host == null || dbname == null || user == null || password == null || port == null) {
            System.err.println("One or more properties are missing in dbconfig.properties");
            return null;
        }

        // Return formatted connection string
        return "jdbc:mysql://" + host + ":" + port + "/" + dbname + "?user=" + user + "&password=" + password;
    }
}
