package baseUrl.test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
    @Test
    public void get01(){
        //1-Gonderecegimiz...
        //2-expected data hazirla
        //3-bize dönen response actual data olarak hazırla
        //4-expected ile actual data yi karşilaştirmamiz assertion
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);
        response.prettyPrint();//testi hazırlarken kullanmak gerek hazırlandıktan sonra yoruma almalı
        System.out.println("Status Code: "+response.getStatusCode());
        System.out.println("Content Type: "+response.getContentType());
        System.out.println("Server Header Degeri: "+response.getHeader("Server"));
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Response suresi: "+response.getTime());




    }
}
