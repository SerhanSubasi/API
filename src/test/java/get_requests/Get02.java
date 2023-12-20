package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

public class Get02 {
    @Test
    public void get() {
/*
       Given
           https://restful-booker.herokuapp.com/booking/0
       When
           User send a GET Request to the url
       Then
           HTTP Status code should be 404
       And
           Status Line should be HTTP/1.1 404 Not Found
       And
           Response body contains "Not Found"
       And
           Response body does not contain "TechProEd"
       And
           Server is "Cowboy"
 */

        String url = "https://restful-booker.herokuapp.com/booking/0";
        Response response = given().when().get(url);

        response.
                then().
                statusCode(404).
                statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Not Found"))
                .body(not(containsString("Not Found")));  //ters durumu için methodu parantez içine alıp not yazıyoruz.


        String responseStr = response.asString();

        Assert.assertTrue(responseStr.contains("Not Found"));

        Assert.assertFalse(responseStr.contains("Techproed"));

        String server = response.header("Server");
        Assert.assertEquals("Cowboy",server);


    }

}
