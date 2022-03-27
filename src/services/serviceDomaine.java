/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entites.Domaine;
import Utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author pc
 */
public class serviceDomaine {
     public ArrayList<Domaine> domaines;
     public ArrayList<String> img;
    public boolean resultOK;
    private boolean resultat;
    public static serviceDomaine instance=null;
     private ConnectionRequest req;
      private serviceDomaine() {
         req = new ConnectionRequest();
    }

    public static serviceDomaine getInstance() {
        if (instance == null) {
            instance = new serviceDomaine();
        }
        return instance;
    }
    public String addImage( Image i){
         /*  String url = Statics.BASE_URL + "domaine/image";
            req.setPost(false);
         req.setUrl(url);
         req.addArgument("imageDomaine", i+"");
           System.out.println(url);
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return req.getResponseData().toString();*/
          String url = Statics.BASE_URL + "/domaine/mobile/Image?imageDomaine="
                +  i;
               
                   System.out.println(url);
                       System.out.println(url);
                   //String url = Statics.BASE_URL + "mobile/addPub?titre_publ=" + publication.getTitre() + "&description_publ=" + publication.getDescription() + "&image_publ=" + publication.getImage() + "&user=" + publication.getUser();
        req.setUrl(url);
        
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });
        System.out.println("*****************");
        System.out.println("*****************");
       // System.out.println(req.getResponseData().toString());
         try {
            img =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(req.getResponseData().toString().toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
               
                
                          
                img.add(obj.toString());
            }
            
            
        } catch (IOException ex) {
            
        }
        return img.get(0);

       
        
    }
       public void addDomaine(Domaine d) {
        System.out.println(d);
        System.out.println("********");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       /*String url = Statics.BASE_URL +"domaine/add";
    req.setPost(false);
       req.setUrl(url);
       
       req.addArgument("nomDomaine", d.getNomDomaine());
       req.addArgument("descriptionDomaine", d.getDescriptionDomaine());
         req.n(url);addArgument("imageDomaine", d.getImageDomaine()+"");
           System.out.println(url);*/
          String url = Statics.BASE_URL + "/domaine/mobile/addDomaine?nomDomaine="
                +  d.getNomDomaine()
                + "&descriptionDomaine=" + d.getDescriptionDomaine()
                + "&imageDomaine=" + d.getImageDomaine();
               
                   System.out.println(url);
                   //String url = Statics.BASE_URL + "mobile/addPub?titre_publ=" + publication.getTitre() + "&description_publ=" + publication.getDescription() + "&image_publ=" + publication.getImage() + "&user=" + publication.getUser();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        /*req.setUrl(url);
       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;*/
    }
           public ArrayList<Domaine> parseDomaines(String jsonText){
        try {
            domaines=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            System.out.println(tasksListJson);
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Domaine d = new Domaine();
                float id = Float.parseFloat(obj.get("id").toString());
                d.setId((int)id);
                d.setNomDomaine(obj.get("nomDomaine").toString()); 
                d.setDescriptionDomaine(obj.get("descriptionDomaine").toString());               
                d.setImageDomaine(obj.get("imageDomaine").toString());
                
                domaines.add(d);
            }
            
            
        } catch (IOException ex) {
            
        }
        return domaines;
    }
    
    public ArrayList<Domaine> getDomaines(){
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+ "/domaine/liste";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                domaines = parseDomaines(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return domaines;
    }
        public void editDom(Domaine d) {
        String url = Statics.BASE_URL + "/domaine/mobile/editDom?nomDomaine=" + d.getNomDomaine()+ "&descriptionDomaine=" + d.getDescriptionDomaine()+ "&id=" + d.getId()    + "&imageDomaine=" + d.getImageDomaine();
        req.setUrl(url);
          System.out.println(d);
        System.out.println("********");
        System.out.println(url);
        System.out.println(req.getResponseData().toString());
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }
        public boolean deleteDom(int id) {
        String url = Statics.BASE_URL + "/domaine/mobile/deleteDomaine?id=" + id;
           System.out.println(id);
           System.out.println(url);
        req.setUrl(url);
        req.setPost(false);
        req.setFailSilently(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultat = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultat;
    }
}
