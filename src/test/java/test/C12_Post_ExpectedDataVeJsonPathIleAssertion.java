package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body-Expected Body************
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }


     */

    @Test
    public void post01(){
        //1- url ve body hazırla
        String url="https://restful-booker.herokuapp.com/booking";
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");
        JSONObject reqBody=new JSONObject();
        reqBody.put("firstname" , "Ahmet");
        reqBody.put("lastname" , "Bulut");
        reqBody.put("totalprice" , 500);
        reqBody.put("depositpaid" , false);
        reqBody.put("bookingdates" ,bookingdates);
        reqBody.put("additionalneeds" , "wi-fi");

        //2- Expected Data Hazirla
        /*
                    {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",z
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                      }
         */

        JSONObject expBody=new JSONObject();

        expBody.put( "bookingid",24);//testlerimizde bookingid test etmeyecez taslak olarak yapı hazırlıyorum
        expBody.put( "booking",reqBody);
        //3- Response kaydet
        Response response=given()
                                .contentType(ContentType.JSON)
                                .when()
                                .body(reqBody.toString())
                .post(url);
        response.prettyPrint();

        //4 - Assertion

        JsonPath respJS=response.jsonPath();

        assertEquals(expBody.getJSONObject("booking").get("firstname"),respJS.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),respJS.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),respJS.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),respJS.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),respJS.get("booking.additionalneeds"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                                                    respJS.get("booking.bookingdates.checkin") );
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                                                    respJS.get("booking.bookingdates.checkout") );


    }


}
