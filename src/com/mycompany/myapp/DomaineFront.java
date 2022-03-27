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
import com.mycompany.myapp.entites.Domaine;
import services.serviceDomaine;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DomaineFront extends Form  {
     public DomaineFront(Form previous) {
        setTitle("Domaines disponible");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
         ArrayList<Domaine> domaines = serviceDomaine.getInstance().getDomaines();

        for (Domaine d : domaines) {

            String imageLink = "http://127.0.0.1:8000/uploads/domaine/"+d.getImageDomaine();
             System.out.println(imageLink);
            EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth() / 2, this.getHeight() / 5, 0xffff0000), true);
            Image im = URLImage.createToStorage(placeholder, imageLink, imageLink);
            ImageViewer image = new ImageViewer(im.scaled(250, 200));

       

      

          

     

         

            Label titre = new Label("Nom Domaine: " + d.getNomDomaine());
            titre.getAllStyles().setFgColor(0xffffff);

            Label description = new Label("Description: " + d.getDescriptionDomaine());
            description.getAllStyles().setFgColor(0xffffff);

           
            Container post = BoxLayout.encloseY(
                    GridLayout.encloseIn(2, titre));
            Container post2 = BoxLayout.encloseY(
                    GridLayout.encloseIn(2, description));
           
            Container pub = BoxLayout.encloseY(
                    BorderLayout.centerAbsolute(
                            BoxLayout.encloseY(
                                    image
                            )
                    ),//.add(BorderLayout.WEST, pubImage),
                    BoxLayout.encloseY(post,post2)
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
