/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.Formation;
import com.mycompany.myapp.Question;
import com.mycompany.myapp.Quiz;
import com.mycompany.myapp.Useranswer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LEGION
 */
public class ServiceQuestion {
       private ConnectionRequest req;
           public ArrayList<Formation> categories;
           public ArrayList<Question> questions;
              public ArrayList<Question> quest;
            public static ServiceQuestion instance=null;
            
                private ServiceQuestion() {
         req = new ConnectionRequest();
    }

    public static ServiceQuestion getInstance() {
        if (instance == null) {
            instance = new ServiceQuestion();
        }
        return instance;
    }
     public void addQuestion(Question question) {
//id mtaa user khallitou statique lyn tsir l'intégration
        
        String url = Statics.BASE_URL + "/mobile/addquestion?user_id=" + question.getId_user()+ "&libelle=" + question.getLibelle() + "&reponse1=" + question.getReponse1() + "&reponse2=" + question.getReponse2() + "&reponse3=" + question.getReponse3() + "&reponse4=" + question.getReponse4() + "&repcorrect=" + question.getRepcorrect();
        req.setUrl(url);
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }
     
           public ArrayList<Formation> parseTasks(String jsonText){
        try {
            categories =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Formation t = new Formation();
                
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                
                t.setNom(obj.get("nomFormation").toString()); 
                
                 
                categories.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return categories;
    } 
               public ArrayList<Question> getAllQuestion(int j){
           
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/mobile/getquestions/"+j;
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                questions = parseTasks1(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return questions;
    }
      public ArrayList<Question> parseTasks1(String jsonText){
        try {
            quest =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Question q = new Question();
                
                float id = Float.parseFloat(obj.get("id").toString());
                q.setId((int)id);
                
                q.setLibelle(obj.get("libelle").toString()); 
                q.setReponse1(obj.get("reponse1").toString()); 
                q.setReponse2(obj.get("reponse2").toString()); 
                 q.setReponse3(obj.get("reponse3").toString()); 
                  q.setReponse4(obj.get("reponse4").toString()); 
                  float rep = Float.parseFloat(obj.get("repcorrect").toString());
             q.setRepcorrect((int)rep);
             
                 
                quest.add(q);
            }
            
            
        } catch (IOException ex) {
            
        }
        return quest;
    } 
      
       public void addAnswer(Useranswer answer) {
//id mtaa user khallitou statique lyn tsir l'intégration
        
        String url = Statics.BASE_URL + "/mobile/addusrrep?id_user=" + answer.getId_user()+ "&id_question=" + answer.getId_question()+ "&id_quiz=" + answer.getId_quiz() + "&rep_correct=" + answer.getRep_correct(); 
         req.setUrl(url);
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }
       public String calculScore(int user , int quiz) {
             String url = Statics.BASE_URL + "/mobile/score/"+user+"/"+quiz;
              req.setUrl(url);
              
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
            
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
        return    new String(req.getResponseData());
       }
}
