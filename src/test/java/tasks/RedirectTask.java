package tasks;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class RedirectTask {

    @Test
    public void RedirectTask (){
    Response response = RestAssured
            .given()
            .redirects()
            .follow(false)
            .when()
            .get("https://playground.learnqa.ru/api/long_redirect")
            .andReturn();

    String Location = response.getHeader("Location");
    System.out.println(Location);
    }
}
