package com.abcbank.application;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static Connection connectDB() {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to your MySQL DB
            return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/bat", // DB URL
                "root", // MySQL username
                "q1w2e3r4"  // MySQL password
            );

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
