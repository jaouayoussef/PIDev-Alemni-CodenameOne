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
import com.mycompany.myapp.Quiz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LEGION
 */
public class ServiceQuiz {
       private ConnectionRequest req;
           public ArrayList<Formation> categories;
            public ArrayList<Formation> reserve;
            public ArrayList<Quiz> quiz;
            public static ServiceQuiz instance=null;
            
                private ServiceQuiz() {
         req = new ConnectionRequest();
    }

    public static ServiceQuiz getInstance() {
        if (instance == null) {
            instance = new ServiceQuiz();
        }
        return instance;
    }
     public void addQuiz(Quiz quiz) {
//id mtaa user khallitou statique lyn tsir l'intégration
        
        String url = Statics.BASE_URL + "/mobile/addquiz?name=" + quiz.getName()+ "&id_formation=" + quiz.getId_formation()+ "&id_user=" + quiz.getId_user();
        req.setUrl(url);
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }
       public ArrayList<Formation> getAllFormation(){
           
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/mobile/getformation/1";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                categories = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return categories;
    }
       public ArrayList<Quiz> getAllFormationReserver(){
           
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"/mobile/getformationinscrit/1";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                quiz = parseTasks1(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return quiz;
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
    } //
        public ArrayList<Quiz> parseTasks1(String jsonText){
        try {
            quiz =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Quiz t = new Quiz();
                
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                
                t.setName(obj.get("name").toString()); 
                
                 
                quiz.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return quiz;
    } //
     
}
