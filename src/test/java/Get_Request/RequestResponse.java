package Get_Request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    public static void main(String[] args) {

        String url= "https://petstore.swagger.io/v2/pet/137700 ";

        Response response= given().when().get(url);

        response.prettyPrint();

        //Status Kod nasil yazilir?

        System.out.println("response.statusCode() = " + response.statusCode());

        //Content Type Nasil Yazdirilir

        System.out.println("response.contentType() = " + response.contentType());

        // Status Line nasil yazdirilir

        System.out.println("response.statusLine() = " + response.statusLine());

        //Header bolumunden bir baslik nasil yazdirilir.

        System.out.println("response.header(\"Server\") = " + response.header("Server"));

        //Header bolumundekitum basliklar nasil yazdirilir

        System.out.println("response.headers() = " + response.headers());


    }
}
