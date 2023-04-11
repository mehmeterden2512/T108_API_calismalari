package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JSONObjectVerileriCagirma {
    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
    },
    "phoneNumbers": [
        {
            "type": "iPhone",
            "number": "0123-4567-8888"
        },
        {
            "type": "home",
            "number": "0123-4567-8910"
        }
    ]
}
     */
    @Test
    public void jsonPath01(){
        JSONObject cepTel=new JSONObject();
        cepTel.put("type","iPhone");
        cepTel.put("number","0123-4567-8888");
        JSONObject evTel=new JSONObject();
        evTel.put("type","home");
        evTel.put("number","0123-4567-8910");
        JSONArray phoneNumber=new JSONArray();
        phoneNumber.put(0,evTel);
        phoneNumber.put(1,cepTel);

        JSONObject adress=new JSONObject();
        adress.put("streetAddress","naist street");
        adress.put("city","Nara");
        adress.put("postalCode","630-0192");
        JSONObject kisiBilgisi=new JSONObject();
        kisiBilgisi.put("firstname","John");
        kisiBilgisi.put("","Doe");
        kisiBilgisi.put("age",26);
        kisiBilgisi.put("adress",adress);
        kisiBilgisi.put("phoneNumbers",phoneNumber);

        System.out.println("kisiBilgisi = "+kisiBilgisi);

        /*
        kisiBilgisi =
        {"firstname":"John",
        "adress":{"streetAddress":"naist street","city":"Nara","postalCode":"630-0192"},"age":26,"phoneNumbers":[{"number":"0123-4567-8910","type":"home"},{"number":"0123-4567-8888","type":"iPhone"}],"lastname":"Doe"}
         */
        System.out.println("isim: "+kisiBilgisi.get("firstname"));
        System.out.println("soyisim: "+kisiBilgisi.get("lastname"));
        System.out.println("yas: "+kisiBilgisi.get("age"));
        System.out.println("sokak adi: "+kisiBilgisi.getJSONObject("adress").get("city"));
        System.out.println("address/postalCode = " + kisiBilgisi.getJSONObject("address").get("postalCode"));

        System.out.println("Ev Tel No : "+kisiBilgisi
                                            .getJSONArray("phoneNumbers")
                                            .getJSONObject(1)
                                            .get("number"));
        System.out.println("  Telefon türü : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(1)
                .get("type"));

        System.out.println("  Telefon türü : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(0)
                .get("type"));

        System.out.println("Tel No : " + kisiBilgisi
                .getJSONArray("phoneNumbers")
                .getJSONObject(1)
                .get("number"));


    }
}
