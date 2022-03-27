/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

/**
 *
 * @author LEGION
 */
public class Question {
        private int id;
    private int id_user;
    private String libelle;
    private String reponse1;
    private String reponse2;
    private String reponse3;
    private String reponse4;
    private int repcorrect;

    public Question() {
    }

    public Question(int id, int id_user, String libelle, String reponse1, String reponse2, String reponse3, String reponse4, int repcorrect) {
        this.id = id;
        this.id_user = id_user;
        this.libelle = libelle;
        this.reponse1 = reponse1;
        this.reponse2 = reponse2;
        this.reponse3 = reponse3;
        this.reponse4 = reponse4;
        this.repcorrect = repcorrect;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReponse1() {
        return reponse1;
    }

    public void setReponse1(String reponse1) {
        this.reponse1 = reponse1;
    }

    public String getReponse2() {
        return reponse2;
    }

    public void setReponse2(String reponse2) {
        this.reponse2 = reponse2;
    }

    public String getReponse3() {
        return reponse3;
    }

    public void setReponse3(String reponse3) {
        this.reponse3 = reponse3;
    }

    public String getReponse4() {
        return reponse4;
    }

    public void setReponse4(String reponse4) {
        this.reponse4 = reponse4;
    }

    public int getRepcorrect() {
        return repcorrect;
    }

    public void setRepcorrect(int repcorrect) {
        this.repcorrect = repcorrect;
    }

    @Override
    public String toString() {
        return "Question{" + "id_user=" + id_user + ", libelle=" + libelle + ", reponse1=" + reponse1 + ", reponse2=" + reponse2 + ", reponse3=" + reponse3 + ", reponse4=" + reponse4 + ", repcorrect=" + repcorrect + '}';
    }

    
}
