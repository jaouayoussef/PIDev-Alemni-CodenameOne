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
import com.mycompany.myapp.PasserQuiz;
import com.mycompany.myapp.Question;
import com.mycompany.myapp.Quiz;
import services.ServiceQuestion;
import services.ServiceQuiz;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class Mesformations extends Form {
        public Mesformations(Form previous) {
         
        setTitle("Mes formations");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("back",FontImage.MATERIAL_BACKUP, ev->{new HomeForm().show();});
        Label lbQuestion = new Label("Selectionner la formation que vouys voulez passer son quiz");
        
ArrayList<Quiz> formations = ServiceQuiz.getInstance().getAllFormationReserver();
   ComboBox  cmb = new ComboBox<>();
    for (Quiz object : formations) {
            cmb.addItem(object.getName());
        }
        Button btPasser = new Button("Passer");


        addAll(lbQuestion,cmb,btPasser);

        btPasser.addActionListener((e)->{
          int j = cmb.getSelectedIndex();
          int l = formations.get(j).getId();
           
          ArrayList<Question> questions = ServiceQuestion.getInstance().getAllQuestion(l);
        
            new PasserQuiz(this, questions , 0 , l).show();

        });
       
      
       
    }
    
    
}
