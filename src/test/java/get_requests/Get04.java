package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Get04 extends JsonPlaceHolderBaseUrl {

    @Test
    public void get() {

      // i) Url kurulacak
      // ii) Beklenen data belirlenecek
      // iii) Request gönderilip Response alınacak
        given(spec).when().get().prettyPrint();

      // iv) Doğrulamalar yapılacak

    }




}