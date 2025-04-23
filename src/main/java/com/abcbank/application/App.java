package com.abcbank.application;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        // Check DB connection first
        Connection conn = Connect.connectDB();

        if (conn != null) {
            System.out.println("✅ Database connected successfully!");
            Login.main(args); // Proceed to login
        } else {
            System.out.println("❌ Failed to connect to the database.");
            System.exit(1); // Exit if DB connection fails
        }
    }
}
