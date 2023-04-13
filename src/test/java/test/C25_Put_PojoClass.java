package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceHolderReqBodyPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseUrl {
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
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */
    @Test
    public void put01(){
        //1- Url ve body hazirla

    specJsonPlace.pathParams("pp1","posts","pp2",70);

        JsonPlaceHolderReqBodyPojo reqBody=new JsonPlaceHolderReqBodyPojo("Ahmet","Merhaba",10,70);
        System.out.println("reqBody: "+ reqBody);
        //2- Expected Data Hazirla

        JsonPlaceHolderReqBodyPojo expBody=new JsonPlaceHolderReqBodyPojo("Ahmet","Merhaba",10,70);

        //3 -Response kaydet

        Response response=given()
                                .spec(specJsonPlace)
                                .contentType(ContentType.JSON)
                                .when()
                                .body(reqBody).put("/{pp1}/{pp2}");

        response.prettyPeek();

        //4 -Assertion

       // JsonPath resJP=response.jsonPath();//onceki boyle yapıyorduk
      //  Map<String,Object> resMap=response.as(HashMap.class);//oncekilere boyle yapıyorduk

        JsonPlaceHolderReqBodyPojo resPojo=response.as(JsonPlaceHolderReqBodyPojo.class);//kendi olusturdugumuz kalıp

       assertEquals(expBody.getTitle(),resPojo.getTitle());
       assertEquals(expBody.getBody(),resPojo.getBody());
       assertEquals(expBody.getId(),resPojo.getId());
       assertEquals(expBody.getUserId(),resPojo.getUserId());







    }
}
