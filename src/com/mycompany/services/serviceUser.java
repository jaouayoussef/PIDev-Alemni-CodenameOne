/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.statics.statics;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author louay
 */
public class serviceUser {
    
    public static serviceUser instance = null;
    
    public static boolean resultOK = true;
    String json;
    
    private ConnectionRequest req;
    
    public static serviceUser getInstance() {
        if (instance == null) {
            instance = new serviceUser();
        }
        return instance;
    }
    
    public serviceUser() {
        req = new ConnectionRequest();
    }
    
    public void SignUp(TextField first_name, TextField last_name, TextField email, TextField password, TextField confirmPassword, TextField picture, ComboBox roles, ComboBox gender, Resources res) {
        
        String url = statics.Base_URL + "/mobile/user/register?email="
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
        }
        
        req.addResponseListener((e) -> {
            byte[] data = (byte[]) e.getMetaData();
            String responseData = new String(data);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    }
    
    public void SignIn(TextField email, TextField password, Resources res) {
        String url = statics.Base_URL + "/mobile/user/login?email="
                + email.getText().toString()
                + "&password=" + password.getText().toString();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            JSONParser j = new JSONParser();
            String json = new String(req.getResponseData()) + "";
            try {
                if (json.equals("no user with such email")) {
                    Dialog.show("Error", "no user found", "OK", null);
                } else {
                    Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    if (user.size() > 0) {
                        Dialog.show("Success", "Welcome", "OK", null);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    public String getPasswordByEmail(String email, Resources res) {
        String url = statics.Base_URL + "/mobile/user/password?email=" + email;
        req = new ConnectionRequest(url, false);
        req.setUrl(url);
        
        req.addResponseListener((e) -> {
            JSONParser j = new JSONParser();
            String json = new String(req.getResponseData()) + "";
            try {
                
                Map<String, Object> password = j.parseJSON(new CharArrayReader(json.toCharArray()));
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return json;
    }
    
}
