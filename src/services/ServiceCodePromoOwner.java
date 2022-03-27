/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
//import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
//import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entites.PromoCodeOwner;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.JSONParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
/**
 *
 * @author Mohamed
 */
public class ServiceCodePromoOwner {
     // public ArrayList<PromoCodeOwner> tasks;
    
    public static ServiceCodePromoOwner instance=null;
    public boolean resultOK;
    private ConnectionRequest req;
      public ArrayList<PromoCodeOwner> PromoCodeOwners;

    private ServiceCodePromoOwner() {
         req = new ConnectionRequest();
    }
 public static ServiceCodePromoOwner getInstance() {
        if (instance == null) {
            instance = new ServiceCodePromoOwner();
        }
        return instance;
    }
    //public static ServiceCodePromoOwner getInstance() {
    //    if (instance == null) {
    //        instance = new ServiceCodePromoOwner();
    //    }
    //    return instance;
    //}

    public void addCodePromoOwner(PromoCodeOwner t) {
       //System.out.println(t);
       // System.out.println("********");
       String url = Statics.BASE_URL + "/promocodeowner/mobile/addPromoCodeOwner?PCD_Name=" + t.getPCD_Name()+"&PCD_FirstName=" +t.getPCD_FirstName()+"&PCD_Job="+t.getPCD_Job()+"&PCD_Email="+t.getPCD_Email()+"&PCD_City="+t.getPCD_City()+"&PCD_Gender="+t.getPCD_Gender()+"&PCD_TelephoneNumber="+t.getPCD_TelephoneNumber()+"&PCD_Note="+t.getPCD_Note();
//ConnectionRequest req = new ConnectionRequest(url);        
//String url = Statics.BASE_URL + "create";
        System.out.println(url);

       req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
  //    req.addArgument("name", t.getPCD_FirstName());
    //  req.addArgument("status", t.getPCD_Name());
      // req.addResponseListener(new ActionListener<NetworkEvent>() 
      // {
       //     @Override
        //    public void actionPerformed(NetworkEvent evt) {
         //       resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
          //      req.removeResponseListener(this);
           // }
       // });
       // NetworkManager.getInstance().addToQueueAndWait(req);
        //return resultOK;
    }
   
       public ArrayList<PromoCodeOwner> parsePromoCodeOwner(String jsonText){
       try {
            PromoCodeOwners =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            System.out.println(tasksListJson);
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                PromoCodeOwner p = new PromoCodeOwner();
                float id = Float.parseFloat(obj.get("id").toString());                
                float numtel = Float.parseFloat(obj.get("PCD_TelephoneNumber").toString());

                p.setId((int)id);
                p.setPCD_City(obj.get("PCD_City").toString()); 
                p.setPCD_Email(obj.get("PCD_Email").toString());               
                p.setPCD_FirstName(obj.get("PCD_FirstName").toString());               
                p.setPCD_Gender(obj.get("PCD_Gender").toString());
                p.setPCD_Job(obj.get("PCD_Job").toString());
                p.setPCD_Name(obj.get("PCD_Name").toString());
                p.setPCD_Note(obj.get("PCD_Note").toString());
                p.setPCD_TelephoneNumber((int) numtel);
                

                
                PromoCodeOwners.add(p);
            }
            
            
        } catch (IOException ex) {
            
        }
        return PromoCodeOwners;
    }
    public ArrayList<PromoCodeOwner> getAllPromoCodeOwners(){
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL + "/promocodeowner/liste";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                PromoCodeOwners = parsePromoCodeOwner(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return PromoCodeOwners;
        
      
        
    }
     public boolean deletepromocodeowner(int id) {
        String url = Statics.BASE_URL + "/promocodeowner/mobile/deletePromoCodeOwner?id=" + id;
           System.out.println(id);
           System.out.println(url);
        req.setUrl(url);
        req.setPost(false);
        req.setFailSilently(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     public void editPromoCodeOwner(PromoCodeOwner t) {
        String url = Statics.BASE_URL + "/promocodeowner/mobile/editPromoCodeOwner?PCD_Name=" + t.getPCD_Name()+"&id=" + t.getId()+"&PCD_FirstName=" +t.getPCD_FirstName()+"&PCD_Job="+t.getPCD_Job()+"&PCD_Email="+t.getPCD_Email()+"&PCD_City="+t.getPCD_City()+"&PCD_Gender="+t.getPCD_Gender()+"&PCD_TelephoneNumber="+t.getPCD_TelephoneNumber()+"&PCD_Note="+t.getPCD_Note();;
        req.setUrl(url);
        System.out.println(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
}
