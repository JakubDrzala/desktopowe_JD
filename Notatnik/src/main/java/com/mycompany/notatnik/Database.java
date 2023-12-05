/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notatnik;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jakub
 */
public class Database {
    private Connection conn;

    public void connect() {
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/notes";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(dbUrl, username, password);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void queryInsert(String query) {
        try {
            Statement stmt = conn.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> queryTitle() {
        List<String> titles = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT title FROM note");

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                titles.add(title);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return titles;
    }
}