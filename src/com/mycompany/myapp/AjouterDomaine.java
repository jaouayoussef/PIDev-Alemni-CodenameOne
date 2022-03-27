/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.mycompany.myapp.entites.Domaine;
import com.codename1.capture.Capture;
import com.codename1.components.InfiniteProgress;
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
import services.serviceDomaine;
import java.io.IOException;


/**
 *
 * @author pc
 */
public class AjouterDomaine extends Form {

    public AjouterDomaine(Form previous) {
         super(BoxLayout.y());

        Toolbar tb = getToolbar();
        tb.setTitleCentered(false);

        Button menuButton = new Button("");
        menuButton.setUIID("Title");
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());

        Container titleCmp = BoxLayout.encloseY(
                FlowLayout.encloseIn(menuButton),
                BorderLayout.centerAbsolute(
                        BoxLayout.encloseY(
                                new Label("Ajouter Domaine", "Title")
                        )
                )
        );

        tb.setTitleComponent(titleCmp);

        TextField titre = new TextField("", "Nom ...");
        titre.getStyle().setBgColor(0xffffff);
        titre.getStyle().setFgColor(0x000000);
        titre.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //titre.getStyle().setElevation(1);
        titre.getStyle().setPadding(3, 3, 0, 0);
        titre.getStyle().setUnderline(false);

        TextField description = new TextField("", "description...");
        description.getStyle().setBgColor(0xffffff);
        description.getStyle().setFgColor(0x000000);
        description.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //description.getStyle().setElevation(1);
        description.getStyle().setPadding(3, 3, 0, 0);
        description.getStyle().setUnderline(false);
        
        
        Label lbImage = new Label();
        Button btImg = new Button("Ajouter IMAGE");
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
                                titre, description,lbImage,btImg,addPub
                        )
                )
        );
        pub.getStyle().setPadding(70, 70, 40, 40);

        add(pub);

        addPub.addActionListener(l -> {
            if (titre.getText().equals("") || description.getText().equals("") || lbImage.getName()!= "Image") {
                Dialog.show("Error", "Veuillez vérifier les données", "OK", null);
            } else {
               

                Domaine d = new Domaine(titre.getText(),description.getText(),"img");
                serviceDomaine.getInstance().addDomaine(d);
                Dialog.show("succé","domaine ajouté avec succé", "ok","cancel");
            }
                new AjouterDomaine(previous).show();
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
