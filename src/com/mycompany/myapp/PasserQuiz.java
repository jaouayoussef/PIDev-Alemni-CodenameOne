/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.HomeForm;
import services.ServiceQuestion;
import services.ServiceQuiz;
import java.util.ArrayList;

/**
 *
 * @author LEGION
 */
public class PasserQuiz extends Form {
   
       public PasserQuiz(Form previous , ArrayList<Question> quest , int i , int quizid) {
         int j = i+1;
        setTitle("Passer Quiz");
        setLayout(BoxLayout.y());
       
     
        Form current = new Form(quest.get(i).getLibelle(), BoxLayout.y());
        
        ButtonGroup bg = new ButtonGroup();
RadioButton option1 = RadioButton.createToggle(quest.get(i).getReponse1(), bg);
RadioButton option2 = RadioButton.createToggle(quest.get(i).getReponse2(), bg);
RadioButton option3 = RadioButton.createToggle(quest.get(i).getReponse3(), bg);
RadioButton option4 = RadioButton.createToggle(quest.get(i).getReponse4(), bg);
current.addAll(new Countdown(20, new Countdown.Callback() {
            @Override
            public void done() {
                Useranswer usr = new Useranswer();
                usr.setId_question(quest.get(i).getId());
                usr.setId_quiz(quizid);
                usr.setId_user(1);
                usr.setRep_correct(0);
              ServiceQuestion.getInstance().addAnswer(usr);
                if (j<20){
                new PasserQuiz(current, quest , j, quizid).show();
                }else{
                String stri = ServiceQuestion.getInstance().calculScore(1, quizid);
                 new Finaly(stri).show();
                }
              // callback
            }
        }),option1, option2, option3,option4);

bg.addActionListener((e) ->{ 
        
         Useranswer usr = new Useranswer();
                usr.setId_question(quest.get(i).getId());
                usr.setId_quiz(quizid);
                usr.setId_user(1);
                usr.setRep_correct(bg.getSelectedIndex() + 1);
              ServiceQuestion.getInstance().addAnswer(usr);
               if (j<20){
              new PasserQuiz(current, quest , j, quizid).show();}
               else {
                   String stri = ServiceQuestion.getInstance().calculScore(1, quizid);
                 new Finaly(stri).show();
               }
        
      });

    

        addAll(current);

     
      
       
    }
    
    
}
