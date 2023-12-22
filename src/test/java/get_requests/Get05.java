package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get05 extends JsonPlaceHolderBaseUrl {

    @Test
    public void get() {
        /*
        Given
            https://jsonplaceholder.typicode.com/todos
        And
	        Accept type is "application/json"
        When
	 	    I send a GET request to the Url
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

        int expectedSize = 200;

        spec.pathParam("first","todos").accept(ContentType.JSON);

       Response response = given(spec).when().get("{first}");

       response.then().statusCode(200)
               .contentType(ContentType.JSON)
          //     .body("[2].title",equalTo("fugiat vaniam minus")); ----> Json list olarak dönen bir yapıda herhangi bir yapıda herhangi bir elemente index kullanarak ulaşabiliriz.
               .body("title",hasSize(expectedSize)
                       ,"title",hasItem("quis eius est sint explicabo")
                       ,"userId",hasItems(2,7,9));

        //hasSize() methodu list dönen yapının boyutunu döndürür.
        //hasItem() methodu listte verilen değerin olup olmadığını kontrol eder.
        //hasItems() methodu listte verilen çoklu değerlerin olup olmadığını kontrol eder.


    }


}
