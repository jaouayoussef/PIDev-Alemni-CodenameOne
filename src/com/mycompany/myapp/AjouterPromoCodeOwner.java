/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;
import com.codename1.capture.Capture;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.plaf.Border;
import static java.lang.Integer.parseInt;
import services.ServiceCodePromoOwner;

/**
 *
 * @author Mohamed
 */
public class AjouterPromoCodeOwner extends Form{
    
    public AjouterPromoCodeOwner(Form previous) {
        setTitle("Ajouter propriétaire code promo");
        setLayout(BoxLayout.y());
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        Label lbNom = new Label("Nom");
        TextField Nom =  new TextField("","Nom");
        
        Label lbPrénom = new Label("Prénom");
        TextField Prénom =  new TextField("","Prénom");
        
        Label lbAddresseEmail = new Label("Addresse email ");
        TextField AddresseEmail =  new TextField("","Addresse email");
        
     
        Label lbProfession = new Label("Profession");
        TextField Profession =  new TextField("","Profession");
        
        Label lbNuméroTéléphone = new Label("Numéro de téléphone");
        TextField NuméroTéléphone =  new TextField("","Numéro de téléphone");
        
        Label lbSexe = new Label("Sexe");

        ComboBox<String> listsexe = new ComboBox<>();
        
        listsexe.addItem("Homme");
        listsexe.addItem("Femme");
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
        listville.getStyle().setBgColor(0xffffff);
        listville.getStyle().setFgColor(0x0583D2);
        listville.getStyle().setBgTransparency(255);
        listville.getStyle().setBorder(Border.createRoundBorder(30, 30));
        listville.getStyle().setPadding(3, 3, 0, 0);

        
         Label lbDescription = new Label("description");
        TextField Description =  new TextField("","description");
        
        Button btAjouter = new Button("Ajouter");
        btAjouter.getStyle().setBgColor(0xffffff);
        btAjouter.getStyle().setFgColor(0x0583D2);
        btAjouter.getStyle().setBgTransparency(255);
        btAjouter.getStyle().setBorder(Border.createRoundBorder(30, 30));
        btAjouter.getStyle().setMargin(13, 13, 80, 80);
        btAjouter.getStyle().setPadding(3, 3, 0, 0);
        addAll(lbNom,Nom,lbPrénom,Prénom,lbAddresseEmail,AddresseEmail,lbProfession,Profession,lbNuméroTéléphone,NuméroTéléphone,lbSexe,listsexe,lbVille,listville,lbDescription,Description,btAjouter);
         
        btAjouter.addActionListener((e)->{
            
            if(Nom.getText().isEmpty()||Prénom.getText().isEmpty()|| AddresseEmail.getText().isEmpty() || Profession.getText().isEmpty()|| NuméroTéléphone.getText().isEmpty()){
           Dialog.show("error", "Please fill all the fieds", "ok","cancel");
         }  
         else{ 
             
                    PromoCodeOwner t = new PromoCodeOwner(Nom.getText(), Prénom.getText(), AddresseEmail.getText(), Profession.getText(), listsexe.getSelectedItem(), listsexe.getSelectedItem(),Description.getText(),parseInt(NuméroTéléphone.getText()));
                    System.out.println(t);  
                    ServiceCodePromoOwner.getInstance().addCodePromoOwner(t);
                         Dialog.show("succé","Propriétaire code promotion supprimé avec succès", "ok","cancel");
            }
        });
       
      
       
    }
    
}
