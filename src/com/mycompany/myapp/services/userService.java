/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.SessionManager;
import com.mycompany.myapp.utils.Statics;
import java.util.Map;

/**
 *
 * @author louay
 */
public class userService {

    public static userService instance = null;
    String json;
    private boolean resultat;

    private ConnectionRequest req;

    public static userService getInstance() {
        if (instance == null) {
            instance = new userService();
        }
        return instance;
    }

    public userService() {
        req = new ConnectionRequest();
    }

    public boolean SignUp(TextField first_name, TextField last_name, TextField email, TextField password, TextField confirmPassword, TextField picture, ComboBox roles, ComboBox gender, Resources res) {

        String url = Statics.BASE_URL + "/mobile/user/register?email="
                + email.getText().toString()
                + "&roles=" + roles.getSelectedItem().toString()
                + "&password=" + password.getText().toString()
                + "&first_name=" + first_name.getText().toString()
                + "&last_name=" + last_name.getText().toString()
                + "&gender=" + gender.getSelectedItem().toString()
                + "&picture=" + picture.getText().toString();

        req.setUrl(url);

        if (email.getText().equals(" ")) {
            Dialog.show("Error", "field can't be empty", "OK", null);
        } else {
            resultat = req.getResponseCode() == 200;
        }

        req.addResponseListener((e) -> {
            byte[] data = (byte[]) e.getMetaData();
            String responseData = new String(data);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultat;
    }

    public boolean SignIn(TextField email, TextField password, Resources res) {
        String url = Statics.BASE_URL + "/mobile/user/login?email="
                + email.getText().toString()
                + "&password=" + password.getText().toString();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            JSONParser j = new JSONParser();
            String json = new String(req.getResponseData()) + "";
            try {
                if (json.equals("no user with such email")) {
                    Dialog.show("Error", "no user found", "OK", null);
                } else if (json.equals("incorrect password")) {
                    Dialog.show("Error", "no user found", "OK", null);
                } else {
                    Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));

//session
                    float id = Float.parseFloat(user.get("id").toString());

                    SessionManager.setId((int) id);
                    SessionManager.setFirstName(user.get("firstName").toString());
                    SessionManager.setLastName(user.get("lastName").toString());
                    SessionManager.setEmail(user.get("email").toString());
                    SessionManager.setPassowrd(user.get("password").toString());
                    SessionManager.setGender(user.get("gender").toString());
                    SessionManager.setGender(user.get("role").toString());

                    //photo 
                    if (user.get("picture") != null) {
                        SessionManager.setPicture(user.get("picture").toString());
                    }

                    if (user.size() > 0) {
                        resultat = req.getResponseCode() == 200;
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultat;
    }
}
