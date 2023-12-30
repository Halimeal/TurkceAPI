package get_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Get05 extends PetStoreBaseUrl {

    /*
     Given
    https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
    Kullanici URL'e ber GET request gonderir
    Then
    HTTP Status Code 200 olmali
    And
     Content type "application/Json"olmali
     And
     listede id degeri 137700 olan bir eleman olmali
     And
     Listede name degeri Karabas olan bir eleman olmali
     And
     Listede name degerleri "Karabas", "doggie", "fish" olan elemanlar olmali
     And
     Listede en az 200 tane eleman olmali
     And
     Listede 500;den az eleman olmali
     And
     Listenin ilk elemaninin category -id degeri 0 olmali
     And
     Listenin ilk elemaninin photoUrls degeri "String" olmali
     And
     Listenin in elemani tag -id 0 olmali


     */

    @Test

    public void get05(){

        //Set the Url

        spec.pathParams("first","pet","second","findByStatus")
                .queryParam("status","available");

        //Set the expected data

        //Send the request and get the response

        Response response= given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertion

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id",hasItem(137700))
                .body("name",hasItem("Karabas"))
                .body("name",hasItems("Karabas","doggie","fish"))
                .body("id",hasSize(greaterThan(200)))
                .body("id",hasSize(lessThan(500)))
                .body("[0].category.id",equalTo(0))
                .body("[0].photoUrls[0]",equalTo("string"))
                .body("[0].tags[0].id",equalTo(0));

    }
}
