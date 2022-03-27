/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Image;

/**
 *
 * @author pc
 */
public class Formation {
    private int id ;
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", nom=" + nom + '}';
    }

    public Formation() {
    }

    public Formation(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

}
