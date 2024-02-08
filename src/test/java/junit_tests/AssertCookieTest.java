package junit_tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AssertCookieTest {

    @Test
    public void AssertCookieTest(){

        Response response =  RestAssured
                .given()
                .when()
                .get("https://playground.learnqa.ru/api/homework_cookie");

        String Cookies = String.valueOf(response.getCookies());
        String HomeWorkCookie = response.getCookie("HomeWork");

        assertTrue(Cookies.contains("HomeWork"), "Cookie 'HomeWork' doesn't exist");
        assertEquals("hw_value", HomeWorkCookie, "The value of 'HomeWork' Cookie doesn't equal to 'hw_value'");

    }
}