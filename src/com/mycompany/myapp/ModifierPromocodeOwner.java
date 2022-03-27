/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.mycompany.myapp.entites.PromoCodeOwner;
import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import services.ServiceCodePromoOwner;
/**
 *
 * @author Mohamed
 */
public class ModifierPromocodeOwner extends Form {
        Form current;
String  num;
     public ModifierPromocodeOwner(Form previous, PromoCodeOwner d) {

           super(BoxLayout.y());
                 current=this;

        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label("Modifier propriétaire code promo", "Title")
                        )
                )
        );

        tb.setTitleComponent(titleCmp);
        Label lbNom = new Label("Nom");
        TextField nom = new TextField(d.getPCD_Name(), "Nom");
    
        
        Label lbPrénom = new Label("Prénom");
        TextField prenom = new TextField(d.getPCD_FirstName(), "Prénom");
       
        
        Label lbAddresseEmail = new Label("Addresse email ");
        TextField Email = new TextField(d.getPCD_Email(), "Emai");
        
                
     
        Label lbProfession = new Label("Profession");
        TextField Job = new TextField(d.getPCD_Job(), "Profession");
        
        
        Label lbNuméroTéléphone = new Label("Numéro de téléphone");
         num = Integer.toString(d.getPCD_TelephoneNumber());
         TextField numTel = new TextField( num, "Numero telephone");
       
        
 
        Label lbSexe = new Label("Sexe");

        ComboBox<String> listsexe = new ComboBox<>();
        
        listsexe.addItem("Homme");
        listsexe.addItem("Femme");
        listsexe.setSelectedItem(d.getPCD_Gender());
        listsexe.getStyle().setBgColor(0xffffff);
        listsexe.getStyle().setFgColor(0x0583D2);
        listsexe.getStyle().setBgTransparency(255);
        listsexe.getStyle().setBorder(Border.createRoundBorder(30, 30));
        listsexe.getStyle().setPadding(3, 3, 0, 0);
        
        Label lbVille = new Label("Ville");

         ComboBox<String> listville = new ComboBox<>();
        
        listville.addItem("Ariana");
        listville.addItem("Béja");        
        listville.addItem("Ben Arous");
        listville.addItem("Bizerte");
        listville.addItem("Gabès");
        listville.addItem("Gafsa");
        listville.addItem("Jendouba");
        listville.addItem("Kairouan");
        listville.addItem("Kasserine");
        listville.addItem("Kébili");
        listville.addItem("Kef");
        listville.addItem("Mahdia");
        listville.addItem("Manouba");
        listville.addItem("Médenine");
        listville.addItem("Monastir");
        listville.addItem("Nabeul");
        listville.addItem("Sfax");
        listville.addItem("Sidi Bouzid");
        listville.addItem("Siliana");
        listville.addItem("Sousse");
        listville.addItem("Tataouine");
        listville.addItem("Tozeur");
        listville.addItem("Tunis");
        listville.addItem("Zaghouan");
        listville.setSelectedItem(d.getPCD_City());
       listville.getStyle().setBgColor(0xffffff);
        listville.getStyle().setFgColor(0x0583D2);
        listville.getStyle().setBgTransparency(255);
        listville.getStyle().setBorder(Border.createRoundBorder(30, 30));
        listville.getStyle().setPadding(3, 3, 0, 0);

        
         Label lbDescription = new Label("description");
        TextField description = new TextField(d.getPCD_Note(), "description");
        
       
        
       
        
        
         
        
        
        
        
        
        
        
      
        
       // Label lbImage = new Label();
        //Button btImg = new Button("Changer IMAGE");
      

        Button addPub = new Button("Modifier");
        addPub.getStyle().setBgColor(0xffffff);
        addPub.getStyle().setFgColor(0x0583D2);
        addPub.getStyle().setBgTransparency(255);
        addPub.getStyle().setBorder(Border.createRoundBorder(30, 30));
        addPub.getStyle().setMargin(13, 13, 80, 80);
        addPub.getStyle().setPadding(3, 3, 0, 0);
        
        Container pub = BoxLayout.encloseY(
                BorderLayout.center(
                        BoxLayout.encloseY(
                               lbNom, nom,lbPrénom,prenom,lbAddresseEmail,Email,lbProfession,Job,lbNuméroTéléphone,numTel,lbSexe,listsexe,lbVille , listville,lbDescription,  description, addPub
                        )
                )
        );
        pub.getStyle().setPadding(70, 70, 40, 40);
        
          
                add(pub);


        addPub.addActionListener(l -> {
            if (nom.getText().equals("") || description.getText().equals("")|| listville.getSelectedItem().equals("")|| Email.getText().equals("")|| prenom.getText().equals("")|| listsexe.getSelectedItem().equals("") || Job.getText().equals("")) {
                Dialog.show("Error", "Veuillez vérifier les données", "OK", null);
            } else {
                InfiniteProgress ip = new InfiniteProgress();
                final Dialog iDialog = ip.showInfiniteBlocking();

                d.setPCD_City(listville.getSelectedItem());
                d.setPCD_Email(Email.getText());
                d.setPCD_FirstName(prenom.getText());
                d.setPCD_Gender(listsexe.getSelectedItem());
                d.setPCD_Job(Job.getText());
                d.setPCD_Name(nom.getText());
                d.setPCD_Note(description.getText());
                d.setPCD_TelephoneNumber(parseInt(numTel.getText()));

              

               ServiceCodePromoOwner.getInstance().editPromoCodeOwner(d);
                System.out.println(d);
                iDialog.dispose();
                new ListCodePromoOwner(previous).show();
                refreshTheme();
            }
        });

     }
    
}
