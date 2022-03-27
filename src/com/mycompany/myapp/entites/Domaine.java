/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entites;

import com.codename1.ui.Image;

/**
 *
 * @author pc
 */
public class Domaine {
    private int id;
    private String nomDomaine,descriptionDomaine,imageDomaine;
   

    @Override
    public String toString() {
        return "Domaine{" + "nomDomaine=" + nomDomaine + ", descriptionDomaine=" + descriptionDomaine + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Domaine(int id, String nomDomaine, String descriptionDomaine, String imageDomaine) {
        this.id = id;
        this.nomDomaine = nomDomaine;
        this.descriptionDomaine = descriptionDomaine;
        this.imageDomaine = imageDomaine;
    }

    public Domaine() {
    }
     

    

    public String getNomDomaine() {
        return nomDomaine;
    }

    public void setNomDomaine(String nomDomaine) {
        this.nomDomaine = nomDomaine;
    }

    public String getDescriptionDomaine() {
        return descriptionDomaine;
    }

    public void setDescriptionDomaine(String descriptionDomaine) {
        this.descriptionDomaine = descriptionDomaine;
    }

    public String getImageDomaine() {
        return imageDomaine;
    }

    public void setImageDomaine(String imageDomaine) {
        this.imageDomaine = imageDomaine;
    }

    public Domaine(String nomDomaine, String descriptionDomaine, String imageDomaine) {
        this.nomDomaine = nomDomaine;
        this.descriptionDomaine = descriptionDomaine;
        this.imageDomaine = imageDomaine;
    }
}
