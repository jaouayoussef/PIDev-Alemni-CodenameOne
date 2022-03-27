/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.entites;

/**
 *
 * @author louay
 */
public class reclamation {

    private int id;
    private String titre;
    private String message;
    private String type;
    private String name;
    private String email;
    private String user_file;
    private String sending_date;
    private int status;

    public reclamation() {
    }

    public int getId() {
        return id;
    }

    public reclamation(String titre, String message, String type, String name, String email, String user_file) {
        this.titre = titre;
        this.message = message;
        this.type = type;
        this.name = name;
        this.email = email;
        this.user_file = user_file;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_file() {
        return user_file;
    }

    public void setUser_file(String user_file) {
        this.user_file = user_file;
    }

    public String getSending_date() {
        return sending_date;
    }

    public void setSending_date(String sending_date) {
        this.sending_date = sending_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
