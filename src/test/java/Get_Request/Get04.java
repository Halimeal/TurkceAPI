package Get_Request;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get04 extends PetStoreBaseUrl {
    /*
    Given
    https://petstore.swagger.io/v2/pet/137700
    When
    Kullanici URL'e ber GET request gonderir
    Then
    HTTP Status Code 200 olmali
    And Content type "application/Json"olmali
     */


    @Test

    public void get04(){
        spec.pathParams("first", "pet", "second", 137700);

        //Set expected data

        //Send the request and get the response

        Response response= given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
