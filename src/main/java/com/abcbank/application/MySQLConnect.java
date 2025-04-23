
package com.abcbank.application;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect{
    public static Connection connectDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bat", "root", "q1w2e3r4");
        }
        catch(Exception e){
            return null;
        }            
    }
}