package junit_tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertHeaderTest {

    @Test
    public void AssertHeaderTest(){

        Response response =  RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/api/homework_header");

        String Headers = String.valueOf(response.getHeaders());
        String SecretHeader = response.getHeader("x-secret-homework-header");

        assertTrue(Headers.contains("x-secret-homework-header"), "Header 'x-secret-homework-header' doesn't exist");
        assertEquals("Some secret value", SecretHeader, "The value of 'x-secret-homework-header' doesn't equal to 'Some secret value'");

    }
}
