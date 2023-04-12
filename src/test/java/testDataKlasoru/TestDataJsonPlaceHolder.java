package testDataKlasoru;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataJsonPlaceHolder {
   public int basariliStatusCode=200;

    public JSONObject expectedBodyOlusturJsonObject(){
         /*
         {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
         */
        JSONObject expBody=new JSONObject();
        expBody.put("userId",3);
        expBody.put("id",22);
        expBody.put("title","dolor sint quo a velit explicabo quia nam");
        expBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        return expBody;
    }
    public HashMap reqBodyOlustur(){
        /*
         Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
         */
        HashMap<String,Object> reqBodyMap=new HashMap<>();
        reqBodyMap.put("title","Ahmet");
        reqBodyMap.put("body","Merhaba");
        reqBodyMap.put("userId",10.);
        reqBodyMap.put("id",70.0);

        return reqBodyMap;

    }
}
