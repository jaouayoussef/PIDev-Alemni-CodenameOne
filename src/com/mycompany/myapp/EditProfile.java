/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.capture.Capture;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.myapp.entites.Domaine;
import com.mycompany.myapp.entites.user;
import java.io.IOException;
import services.serviceDomaine;
import services.userService;

/**
 *
 * @author louay
 */
public class EditProfile extends Form {

    public EditProfile(Form previous) {
        super(BoxLayout.y());

        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label("Edit Profile", "Title")
                        )
                )
        );

        tb.setTitleComponent(titleCmp);

        TextField firstName = new TextField(SessionManager.getFirstName(), "nom ...");
        firstName.getStyle().setBgColor(0xffffff);
        firstName.getStyle().setFgColor(0x000000);
        firstName.getStyle().setBorder(Border.createRoundBorder(50, 50));
        firstName.getStyle().setPadding(3, 3, 0, 0);
        firstName.getStyle().setUnderline(false);

        TextField lastName = new TextField(SessionManager.getLastName(), "prenom ...");
        lastName.getStyle().setBgColor(0xffffff);
        lastName.getStyle().setFgColor(0x000000);
        lastName.getStyle().setBorder(Border.createRoundBorder(50, 50));
        lastName.getStyle().setPadding(3, 3, 0, 0);
        lastName.getStyle().setUnderline(false);

        TextField password = new TextField("", "password...");
        password.getStyle().setBgColor(0xffffff);
        password.getStyle().setFgColor(0x000000);
        password.getStyle().setBorder(Border.createRoundBorder(50, 50));
        password.getStyle().setPadding(3, 3, 0, 0);
        password.getStyle().setUnderline(false);

        TextField confirmPassword = new TextField("", "confirmPassword...");
        confirmPassword.getStyle().setBgColor(0xffffff);
        confirmPassword.getStyle().setFgColor(0x000000);
        confirmPassword.getStyle().setBorder(Border.createRoundBorder(50, 50));
        confirmPassword.getStyle().setPadding(3, 3, 0, 0);
        confirmPassword.getStyle().setUnderline(false);

        Label lbImage = new Label();
        Button btImg = new Button("Ajouter IMAGE");
        btImg.addActionListener((e) -> {
            String path = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
            if (path != null) {
                try {
                    Image img = Image.createImage(path);
                    lbImage.setIcon(img);
                    lbImage.setName("Image");
                    revalidate();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Button addPub = new Button("Ajouter");
        addPub.getStyle().setBgColor(0xffffff);
        addPub.getStyle().setFgColor(0x0583D2);
        addPub.getStyle().setBgTransparency(255);
        addPub.getStyle().setBorder(Border.createRoundBorder(30, 30));
        addPub.getStyle().setMargin(13, 13, 80, 80);
        addPub.getStyle().setPadding(3, 3, 0, 0);

        addPub.addActionListener((l) -> {
            if (firstName.getText().equals("") || lastName.getText().equals("") || password.getText().equals("") || confirmPassword.getText().equals("")) {
                Dialog.show("Error", "Veuillez vérifier les données", "OK", null);
            } else {

                userService.getInstance().editUser(SessionManager.getId(), firstName.getText().toString(), lastName.getText().toString(), password.getText().toString());
                Dialog.show("succé", "user edited", "OK", null);
                new UserProfile(previous).show();
                refreshTheme();
                new UserProfile(previous).show();
                refreshTheme();
            }

        });

        Container pub = BoxLayout.encloseY(
                BorderLayout.center(
                        BoxLayout.encloseY(
                                firstName, lastName, password, confirmPassword, lbImage, btImg, addPub
                        )
                )
        );
        pub.getStyle().setPadding(70, 70, 40, 40);

        add(pub);

    }

}
