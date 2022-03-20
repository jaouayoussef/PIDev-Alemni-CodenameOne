/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

/**
 *
 * @author louay
 */
public class user {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String picture;
    private String password;
    private String gender;

    public user(String first_name, String last_name, String email, String picture, String password, String gender) {
        this.first_name = first_name;
        this.email = email;
        this.last_name = last_name;
        this.picture = picture;
        this.password = password;
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public user() {
    }

    public user(int id) {
        this.id = id;
    }

    public user(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", adresse=" + email + ", photoDeProfil=" + picture + '}';
    }

    public user(int id, String email, String picture, String first_name, String last_name, String gender) {
        this.id = id;
        this.email = email;
        this.picture = picture;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
    }

    public user(String email, String picture, String first_name, String last_name, String gender) {
        this.email = email;
        this.picture = picture;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
    }
}
