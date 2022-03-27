/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entites.Domaine;
import services.serviceDomaine;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class ListDomaines extends Form {
     private Resources theme;
    
     public ListDomaines(Form previous) {
        setTitle("Listes Domaines");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
         ArrayList<Domaine> domaines = serviceDomaine.getInstance().getDomaines();

        for (Domaine d : domaines) {

            String imageLink = "http://127.0.0.1:8000/uploads/domaine/"+d.getImageDomaine();
             System.out.println(imageLink);
            EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth() / 2, this.getHeight() / 5, 0xffff0000), true);
            Image im = URLImage.createToStorage(placeholder, imageLink, imageLink);
            ImageViewer image = new ImageViewer(im.scaled(250, 200));

       

            Button editPost = new Button("Edit");
            editPost.getStyle().setBgColor(0xffffff);
            editPost.getStyle().setFgColor(0x8E7CC3);
            editPost.getStyle().setBgTransparency(255);
            editPost.getStyle().setBorder(Border.createRoundBorder(30, 30));
            editPost.getStyle().setPadding(1, 1, 1, 1);
            editPost.getStyle().setMargin(2, 2, 2, 2);
            editPost.addActionListener((l) -> {
                new ModifierDomaine(previous,d).show();
            });

          

            Button deletePost = new Button("Delete");
            deletePost.getStyle().setBgColor(0xffffff);
            deletePost.getStyle().setFgColor(0xA64D79);
            deletePost.getStyle().setBgTransparency(255);
            deletePost.getStyle().setBorder(Border.createRoundBorder(30, 30));
            deletePost.getStyle().setPadding(1, 1, 1, 1);
            deletePost.getStyle().setMargin(2, 2, 2, 2);
            deletePost.addActionListener((l) -> {
                serviceDomaine.getInstance().deleteDom(d.getId());
                if (serviceDomaine.getInstance().deleteDom(d.getId())) {
                    Dialog.show("Success", "Domaine deleted", "OK", null);
                    new ListDomaines(previous).show();
                    refreshTheme();
                }
            });

         

            Label titre = new Label("Nom Domaine: " + d.getNomDomaine());
            titre.getAllStyles().setFgColor(0xffffff);

            Label description = new Label("Description: " + d.getDescriptionDomaine());
            description.getAllStyles().setFgColor(0xffffff);

           
            Container post = BoxLayout.encloseY(
                    GridLayout.encloseIn(2, titre));
            Container post2 = BoxLayout.encloseY(
                    GridLayout.encloseIn(2, description));
           Container first = GridLayout.encloseIn(2, editPost);
            Container second = GridLayout.encloseIn(2, deletePost);
            Container pub = BoxLayout.encloseY(
                    BorderLayout.centerAbsolute(
                            BoxLayout.encloseY(
                                    image
                            )
                    ),//.add(BorderLayout.WEST, pubImage),
                    BoxLayout.encloseY(post,post2,first, second)
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
