/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.capture.Capture;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.HomeForm;
import com.mycompany.myapp.Question;
import services.ServiceQuestion;
import java.io.IOException;
import java.util.Map;


/**
 *
 * @author pc
 */
public class AjouterQuizQuestion extends Form {
 static int i =0;
    public AjouterQuizQuestion(Form previous) {
      
        setTitle("Ajouter Quiz");
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("back",FontImage.MATERIAL_BACKUP, ev->{new HomeForm().show();});
        int j = i+1;
        Label lbQuestion = new Label("Question " + j);
        TextField question =  new TextField("","Question");
        Label lbReponse1 = new Label("Réponse1");
        TextField reponse1 =  new TextField("","Réponse1");
        Label lbReponse2 = new Label("Réponse2");
        TextField reponse2 =  new TextField("","Réponse2");
        Label lbReponse3 = new Label("Réponse3");
        TextField reponse3 =  new TextField("","Réponse3");
        Label lbReponse4 = new Label("Réponse4");
        TextField reponse4 =  new TextField("","Réponse4");
        Label lbRepCorr = new Label("Réponse Correcte");

        ComboBox<String> list = new ComboBox<>();
        
        list.addItem("Réponse1");
        list.addItem("Réponse2");
           list.addItem("Réponse3");
              list.addItem("Réponse4");
        Button btAjouter = new Button("Ajouter");


        addAll(lbQuestion,question,lbReponse1,reponse1,lbReponse2,reponse2,lbReponse3,reponse3,lbReponse4,reponse4,lbRepCorr,list,btAjouter);

        btAjouter.addActionListener((e)->{
            
            if(question.getText().isEmpty()||reponse1.getText().isEmpty()||reponse1.getText().isEmpty()||reponse2.getText().isEmpty()||reponse3.getText().isEmpty()||reponse4.getText().isEmpty()){
           Dialog.show("error", "champ(s) vide(s)", "ok","cancel");
         }  
         else{
                Question quest = new Question();
                quest.setId_user(1);
                quest.setLibelle(question.getText());
                quest.setReponse1(reponse1.getText());
                quest.setReponse2(reponse2.getText());
                quest.setReponse3(reponse3.getText());
                quest.setReponse4(reponse4.getText());
                quest.setRepcorrect(list.getSelectedIndex()+1);
                ServiceQuestion.getInstance().addQuestion(quest);
                if (AjouterQuizQuestion.i<19){
                    i++;
                    new AjouterQuizQuestion(this).show();
                }
                else{
                    new HomeForm().show();
                    i=0;
                            
                }
               
            }
        });
       
      
       
    }
    
    
}
