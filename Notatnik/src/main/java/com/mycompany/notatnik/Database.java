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
    
    public void queryInsert(String title, String content) {
        try (Statement stmt = conn.createStatement()) {
            String insertContentQuery = "INSERT INTO contents (content) VALUES ('" + content + "')";
            stmt.executeUpdate(insertContentQuery, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            int contentId = -1;
            if (rs.next()) {
                contentId = rs.getInt(1);
            }

            String insertNoteQuery = "INSERT INTO note (title, content_id) VALUES ('" + title + "', " + contentId + ")";
            stmt.executeUpdate(insertNoteQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Note> queryTable() {
        List<Note> notes = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT note.note_id, note.title, contents.content FROM note INNER JOIN contents ON note.content_id = contents.id ");

            while (resultSet.next()) {
                int note_id = resultSet.getInt("note_id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                Note note = new Note();
                note.setTitle(title);
                note.setContent(content);
                notes.add(note);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notes;
    }
}