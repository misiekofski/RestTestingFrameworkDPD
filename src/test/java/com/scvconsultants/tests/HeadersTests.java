package com.scvconsultants.tests;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class HeadersTests {
    @Test
    public void getSpecificHeader() {
        Response response = RestAssured.get("api/url");

        String actualHeaderValue = response.getHeader("headerX");

        String actualContentType = response.getContentType();

        int statusCode = response.getStatusCode();

        Headers allheaders = response.getHeaders();

        ResponseBody<?> body = response.getBody();
        ResponseBody<?> body1 = response.body();

    }


    @Test
    public void getSpecificHeaderValidatableResponse() {
        RestAssured.get("api/url") // Response
                .then() // ValidatableResponse
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void getSpecificHeaderValidatableResponseMatchers() {
        RestAssured.get("api/url") // Response
                .then() // ValidatableResponse
                .statusCode(200)
                .statusCode(equalTo(200))
                .statusCode(lessThan(300))
                .header("x", containsStringIgnoringCase("blabla"));
    }

}
