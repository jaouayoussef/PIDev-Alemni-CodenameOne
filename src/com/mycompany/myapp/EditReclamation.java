/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.myapp.entites.reclamation;
import java.util.Vector;
import services.serviceReclamation;

/**
 *
 * @author pc
 */
public class EditReclamation extends Form {

    public EditReclamation(Form previous, reclamation d) {
        super(BoxLayout.y());

        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        FontImage.setMaterialIcon(menuButton, FontImage.MATERIAL_MENU);
        menuButton.addActionListener(e -> getToolbar().openSideMenu());

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label("Edit reclamation", "Title")
                        )
                )
        );

        tb.setTitleComponent(titleCmp);

        TextField titre = new TextField(d.getTitre(), "Nom ...");
        titre.getStyle().setBgColor(0xffffff);
        titre.getStyle().setFgColor(0x000000);
        titre.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //titre.getStyle().setElevation(1);
        titre.getStyle().setPadding(3, 3, 0, 0);
        titre.getStyle().setUnderline(false);

        TextField message = new TextField(d.getMessage(), "Message ...");
        message.getStyle().setBgColor(0xffffff);
        message.getStyle().setFgColor(0x000000);
        message.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //titre.getStyle().setElevation(1);
        message.getStyle().setPadding(3, 3, 0, 0);
        message.getStyle().setUnderline(false);

        Vector<String> vectorRole;
        vectorRole = new Vector();
        vectorRole.add("Compte");
        vectorRole.add("Formation");

        ComboBox<String> roles;
        roles = new ComboBox<>(vectorRole);

        TextField name = new TextField(d.getName(), "name...");
        name.getStyle().setBgColor(0xffffff);
        name.getStyle().setFgColor(0x000000);
        name.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //description.getStyle().setElevation(1);
        name.getStyle().setPadding(3, 3, 0, 0);
        name.getStyle().setUnderline(false);

        TextField email = new TextField(d.getEmail(), "email...");
        email.getStyle().setBgColor(0xffffff);
        email.getStyle().setFgColor(0x000000);
        email.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //description.getStyle().setElevation(1);
        email.getStyle().setPadding(3, 3, 0, 0);
        email.getStyle().setUnderline(false);

        TextField userFile = new TextField(d.getUser_file(), "image...");
        userFile.getStyle().setBgColor(0xffffff);
        userFile.getStyle().setFgColor(0x000000);
        userFile.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //description.getStyle().setElevation(1);
        userFile.getStyle().setPadding(3, 3, 0, 0);
        userFile.getStyle().setUnderline(false);

        Button addPub = new Button("Edit");
        addPub.getStyle().setBgColor(0xffffff);
        addPub.getStyle().setFgColor(0x0583D2);
        addPub.getStyle().setBgTransparency(255);
        addPub.getStyle().setBorder(Border.createRoundBorder(30, 30));
        addPub.getStyle().setMargin(13, 13, 80, 80);
        addPub.getStyle().setPadding(3, 3, 0, 0);

        Container pub = BoxLayout.encloseY(
                BorderLayout.center(
                        BoxLayout.encloseY(
                                titre, name, email, message, roles, userFile, addPub
                        )
                )
        );
        pub.getStyle().setPadding(70, 70, 40, 40);
        add(pub);

        addPub.addActionListener(l -> {
            if (titre.getText().equals("")) {
                Dialog.show("Error", "Veuillez vérifier les données", "OK", null);
            } else {
                InfiniteProgress ip = new InfiniteProgress();
                final Dialog iDialog = ip.showInfiniteBlocking();

                d.setTitre(titre.getText());
                d.setName(name.getText());
                d.setEmail(email.getText());
                d.setMessage(message.getText());
                d.setType(roles.getSelectedItem());
                d.setUser_file(userFile.getText());

                serviceReclamation.getInstance().editReclamation(d);
                iDialog.dispose();
                new ReclamationHome().show();
                refreshTheme();
            }
        });

    }

}
