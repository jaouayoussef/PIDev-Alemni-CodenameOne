/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.io.Preferences;

/**
 *
 * @author louay
 */
public class SessionManager {

    public static Preferences pref;

    private static int id;
    private static String first_name;
    private static String last_name;
    private static String email;
    private static String picture;
    private static String password;
    private static String gender;
private static String role;

    public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }

    public static int getId() {
        return pref.get("id", id);
    }

    public static void setId(int id) {
        pref.set("id", id);//nsajl id user connecté  w na3tiha identifiant "id";
    }

    public static String getFirstName() {
        return pref.get("first_name", first_name);
    }

    public static void setFirstName(String first_name) {
        pref.set("first_name", first_name);
    }

public static String getRoles() {
        return pref.get("role", role);
    }

    public static void setRole(String role) {
        pref.set("role", role);
    }

    public static String getLastName() {
        return pref.get("last_name", last_name);
    }

    public static void setLastName(String last_name) {
        pref.set("last_name", last_name);
    }

    public static String getGender() {
        return pref.get("gender", gender);
    }

    public static void setGender(String gender) {
        pref.set("gender", gender);
    }

    public static String getEmail() {
        return pref.get("email", email);
    }

    public static void setEmail(String email) {
        pref.set("email", email);
    }

    public static String getPassowrd() {
        return pref.get("passowrd", password);
    }

    public static void setPassowrd(String passowrd) {
        pref.set("passowrd", passowrd);
    }

    public static String getPicture() {
        return pref.get("picture", picture);
    }

    public static void setPicture(String picture) {
        pref.set("picture", picture);
    }
}
