package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ThinkingTesterBaseUrl {


        protected RequestSpecification spec;
        @Before
        public void setup(){

            spec = new RequestSpecBuilder()
                    .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                    .addHeader("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NThmNmEzZTViMjg0NTAwMTMxMjFlZjkiLCJpYXQiOjE3MDM4OTc2NjJ9.-78vQI7hRrz3e95G9gB0QKGe6ichJ5OEkORb3yExlTE")
                    .build();

        }
    }


