/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entites.reclamation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author louay
 */
public class serviceReclamation {

    public static serviceReclamation instance = null;
    String json;
    private boolean resultat;

    private ConnectionRequest req;

    public static serviceReclamation getInstance() {
        if (instance == null) {
            instance = new serviceReclamation();
        }
        return instance;
    }

    public serviceReclamation() {
        req = new ConnectionRequest();
    }

    public void addReclamation(reclamation reclamation) {
        String url = Statics.BASE_URL + "reclamation/mobile/addReclamation?titre=" + reclamation.getTitre() + "&message=" + reclamation.getMessage() + "&type=" + reclamation.getType() + "&name=" + reclamation.getName() + "&email=" + reclamation.getEmail() + "&user_file=" + reclamation.getUser_file();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }

    public boolean deleteProduct(int id) {
        String url = Statics.BASE_URL + "reclamation/mobile/deleteReclamation?id=" + id;

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

    public void editReclamation(reclamation reclamation) {
        String url = Statics.BASE_URL + "reclamation/mobile/editReclamation?message=" + reclamation.getMessage() + "&user_file=" + reclamation.getUser_file() + "&id=" + reclamation.getId();
        req.setUrl(url);
        req.addResponseListener((e) -> {

            String str = new String(req.getResponseData());
            System.out.println("data == " + str);
        });

        NetworkManager.getInstance().addToQueueAndWait(req);
    }

    public ArrayList<reclamation> showReclamations() {
        ArrayList<reclamation> result = new ArrayList<>();

        String url = Statics.BASE_URL + "mobile/showReclamation";
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();

                try {
                    Map<String, Object> mapProducts = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));

                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapProducts.get("root");

                    for (Map<String, Object> obj : listOfMaps) {
                        reclamation pub = new reclamation();

                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());

                        String titre = obj.get("titre").toString();
                        String message = obj.get("message").toString();
                        String type = obj.get("type").toString();
                        String name = obj.get("name").toString();
                        String email = obj.get("email").toString();
                        String user_file = obj.get("userFile").toString();
                        String statusString = obj.get("status").toString();
                        String DateConverter = obj.get("sendingDate").toString().substring(obj.get("sendingDate").toString().indexOf("timestamp") + 10, obj.get("sendingDate").toString().lastIndexOf("}"));

                        Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);

                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        String dateString = formatter.format(currentTime);

                        int status = Integer.parseInt(statusString);

                        pub.setId((int) id);
                        pub.setTitre(titre);
                        pub.setMessage(message);
                        pub.setType(type);
                        pub.setName(name);
                        pub.setEmail(email);
                        pub.setUser_file(user_file);
                        pub.setStatus(status);
                        pub.setSending_date(dateString);

                        result.add(pub);

                    }

                } catch (Exception ex) {

                    ex.printStackTrace();
                }

            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;

    }

}
