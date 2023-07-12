package com.ares.mpjfx;

import java.sql.*;

public class Connection_DB {
        private static final String DB_URL = "jdbc:mysql://localhost:3306/projetjfx";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "";


        public static Void getConnection() throws Exception{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                Statement transmission = (Statement) connection.createStatement();
                System.out.println("Connected to database");
                return null;
            } catch (Exception e) {
                System.out.println("Connection failed: " + e.getMessage());
                return null;
            }
        }

    public static ResultSet executeQuery(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement transmission = (Statement) connection.createStatement();
            transmission.executeUpdate(query);
            System.out.println("Query executed");
        } catch (Exception e) {
            System.out.println("Query failed: " + e.getMessage());
        }
        return null;
    }

    public static ResultSet getResultSet(String query) {
try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement transmission = (Statement) connection.createStatement();
            ResultSet resultSet = transmission.executeQuery(query);
            System.out.println("Query executed");
            return resultSet;
        } catch (Exception e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    public static PreparedStatement preparedStatement(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println("Query executed");
            return preparedStatement;
        } catch (Exception e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}
