package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C07_Get_BodyTekrarlardanKurtulma {
    /*
                https://restful-booker.herokuapp.com/booking/10 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Sally",
                    ve "lastname“in, "Wilson",
                    ve "totalprice“in, 716,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
                {
    "firstname": "Sally",
    "lastname": "Wilson",
    "totalprice": 716,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2017-09-25",
        "checkout": "2018-09-01"
    }
}
         */
    @Test
    public void get01(){
        //1-Request icin gerekli url hazirla
        String url="https://restful-booker.herokuapp.com/booking/10";
        //2 -Expected Data hazirla

        //3- Response 'i kaydet

        Response response=given().when().get(url);
        response.prettyPrint();
        //-Assertion
       /*response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Sally"),
                        "lastname",Matchers.equalTo("Wilson"),
                        "totalprice",Matchers.equalTo(716),
                        "depositpaid",Matchers.equalTo("true"),
                        "additionalneeds",Matchers.nullValue());

        */
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Sally"),
                        "lastname", equalTo("Wilson"),
                        "totalprice", equalTo(716),
                        "depositpaid", equalTo("true"),
                        "additionalneeds",nullValue());


    }
}
