/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Mohamed
 */
public class ListCodePromoOwner extends Form {
         private Resources theme;
            private String notePromoCodeOwner = "Pas de description";

    public ListCodePromoOwner (Form previous){
        setTitle("List propriétaire code promo");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        ArrayList<PromoCodeOwner> PromoCodeOwners = ServiceCodePromoOwner.getInstance().getAllPromoCodeOwners();
        
        for (PromoCodeOwner d : PromoCodeOwners) {
      
       
    Button editPost = new Button("Modifier");
            editPost.getStyle().setBgColor(0xffffff);
            editPost.getStyle().setFgColor(0x8E7CC3);
            editPost.getStyle().setBgTransparency(255);
            editPost.getStyle().setBorder(Border.createRoundBorder(30, 30));
            editPost.getStyle().setPadding(1, 1, 1, 1);
            editPost.getStyle().setMargin(2, 2, 2, 2);
            editPost.addActionListener((l) -> {
                new ModifierPromocodeOwner(previous,d).show();
            });

           

          

            Button deletePost = new Button("Supprimer");
            deletePost.getStyle().setBgColor(0xffffff);
            deletePost.getStyle().setFgColor(0xA64D79);
            deletePost.getStyle().setBgTransparency(255);
            deletePost.getStyle().setBorder(Border.createRoundBorder(30, 30));
            deletePost.getStyle().setPadding(1, 1, 1, 1);
            deletePost.getStyle().setMargin(2, 2, 2, 2);
            deletePost.addActionListener((l) -> {
               ServiceCodePromoOwner.getInstance().deletepromocodeowner(d.getId());
                if (ServiceCodePromoOwner.getInstance().deletepromocodeowner(d.getId())) {
                    Dialog.show("Success", "Propriétaire code promotion supprimé avec succès !", "OK", null);
                    new ListCodePromoOwner(previous).show();
                    refreshTheme();
                }
            });

       

            //Label nom = new Label("Nom : " + d.getPCD_Name()+" "+ d.getPCD_FirstName());
           // nom.getAllStyles().setFgColor(0xffffff);

            Label email = new Label("Email: " + d.getPCD_Email());
            email.getAllStyles().setFgColor(0x000000);

            Label job = new Label("Srofession : " + d.getPCD_Job());
            job.getAllStyles().setFgColor(0x000000);
           
            Label Numtel = new Label("Numéro de téléphone : " + d.getPCD_TelephoneNumber());
            Numtel.getAllStyles().setFgColor(0x000000);
            
            Label gender = new Label("Sexe : " + d.getPCD_Gender());
            gender.getAllStyles().setFgColor(0x000000);
            
            Label city = new Label("Ville : " + d.getPCD_City());
            city.getAllStyles().setFgColor(0x000000);
            if (d.getPCD_Note() == "" || d.getPCD_Note() == null){
              notePromoCodeOwner = "Pas de description";
            }else {
                notePromoCodeOwner = d.getPCD_Note();
            }
                        System.out.println(notePromoCodeOwner);

            Label note = new Label("Description : " + notePromoCodeOwner);
            note.getAllStyles().setFgColor(0x000000);
            Form hi = new Form( d.getPCD_Name()+" "+ d.getPCD_FirstName(), new BoxLayout(BoxLayout.Y_AXIS));
hi.add(email).
    add(job).
    add(Numtel).
    add(gender).
    add(city).
    add(note).add(editPost).add(deletePost)
        ;
            /*Container post = BoxLayout.(
                    GridLayout.encloseIn(2, nom));
            Container post2 = BoxLayout.encloseX(
                    GridLayout.encloseIn(2, email));
              Container post3 = BoxLayout.encloseX(
                    GridLayout.encloseIn(2, job));
            Container post4 = BoxLayout.encloseX(
                    GridLayout.encloseIn(2, Numtel));
              Container post5 = BoxLayout.encloseX(
                    GridLayout.encloseIn(2, gender));
            Container post6 = BoxLayout.encloseX(
                    GridLayout.encloseIn(2, city));
              Container post7 = BoxLayout.encloseX(
                    GridLayout.encloseIn(2, note));
              */
          // Container first = GridLayout.encloseIn(2, editPost);
          //  Container second = GridLayout.encloseIn(2, deletePost);
            Container pub = BoxLayout.encloseY(
                 //  BorderLayout.centerAbsolute(
                      //      BoxLayout.encloseY(
                     //           image
                     //   )
               // ),//.add(BorderLayout.WEST, pubImage),
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
