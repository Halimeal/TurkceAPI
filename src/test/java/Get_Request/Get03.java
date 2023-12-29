package Get_Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Get03 {

     /*
    Given
    https://petstore.swagger.io/v2/pet/137700
    When
    Kullanici URL'e bir get request gonderir.
    Then
    HTTP Status code 200 olmali
    And
    Content Type "application/json" olmali
    And "Name" su degeri icermeli "Karabas"
    And
    Status degeri "available" olmali
    And
    "category" altindaki "name" degeri "Kopek" olmali
    And
   "tags" altindaki "name degeri "Kangal" olmali

     */

    @Test
    public void get03(){

        RestAssured.baseURI =   "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/137700";


        Response response = given().when().get();
        response.prettyPrint();

        response
                .then().statusCode(200)
                .contentType("application/json")
                .body("name", containsString("Karabas"))
                .body("status",equalTo("available"))
                .body("category.name", equalTo("kopek"))
                .body("tags[0].name",equalTo("kangal"));


    }

    @Test

    public void get03SoftAssertion(){


        RestAssured.baseURI =   "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/137700";


        Response response = given().when().get();
        response.prettyPrint();

        response
                .then().statusCode(200)
                .contentType("application/json")
                .body("name", containsString("Karabas"),
                "status",equalTo("available")
                ,"category.name", equalTo("kopek"),
                "tags[0].name",equalTo("kangal"));


    }

}
