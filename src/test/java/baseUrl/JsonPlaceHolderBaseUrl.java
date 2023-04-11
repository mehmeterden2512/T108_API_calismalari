package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    //https://jsonplaceholder.typicode.com
   protected RequestSpecification specJsonPlace;

    @Before
    public void setUp(){
        String url="https://jsonplaceholder.typicode.com";
        specJsonPlace=new RequestSpecBuilder()
                            .setBaseUri(url)
                            .build();
    }



}
