/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entites.Domaine;
import java.util.ArrayList;
import services.serviceDomaine;
import services.userService;

/**
 *
 * @author louay
 */
public class UserProfile extends Form {

    private Resources theme;
    Form current;

    public UserProfile(Form previous) {
        setTitle("My profile");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

        Button editProfile = new Button("Edit");
        editProfile.getStyle().setBgColor(0xffffff);
        editProfile.getStyle().setFgColor(0x8E7CC3);
        editProfile.getStyle().setBgTransparency(255);
        editProfile.getStyle().setBorder(Border.createRoundBorder(30, 30));
        editProfile.getStyle().setPadding(1, 1, 1, 1);
        editProfile.getStyle().setMargin(2, 2, 2, 2);
        editProfile.addActionListener((l) -> {
            // go to edit profile form
            new EditProfile(previous).show();
        });

        Button deleteProfile = new Button("Delete");
        deleteProfile.getStyle().setBgColor(0xffffff);
        deleteProfile.getStyle().setFgColor(0xA64D79);
        deleteProfile.getStyle().setBgTransparency(255);
        deleteProfile.getStyle().setBorder(Border.createRoundBorder(30, 30));
        deleteProfile.getStyle().setPadding(1, 1, 1, 1);
        deleteProfile.getStyle().setMargin(2, 2, 2, 2);
        deleteProfile.addActionListener((l) -> {
            userService.getInstance().deleteProduct(SessionManager.getId());
            if (userService.getInstance().deleteProduct(SessionManager.getId())) {
                Dialog.show("Success", "User deleted", "OK", null);
                refreshTheme();
                new Login(theme).show();
                refreshTheme();
            }
        });

        Label firstName = new Label("Nom: " + SessionManager.getFirstName());
        firstName.getAllStyles().setFgColor(0xffffff);

        Label lastName = new Label("Prenom: " + SessionManager.getLastName());
        lastName.getAllStyles().setFgColor(0xffffff);

        Label email = new Label("Email: " + SessionManager.getEmail());
        email.getAllStyles().setFgColor(0xffffff);

        Label gender = new Label("Gender: " + SessionManager.getGender());
        gender.getAllStyles().setFgColor(0xffffff);

        Label role = new Label("role: " + SessionManager.getRoles());

        String roles = "";
        if (role.getText().contains("CLIENT")) {
            roles = "Client";
        }
        if (role.getText().contains("TUTOR")) {
            roles = "Formateur";
        }
        if (role.getText().contains("ADMIN")) {
            roles = "Admin";
        }

        Label rolesLabel = new Label("role: " + roles);
        rolesLabel.getAllStyles().setFgColor(0xffffff);

        Container post = BoxLayout.encloseX(
                GridLayout.encloseIn(2, firstName, lastName));
        Container post2 = BoxLayout.encloseY(
                GridLayout.encloseIn(1, email));
        Container post3 = BoxLayout.encloseY(
                GridLayout.encloseIn(1, gender));
        Container post4 = BoxLayout.encloseY(
                GridLayout.encloseIn(1, rolesLabel));

        Container first = GridLayout.encloseIn(1, editProfile);
        Container second = GridLayout.encloseIn(1, deleteProfile);
        Container pub = BoxLayout.encloseY(
                BoxLayout.encloseY(post, post2, post3, post4, first, second)
        );

        pub.getStyle().setFgColor(0xffffff);
        pub.getStyle().setBgColor(0xCFE2F3);
        pub.getStyle().setBgTransparency(255);
        pub.getStyle().setPadding(7, 7, 7, 7);
        pub.getStyle().setMargin(20, 20, 30, 30);
        pub.getStyle().setBorder(Border.createRoundBorder(50, 50));

        add(pub);
    }

}
