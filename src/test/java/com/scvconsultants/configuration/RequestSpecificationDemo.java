package com.scvconsultants.configuration;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static com.scvconsultants.configuration.ConfigFactory.getDefaultConfig;

public class RequestSpecificationDemo {
    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void testUsingLocalRequestSpec() {
        RestAssured
                .given()
                .spec(getDefaultRequestSpec())
                .when()
                .get()
                .then()
                .statusCode(200);
    }

    public static RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setConfig(getDefaultConfig())
                .build();
    }
}
