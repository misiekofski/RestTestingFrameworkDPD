package com.scvconsultants.configuration;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class LoggingDemo {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    @Test
    public void test() {
        RestAssured
                .given()
                .log().ifValidationFails()

                // OR
//                .log().headers()
//                .log().body()
                .when()
                .get(BASE_URL)
                .then()
                    .log().ifError()
                    .log().ifValidationFails()
                .statusCode(200);

    }
}
