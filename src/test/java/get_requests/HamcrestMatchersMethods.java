package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestMatchersMethods extends JsonPlaceHolderBaseUrl {

    @Test
    public void methods() {
/*
   Temel Eşleştiriciler:

    is(değer):               Kontrol edilen nesne belirtilen değer ile eşleşiyorsa geçerlidir.
    equalTo(değer):          is(değer) ile aynıdır.
    not(değer):              Kontrol edilen nesne belirtilen değer ile eşleşmiyorsa geçerlidir.
    nullValue():             Kontrol edilen nesne null ise geçerlidir.
    notNullValue():          Kontrol edilen nesne null değilse geçerlidir.

    Mantıksal Eşleştiriciler:

    allOf(eşleştirici1, eşleştirici2, ...):  Belirtilen tüm eşleştiriciler eşleşiyorsa geçerlidir.
    anyOf(eşleştirici1, eşleştirici2, ...):  Belirtilen eşleştiricilerden herhangi biri eşleşiyorsa geçerlidir.
    not(eşleştirici):                         Belirtilen eşleştirici eşleşmiyorsa geçerlidir.

    Metin Eşleştiriciler:

    containsString(altDizi):          Kontrol edilen metin belirtilen alt dizeyi içeriyorsa geçerlidir.
    startsWith(önek):                 Kontrol edilen metin belirtilen önek ile başlıyorsa geçerlidir.
    endsWith(sonEk):                   Kontrol edilen metin belirtilen son ek ile bitiyorsa geçerlidir.

    Sayı Eşleştiriciler:

    closeTo(beklenen, delta):         Kontrol edilen değer, beklenen değere belirtilen delta içindeyse geçerlidir.
    greaterThan(değer), greaterThanOrEqualTo(değer): Kontrol edilen değer, belirtilen değerden büyük veya eşitse geçerlidir.
    lessThan(değer), lessThanOrEqualTo(değer):       Kontrol edilen değer, belirtilen değerden küçük veya eşitse geçerlidir.

    Koleksiyon Eşleştiriciler:

    hasItem(değer):                  Kontrol edilen iterable, belirtilen değere sahip en az bir öğe içeriyorsa geçerlidir.
    hasItems(değer1, değer2, ...):   Kontrol edilen iterable, her belirtilen değere sahip en az bir öğe içeriyorsa geçerlidir.
    hasSize(eşleştirici):            Koleksiyondaki eşleştiricilerin boyutunu kontrol eder.

    Nesne Eşleştiriciler:

    equalToIgnoringCase(dizi):       Kontrol edilen dizi, belirtilen dizi ile aynıysa geçerlidir (büyük-küçük harf duyarlı değil).
    sameInstance(beklenen):          Kontrol edilen nesne, belirtilen nesneyle aynı örneğe sahipse geçerlidir.
    hasProperty(mülkiyetAdı):       Kontrol edilen nesne, belirtilen isme sahip bir JavaBean özelliğine sahipse geçerlidir.

        Bunlar, genellikle kullanılan Hamcrest eşleştiricilerin ve yöntemlerin sadece bazılarıdır. Hamcrest, testlerinizde ifadeleri açıklayıcı ve okunabilir hale getirmenize olanak tanıyan zengin bir eşleştirici seti sunar.
 */


        //i) Set the Url
        spec.accept(ContentType.JSON).pathParams("first", "todos");

        //ii) Set the Expected Data
        //iii) Send Request And Get Response
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        //iv)  Do Assertions
        response.then()
                .statusCode(200)
                .body("[0].title",equalTo("delectus aut autem")
                        ,"[0].title",is("delectus aut autem")
                        ,"[0].title",not("Techpro ")
                        ,"[0].title",not(nullValue())
                        ,"[0].title",anyOf(equalTo("delectus aut autema"), isA(String.class))
                        ,"[0].title",containsString("aut")
                        ,"[0].title",startsWith("delectus"));




//           int actual = 42;
//           int expected = 42;

/// Both of these assertions are equivalent
//           assertThat(actual, is(expected));
//           assertThat(actual, equalTo(expected));


//           String actual1 = "Hello";
//           String unexpected = "World";

/// Assert that actual is not equal to "World"
//           assertThat(actual1, not(unexpected));

//           Object nullObject = null;
//           Object nonNullObject = new Object();

/// Assert that the object is null
//           assertThat(nullObject, nullValue());

/// Assert that the object is not null
//           assertThat(nonNullObject, notNullValue());


//           String actual4 = "Hello";

/// Assert that actual is either equal to "Hello" or is an integer
//           assertThat(actual4, anyOf(equalTo("Hello"), is(Integer.class)));

/// Assert that actual is not equal to 43
//           assertThat(actual, not(equalTo(43)));

//           String sentence = "This is a sentence.";

/// Assert that the sentence contains the word "is"
//           assertThat(sentence, containsString("is"));

/// Assert that the sentence starts with "This"
//           assertThat(sentence, startsWith("This"));

/// Assert that the sentence ends with "sentence."
//           assertThat(sentence, endsWith("sentence."));

//           String actualStr = "hello";
//           String expectedStr = "HELLO";

/// Assert that actual is equal to "HELLO" ignoring case
//           assertThat(actualStr, equalToIgnoringCase(expectedStr));


//           double actual3 = 3.0;
//           double expected3 = 3.2;
//           double delta = 0.3;

/// Assert that actual is close to 3.2 with a delta of 0.3
//           assertThat(actual3, closeTo(expected3, delta));

/// Assert that actual is greater than 4
//           assertThat(actual, greaterThan(41));

/// Assert that actual is greater than or equal to 5
//           assertThat(actual, greaterThanOrEqualTo(42));

/// Assert that actual is less than 6
//           assertThat(actual, lessThan(46));

/// Assert that actual is less than or equal to 5
//           assertThat(actual, lessThanOrEqualTo(45));

//           List<String> names = Arrays.asList("John", "Doe", "Jane");

/// Assert that the list has the item "Doe"
//           assertThat(names, hasItem("Doe"));

/// Assert that the list has both "John" and "Jane"
//           assertThat(names, hasItems("John", "Jane"));


//           class Person {
//               private String name;

//               public Person(String name) {
//                   this.name = name;
//               }

//               public String getName() {
//                   return name;
//               }
//           }

//           Person person = new Person("John");

/// Assert that the person object has a property named "name"
//           assertThat(person, hasProperty("name"));


    }

}