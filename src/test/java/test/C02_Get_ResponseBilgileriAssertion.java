package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_Get_ResponseBilgileriAssertion {
    @Test
    public void get01() {
        //1-Gonderecegimiz...
        //2-expected data hazirla
        //3-bize dönen response actual data olarak hazırla
        //4-expected ile actual data yi karşilaştirmamiz assertion
        String url = "https://restful-booker.herokuapp.com/booking/10";
        Response response = given().when().get(url);
        //response.prettyPrint();
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","Cowboy").
                statusLine("HTTP/1.1 200 OK");

    }
}
