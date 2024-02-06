import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class LongRedirectTest {
    @Test
    public void RedirectTest() {
        Response response;
        String location = "https://playground.learnqa.ru/api/long_redirect";

        do {
            response = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(location)
                    .andReturn();

            int statusCode = response.getStatusCode();
            location = response.getHeader("Location");
            if (location != null) {
                System.out.println(location);
            }
        } while (response.getStatusCode() != 200);
    }
}