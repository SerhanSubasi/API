import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {

    /*
    1) Manuel testler için Postman kullanacağız.
    2) Otomasyon testleri için Rest Assured Library kullanacağız.
    3) Test caseler yazılırken şu adımları takip edelim:
        i) önkoşullar iyi anlaşılmalı
        ii) Test case yazılırken Gherkin dilini kullanırız:
            Given: Önkoşullar ---> url, body ...
            When: Aksiyon --> get(), post(), put(), delete()...
            Then: Doğrulamalar
            And: Çoklu duurmları birbirine bağlamakta kullanılır.

    4) Otomasyon testi yazarken aşağıdaki adımları izleyebiliriz.
        i) Url kurulacak
        ii) Beklenen data belirlenecek
        iii) Request gönderilip Response alınacak
        iv) Doğrulamalar yapılacak

     */

    public static void main(String[] args) {
        String url = "https://petstore.swagger.io/v2/pet/619"; //her bir / arasına parametre deniliyor.

// Base Url: https://petstore.swagger.io/v2/pet/619
// 1. path parametresi:     /pet
// 2. path parametresi:     /619

     //ii) Beklenen data belirlenecek kısmı şimdilik atlanacak.
     //iii) Request gönderilip Response alınacak
        Response response = given().when().get(url);
        response.prettyPrint();     //pretty print ile yazdırılıyor.

        //Status code'a nasıl ulaşılır / yazdırılır:
        int statusCode = response.statusCode();
        System.out.println(statusCode);
        System.out.println("------------------------------------");

        //Status code line'ı nasıl ulaşılır / yazdırılır:
        System.out.println(response.statusLine());
        System.out.println("------------------------------------");

        //ContentType
        System.out.println(response.contentType());
        System.out.println("------------------------------------");


        //Header nasıl oluşturulur
        System.out.println(response.header("Server"));
        System.out.println(response.header("Date"));
        System.out.println("------------------------------------");

        //Bütün headerlar nasıl alınır:
        System.out.println(response.headers());
        System.out.println("------------------------------------");

        //Response süresini çağırma:
        System.out.println(response.time());
        System.out.println("------------------------------------");


    }


}
