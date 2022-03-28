/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.myapp;

import com.mycompany.myapp.entites.Domaine;
import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
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
import com.mycompany.myapp.entites.reclamation;
import services.serviceDomaine;
import java.io.IOException;
import java.util.Vector;
import services.serviceReclamation;

/**
 *
 * @author pc
 */
public class AjoutReclamation extends Form {

    public AjoutReclamation(Form previous) {
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
                                new Label("Ajouter reclamation", "Title")
                        )
                )
        );

        tb.setTitleComponent(titleCmp);

        TextField titre = new TextField("", "Titre ...");
        titre.getStyle().setBgColor(0xffffff);
        titre.getStyle().setFgColor(0x000000);
        titre.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //titre.getStyle().setElevation(1);
        titre.getStyle().setPadding(3, 3, 0, 0);
        titre.getStyle().setUnderline(false);

        TextField message = new TextField("", "Message ...");
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

        TextField name = new TextField("", "name...");
        name.getStyle().setBgColor(0xffffff);
        name.getStyle().setFgColor(0x000000);
        name.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //description.getStyle().setElevation(1);
        name.getStyle().setPadding(3, 3, 0, 0);
        name.getStyle().setUnderline(false);

        TextField email = new TextField("", "email...");
        email.getStyle().setBgColor(0xffffff);
        email.getStyle().setFgColor(0x000000);
        email.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //description.getStyle().setElevation(1);
        email.getStyle().setPadding(3, 3, 0, 0);
        email.getStyle().setUnderline(false);

        TextField userFile = new TextField("", "image...");
        userFile.getStyle().setBgColor(0xffffff);
        userFile.getStyle().setFgColor(0x000000);
        userFile.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //description.getStyle().setElevation(1);
        userFile.getStyle().setPadding(3, 3, 0, 0);
        userFile.getStyle().setUnderline(false);

        /*Label lbImage = new Label();
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
        });*/
        Button addPub = new Button("Ajouter");
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

                reclamation d = new reclamation(titre.getText(), message.getText(), roles.getSelectedItem(), name
                        .getText(),
                         email.getText(),
                         userFile.getText()
                );
                serviceReclamation.getInstance().addReclamation(d);
                Dialog.show("succé", "reclamation envoyé avec succé", "ok", "cancel");
            }
            new ShowReclamation(previous).show();
            refreshTheme();

        });
        /*setTitle("Ajouter Domaine");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("back",FontImage.MATERIAL_BACKUP, ev->{new HomeForm().show();});
        Label lbNom = new Label("Nom");
        TextField Nom =  new TextField("","Nom");
        Label lbDescription = new Label("Description");
        TextField Description =  new TextField("","Description");
        Label lbImage = new Label();
        
        String path1 = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
            if(path1!= null){
                try {
                    Image img =Image.createImage(path1);
                    lbImage.setIcon(img);
                    lbImage.setName("Image");
                    revalidate();
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                }
            }
        Button btImg = new Button(" IMAGE");
        Button btAjouter = new Button("Ajouter");
        addAll(lbNom,Nom,lbDescription,Description,lbImage,btImg,btAjouter);
         btImg.addActionListener((e)->{
            String path = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
            if(path!= null){
                try {
                    Image img =Image.createImage(path);
                    lbImage.setIcon(img);
                    lbImage.setName("Image");
                    revalidate();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btAjouter.addActionListener((e)->{
            
            if(Nom.getText().isEmpty()||Description.getText().isEmpty()|| lbImage.getName()!= "Image"){
           Dialog.show("error", "Nom ou Description ou Image vide", "ok","cancel");
         }  
         else{
               //String img = serviceDomaine.getInstance().addImage(lbImage.toImage());
                Domaine d = new Domaine(Nom.getText(),Description.getText(),"img");
                serviceDomaine.getInstance().addDomaine(d);
                Dialog.show("succé","domaine ajouté avec succé", "ok","cancel");
            }
        });*/

    }

}
