package get_requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Get04 {

    @Test
    public void get() {

      // i) Url kurulacak
        String url = "https://jsonplaceholder.typicode.com/todos/23";
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri(url).setContentType(ContentType.JSON).build();


      // ii) Beklenen data belirlenecek
      // iii) Request gönderilip Response alınacak
        given(spec).when().get().prettyPrint();

      // iv) Doğrulamalar yapılacak

    }




}