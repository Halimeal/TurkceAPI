package post_requests;

import baseUrl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post01  extends PetStoreBaseUrl {

    /*
    Given
    https://petstore.swagger.io/v2/pet
    And
    {
    "id": 137700,
    "category": {
        "id": 0,
        "name": "kopek"
    },
    "name": "Karabas",
    "photoUrls": [
        "string"
    ],
    "tags": [
        {
            "id": 0,
            "name": "kangal"
        }
    ],
    "status": "available"
}
When
Kullanici URL'e bir POST request gonderir
Then
HTTP Status Code 200 olmali
And
Content Type "application/json" olmali


     */

    @Test
    public void post01(){
        spec.pathParam("first","pet");

        //Set the expected data(payload)

String payload= " {\"id\":137700,\"category\":{\"id\":0,\"name\":\"kopek\"},\"name\":\"Karabas\",\"photoUrls\":[\"string\"],\"tags\":[{\"id\":0,\"name\":\"kangal\"}],\"status\":\"available\"}";

//Send the request and get the response
        Response response = given(spec).body(payload).when().post("{first}");
        response.prettyPrint();

        //Do assertions

        //

    }
}
