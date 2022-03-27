/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.HomeForm;
import services.ServiceQuiz;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class Finaly extends Form {
        public Finaly(String f) {
         
        setTitle("Quiz terminé");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("back",FontImage.MATERIAL_BACKUP, ev->{new HomeForm().show();});
        Label lbQuestion = new Label(f);
      Label question = new Label("merci pour votre participation");
Label cmb = new Label("veuillez consulter votre boite email");
        Button btAjouter = new Button("retour");


        addAll(lbQuestion,question,cmb,btAjouter);
btAjouter.addActionListener((e)->{
               new HomeForm().show();
});
   
      
       
    }
    
    
}
