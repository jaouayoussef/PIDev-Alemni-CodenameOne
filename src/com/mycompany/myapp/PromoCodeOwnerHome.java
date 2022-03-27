/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

/**
 *
 * @author Mohamed
 */
    public class PromoCodeOwnerHome extends Form {
    Form current;
    public PromoCodeOwnerHome(){
        current=this;
        setTitle("Alemni");
        setLayout(BoxLayout.y());
         getToolbar().addCommandToSideMenu("Propriétaire code promo", null, ev->{new PromoCodeOwnerHome().show();});        
        getToolbar().addCommandToSideMenu("Domaine", null, ev->{new DomaineHome().show();});
           getToolbar().addCommandToSideMenu("Quiz", null, ev->{new quizHome().show();});
  Button btAjouter = new Button("Ajouter"); 
            btAjouter.getStyle().setBgColor(0xffffff);
            btAjouter.getStyle().setFgColor(0x0080FF);
            btAjouter.getStyle().setBgTransparency(255);
            btAjouter.getStyle().setBorder(Border.createRoundBorder(30, 30));
            btAjouter.getStyle().setPadding(1, 1, 1, 1);
            btAjouter.getStyle().setMargin(2, 2, 2, 2);
  Button btshow = new Button("Propriétaires"); 
btshow.getStyle().setBgColor(0xffffff);
            btshow.getStyle().setFgColor(0x0080FF);
            btshow.getStyle().setBgTransparency(255);
            btshow.getStyle().setBorder(Border.createRoundBorder(30, 30));
            btshow.getStyle().setPadding(1, 1, 1, 1);
            btshow.getStyle().setMargin(2, 2, 2, 2);
  btAjouter.addActionListener((e)->{
  new AjouterPromoCodeOwner(current).show();
  });
  btshow.addActionListener((e)->{
    new ListCodePromoOwner(current).show();
  });
Form hi = new Form("Propriétaire code promo", new BoxLayout(BoxLayout.Y_AXIS));
hi.add(btAjouter).
    add(btshow);
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
