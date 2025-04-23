package com.abcbank.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class User {
    String name;
    int acc_num;
    double balance;
    LocalDate dob;
    String password;
    String email;

    // Default constructor
    public User() {
    }

    // Constructor with parameters
    public User(String name, String email, LocalDate dob, int acc_num) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.acc_num = acc_num;
        this.balance = 0;
    }

    // Constructor with parameters including balance
    public User(String name, String email, LocalDate dob, int acc_num, double balance) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.acc_num = acc_num;
        this.balance = balance;
    }

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/vaam"; // Replace with your database URL
    private static final String DB_USER = "root"; // Replace with your database username
    private static final String DB_PASSWORD = "q1w2e3r4"; // Replace with your database password

    // Method to add a user to the database
    public void addUserToDatabase() {
        // SQL query to insert a new user into the 'users' table
        String query = "INSERT INTO users (name, email, acc_num, dob, balance, password) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Prepare statement
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                // Set parameters
                stmt.setString(1, this.name);
                stmt.setString(2, this.email);
                stmt.setInt(3, this.acc_num);
                stmt.setDate(4, java.sql.Date.valueOf(this.dob)); // Convert LocalDate to SQL Date
                stmt.setDouble(5, this.balance);
                stmt.setString(6, this.password);

                // Execute the update
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("User added successfully!");
                } else {
                    System.out.println("Failed to add user.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error inserting user into database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Getter and Setter methods for the user attributes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcc_num() {
        return acc_num;
    }

    public void setAcc_num(int acc_num) {
        this.acc_num = acc_num;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
