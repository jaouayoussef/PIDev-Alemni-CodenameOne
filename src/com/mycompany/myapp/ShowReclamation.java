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
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import services.ServiceCodePromoOwner;
import com.mycompany.myapp.entites.PromoCodeOwner;
import com.mycompany.myapp.entites.reclamation;
import services.serviceReclamation;

/**
 *
 * @author Mohamed
 */
public class ShowReclamation extends Form {

    private Resources theme;

    public ShowReclamation(Form previous) {
        setTitle("List réclamations");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

        ArrayList<reclamation> PromoCodeOwners = serviceReclamation.getInstance().showReclamations();

        for (reclamation d : PromoCodeOwners) {

            Button editPost = new Button("Modifier");
            editPost.getStyle().setBgColor(0xffffff);
            editPost.getStyle().setFgColor(0x8E7CC3);
            editPost.getStyle().setBgTransparency(255);
            editPost.getStyle().setBorder(Border.createRoundBorder(30, 30));
            editPost.getStyle().setPadding(1, 1, 1, 1);
            editPost.getStyle().setMargin(2, 2, 2, 2);
            editPost.addActionListener((l) -> {
                new EditReclamation(previous, d).show();
            });

            Button deletePost = new Button("Supprimer");
            deletePost.getStyle().setBgColor(0xffffff);
            deletePost.getStyle().setFgColor(0xA64D79);
            deletePost.getStyle().setBgTransparency(255);
            deletePost.getStyle().setBorder(Border.createRoundBorder(30, 30));
            deletePost.getStyle().setPadding(1, 1, 1, 1);
            deletePost.getStyle().setMargin(2, 2, 2, 2);
            deletePost.addActionListener((l) -> {
                serviceReclamation.getInstance().deleteProduct(d.getId());
                if (serviceReclamation.getInstance().deleteProduct(d.getId())) {
                    Dialog.show("Success", "Reclamation supprimé avec succès !", "OK", null);
                    new ShowReclamation(previous).show();
                    refreshTheme();
                }
            });

            Label titre = new Label("Titre: " + d.getTitre());
            titre.getAllStyles().setFgColor(0x000000);

            Label name = new Label("Name : " + d.getName());
            name.getAllStyles().setFgColor(0x000000);

            Label email = new Label("Email : " + d.getEmail());
            email.getAllStyles().setFgColor(0x000000);

            Label message = new Label("Message : " + d.getMessage());
            message.getAllStyles().setFgColor(0x000000);

            Label type = new Label("Type : " + d.getType());
            type.getAllStyles().setFgColor(0x000000);

            Form hi = new Form(d.getName() + " " + d.getEmail(), new BoxLayout(BoxLayout.Y_AXIS));
            hi.add(titre).
                    add(message).
                    add(type).add(editPost).add(deletePost);
            Container pub = BoxLayout.encloseY(
                    BoxLayout.encloseY(hi)
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

}
