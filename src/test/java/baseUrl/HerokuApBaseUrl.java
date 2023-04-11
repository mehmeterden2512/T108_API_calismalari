package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuApBaseUrl {
    protected RequestSpecification specHerokuApp;
    String url="https://restful-booker.herokuapp.com";
    @Before
    public void setup(){
        specHerokuApp= new RequestSpecBuilder().setBaseUri(url).build();
    }
}
