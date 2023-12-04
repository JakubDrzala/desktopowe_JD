/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notatnik;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jakub
 */
public class Database {
    private Connection connection;

    public void connect() {
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/Notebook";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(dbUrl, username, password);
            if (connection != null) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Dodaj inne metody związane z operacjami na bazie danych, jeśli potrzebujesz

    // Przykład metody do wykonywania zapytań SQL
    public void executeQuery(String query) {
        try {
            
            // Tworzymy statement i wykonujemy zapytanie
            // PreparedStatement preparedStatement = connection.prepareStatement(query);
            // ... wykonanie zapytania i przetwarzanie wyników
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}