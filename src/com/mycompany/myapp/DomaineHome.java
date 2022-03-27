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
     public class DomaineHome extends Form {
    Form current;
    public DomaineHome(){
        current=this;
        setTitle("Alemni");
        setLayout(BoxLayout.y());
        getToolbar().addCommandToSideMenu("Propriétaire code promo", null, ev->{new PromoCodeOwnerHome().show();});        
        getToolbar().addCommandToSideMenu("Domaine", null, ev->{new DomaineHome().show();});
           getToolbar().addCommandToSideMenu("Quiz", null, ev->{new quizHome().show();});

         //  getToolbar().addCommandToSideMenu("Domaine", null, ev->{new AjouterDomaine(current).show();});
       // getToolbar().addCommandToSideMenu("Liste Domaine", null, e-> new ListDomaines(current).show());
       // getToolbar().addCommandToSideMenu("Domaine", null, e-> new DomaineFront(current).show());
  Button btAjouter = new Button("Ajouter"); 
            btAjouter.getStyle().setBgColor(0xffffff);
            btAjouter.getStyle().setFgColor(0x0080FF);
            btAjouter.getStyle().setBgTransparency(255);
            btAjouter.getStyle().setBorder(Border.createRoundBorder(30, 30));
            btAjouter.getStyle().setPadding(1, 1, 1, 1);
            btAjouter.getStyle().setMargin(2, 2, 2, 2);
  Button btshow = new Button("Domaines"); 
btshow.getStyle().setBgColor(0xffffff);
            btshow.getStyle().setFgColor(0x0080FF);
            btshow.getStyle().setBgTransparency(255);
            btshow.getStyle().setBorder(Border.createRoundBorder(30, 30));
            btshow.getStyle().setPadding(1, 1, 1, 1);
            btshow.getStyle().setMargin(2, 2, 2, 2);
              Button btshowDomaine = new Button("Domaines Front"); 
btshowDomaine.getStyle().setBgColor(0xffffff);
            btshowDomaine.getStyle().setFgColor(0x0080FF);
            btshowDomaine.getStyle().setBgTransparency(255);
            btshowDomaine.getStyle().setBorder(Border.createRoundBorder(30, 30));
            btshowDomaine.getStyle().setPadding(1, 1, 1, 1);
            btshowDomaine.getStyle().setMargin(2, 2, 2, 2);
  btAjouter.addActionListener((e)->{
  new AjouterDomaine(current).show();
  });
  btshow.addActionListener((e)->{
    new ListDomaines(current).show();
  });
  btshowDomaine.addActionListener((e)->{
    new DomaineFront(current).show();
  });
Form hi = new Form("Domaines", new BoxLayout(BoxLayout.Y_AXIS));
hi.add(btAjouter).
    add(btshow).add(btshowDomaine);
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
