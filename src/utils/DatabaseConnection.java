package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // These are the details we verified from your pgAdmin sidebar
    private static final String URL = "jdbc:postgresql://localhost:5432/library_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // This line uses the dependency you added to your pom.xml
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the PostgreSQL server successfully!");
        } catch (SQLException e) {
            System.out.println("Connection failure: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        // Run this to test if your link to pgAdmin works!
        getConnection();
    }
}