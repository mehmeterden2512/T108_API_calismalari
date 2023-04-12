package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testDataKlasoru.TestDataJsonPlaceHolder;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    @Test
    public void put01(){
        //1 - url hazırla ve body
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        HashMap<String, Object> reqBodyMap=testDataJsonPlaceHolder.reqBodyOlustur();

        //2 -Expected Data Hazirla
        HashMap<String, Object> expBodyMap=testDataJsonPlaceHolder.reqBodyOlustur();
        //3 -Response Kaydet

        Response response=given()
                .spec(specJsonPlace)
                        .contentType(ContentType.JSON)
                        .when()
                        .body(reqBodyMap)
                        .put("/{pp1}/{pp2}");

        response.prettyPeek();
        //4 Asssertion

      HashMap<String,Object> respMap=  response.as(HashMap.class);//Bu adimda De-Serialization işlemini gercekleştirdik.

       assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        assertEquals(expBodyMap.get("id"),respMap.get("id"));
        assertEquals(expBodyMap.get("userId"),respMap.get("userId"));
        assertEquals(expBodyMap.get("body"),respMap.get("body"));
        assertEquals(expBodyMap.get("title"),respMap.get("title"));




    }

}
