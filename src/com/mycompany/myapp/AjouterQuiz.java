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
import com.mycompany.myapp.Quiz;
import services.ServiceQuiz;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class AjouterQuiz extends Form {
        public AjouterQuiz(Form previous) {
         
        setTitle("Ajouter Quiz");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        Label lbQuestion = new Label("Nom du quiz");
        TextField question =  new TextField("","Nom du quiz");
ArrayList<Formation> formations = ServiceQuiz.getInstance().getAllFormation() ;
   ComboBox  cmb = new ComboBox<>();
    for (Formation object : formations) {
            cmb.addItem(object.getNom());
        }
        Button btAjouter = new Button("Ajouter");


        addAll(lbQuestion,question,cmb,btAjouter);

        btAjouter.addActionListener((e)->{
            if (formations == null){
                Dialog.show("Attention", "Vous n'avez pas des formations");
                 return;
            }
            if(question.getText().isEmpty()){
             Dialog.show("error", "champ(s) vide(s)", "ok","cancel");
              return;
        }
           int j = cmb.getSelectedIndex();
           Formation f = formations.get(j);
           Quiz q = new Quiz();
           q.setId_formation(f.getId());
           q.setName(question.getText());
           q.setId_user(1);
            ServiceQuiz.getInstance().addQuiz(q);
            new AjouterQuizQuestion(this).show();

        });
       
      
       
    }
    
    
}
