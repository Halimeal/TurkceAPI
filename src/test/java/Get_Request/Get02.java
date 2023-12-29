package Get_Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class Get02 {
    /*
    Given
    https://petstore.swagger.io/v2/pet/0
    When
    Kullanici URL'e bir get request gonderir.
    Then
    HTTP Status code 404 olmali
    And
    Status Line "HTTP/1.1 404 Not Found" olmali
    And
    Response body "Pet not found" icermeli
    And
    Response body "TechProEd" icermemeli
    And
    Server degeri "Jetty(9.2.9.v20150224)" olmali

     */

    @Test
    public void Get(){

        //Set url
        RestAssured.baseURI =   "https://petstore.swagger.io/v2";
        RestAssured.basePath = "/pet/0";

        //Set the ecpected data

        /*
        Bu islem basamagini POST, PUT, gibi body gerektiren sorgularda ve
        get delete gibi response bekledigimiz datayi biliyorsak kullanabiliriz.
         */

        //3. Send the request and get the response

        Response response = given().when().get();
        response.prettyPrint();

        // 4. Do assertion

        response
                .then().statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Pet not found"))
                .body(not(containsString("TechProEd")))
                .header("Server","Jetty(9.2.9.v20150224)" );

    }
}
