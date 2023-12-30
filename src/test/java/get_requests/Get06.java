package get_requests;

import baseUrl.ThinkingTesterBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get06 extends ThinkingTesterBaseUrl {
    /*
    Given
    https://thinking-tester-contact-list.herokuapp.com/contacts
    When
    KUllanici URL ye bir get gonderir
    Then
    HTTP Status Code 200 olmali
    And
    Content Type "application/json" olmali
     */

    @Test
    public void get06(){
        //Set URL
        spec.pathParam("first", "contacts");
        //Set the expected data

        //Send the request and the get response

       Response response=  given(spec).when().get("{first}");
       response.prettyPrint();
    }
}
