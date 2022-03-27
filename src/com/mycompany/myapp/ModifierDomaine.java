/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.myapp.entites.Domaine;
import services.serviceDomaine;
import java.io.IOException;

/**
 *
 * @author pc
 */
public class ModifierDomaine  extends Form{
     public ModifierDomaine(Form previous, Domaine d) {
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
                                new Label("Edit post", "Title")
                        )
                )
        );

        tb.setTitleComponent(titleCmp);

        TextField titre = new TextField(d.getNomDomaine(), "Nom ...");
        titre.getStyle().setBgColor(0xffffff);
        titre.getStyle().setFgColor(0x000000);
        titre.getStyle().setBorder(Border.createRoundBorder(50, 50));
        //titre.getStyle().setElevation(1);
        titre.getStyle().setPadding(3, 3, 0, 0);
        titre.getStyle().setUnderline(false);

        TextField description = new TextField(d.getDescriptionDomaine(), "description...");
        description.getStyle().setBgColor(0xffffff);
        description.getStyle().setFgColor(0x000000);
        description.getStyle().setBorder(Border.createRoundBorder(50, 50));
       // description.getStyle().setElevation(1);
        description.getStyle().setPadding(3, 3, 0, 0);
        description.getStyle().setUnderline(false);
         Label lbImage = new Label();
        Button btImg = new Button("Changer IMAGE");
      

        Button addPub = new Button("Edit");
        addPub.getStyle().setBgColor(0xffffff);
        addPub.getStyle().setFgColor(0x0583D2);
        addPub.getStyle().setBgTransparency(255);
        addPub.getStyle().setBorder(Border.createRoundBorder(30, 30));
        addPub.getStyle().setMargin(13, 13, 80, 80);
        addPub.getStyle().setPadding(3, 3, 0, 0);
        String imageLink = "http://127.0.0.1:8000/uploads/domaine/"+d.getImageDomaine();
         EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth() / 2, this.getHeight() / 5, 0xffff0000), true);
            Image im = URLImage.createToStorage(placeholder, imageLink, imageLink);
            ImageViewer image1 = new ImageViewer(im.scaled(250, 200));
        Container pub = BoxLayout.encloseY(
                BorderLayout.center(
                        BoxLayout.encloseY(
                                titre, description,lbImage,btImg,image1, addPub
                        )
                )
        );
        pub.getStyle().setPadding(70, 70, 40, 40);
        
          
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
        add(pub);

        addPub.addActionListener(l -> {
            if (titre.getText().equals("") || description.getText().equals("") ) {
                Dialog.show("Error", "Veuillez vérifier les données", "OK", null);
            } else {
                InfiniteProgress ip = new InfiniteProgress();
                final Dialog iDialog = ip.showInfiniteBlocking();

                d.setNomDomaine(titre.getText());
                d.setDescriptionDomaine(description.getText());
                if(lbImage.getName()== "Image"){
                     d.setImageDomaine("img");
                }
               

               serviceDomaine.getInstance().editDom(d);
                iDialog.dispose();
                new ListDomaines(previous).show();
                refreshTheme();
            }
        });

     }
    
}
