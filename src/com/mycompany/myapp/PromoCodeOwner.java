/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;


/**
 *
 * @author Mohamed
 */
public class PromoCodeOwner {

    

    private String PCD_Name,PCD_FirstName,PCD_Email,PCD_Job,PCD_Gender,PCD_City,PCD_Note;


        private int id,PCD_TelephoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
       
    public PromoCodeOwner(String PCD_Name, String PCD_FirstName, String PCD_Email, String PCD_Job, String PCD_Gender, String PCD_City, String PCD_Note, int PCD_TelephoneNumber) {
        this.PCD_Name = PCD_Name;
        this.PCD_FirstName = PCD_FirstName;
        this.PCD_Email = PCD_Email;
        this.PCD_Job = PCD_Job;
        this.PCD_Gender = PCD_Gender;
        this.PCD_City = PCD_City;
        this.PCD_Note = PCD_Note;
        this.PCD_TelephoneNumber = PCD_TelephoneNumber;
    }

    public PromoCodeOwner() {
    }

    
    @Override
    public String toString() {
        return "PromoCodeOwner{" + "PCD_Name=" + PCD_Name + ", PCD_FirstName=" + PCD_FirstName + ", PCD_Email=" + PCD_Email + ", PCD_Job=" + PCD_Job + ", PCD_Gender=" + PCD_Gender + ", PCD_City=" + PCD_City + ", PCD_Note=" + PCD_Note + ", PCD_TelephoneNumber=" + PCD_TelephoneNumber + '}';
    }

    public String getPCD_Name() {
        return PCD_Name;
    }

    public void setPCD_Name(String PCD_Name) {
        this.PCD_Name = PCD_Name;
    }

    public String getPCD_FirstName() {
        return PCD_FirstName;
    }

    public void setPCD_FirstName(String PCD_FirstName) {
        this.PCD_FirstName = PCD_FirstName;
    }

    public String getPCD_Email() {
        return PCD_Email;
    }

    public void setPCD_Email(String PCD_Email) {
        this.PCD_Email = PCD_Email;
    }

    public String getPCD_Job() {
        return PCD_Job;
    }

    public void setPCD_Job(String PCD_Job) {
        this.PCD_Job = PCD_Job;
    }

    public String getPCD_Gender() {
        return PCD_Gender;
    }

    public void setPCD_Gender(String PCD_Gender) {
        this.PCD_Gender = PCD_Gender;
    }

    public String getPCD_City() {
        return PCD_City;
    }

    public void setPCD_City(String PCD_City) {
        this.PCD_City = PCD_City;
    }

    public String getPCD_Note() {
        return PCD_Note;
    }

    public void setPCD_Note(String PCD_Note) {
        this.PCD_Note = PCD_Note;
    }

    public int getPCD_TelephoneNumber() {
        return PCD_TelephoneNumber;
    }

    public void setPCD_TelephoneNumber(int PCD_TelephoneNumber) {
        this.PCD_TelephoneNumber = PCD_TelephoneNumber;
    }
        

}
