/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entites;

/**
 *
 * @author pc
 */
public class User {

    public User(int id, int age, int tele, String nom, String email, String nomImg) {
        this.id = id;
        this.age = age;
        this.tele = tele;
        this.nom = nom;
        this.email = email;
        this.nomImg = nomImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomImg() {
        return nomImg;
    }

    public void setNomImg(String nomImg) {
        this.nomImg = nomImg;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", age=" + age + ", tele=" + tele + ", nom=" + nom + ", email=" + email + ", nomImg=" + nomImg + '}';
    }


    private int id,age,tele;
    private String nom,email,nomImg ;
}
