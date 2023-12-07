/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.notatnik;

/**
 *
 * @author jakub
 */
public class Note {
    private int note_id;
    private String title;
    private String content;

    public int getNote_id() {
        return note_id;
    }
    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }
    
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    
    void setTitle(String title) {
            this.title = title;
    }
    void setContent(String content) {
        this.content = content;
    }
    
}
