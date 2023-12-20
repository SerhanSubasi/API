package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

    /*
          Given
              https://restful-booker.herokuapp.com/booking/10
          When
              User sends a GET Request to the url
          Then
              HTTP Status Code should be 200
          And
              Content Type should be application/json
          And
              Status Line should be HTTP/1.1 200 OK
 */

    @Test
    public void get() {

        // i) Url kurulacak
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // ii) Beklenen data belirlenecek
        // iii) Request gönderilip Response alınacak
        Response response = given().when().get(url);
        response.prettyPrint();

        // iv) Doğrulamalar yapılacak
        // Assertion yapmaya "then()" methoduyla başlanır.  ÖNEMLİ <--------
        response.then().statusCode(200).
                contentType("application/json").
                statusLine("HTTP/1.1 200 OK");

    }
}
