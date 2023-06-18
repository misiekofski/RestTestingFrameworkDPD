package com.scvconsultants.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class StatusCodeExamplesTest {
    @Test
    public void get200StatusCode() {
        Response response = RestAssured.get("https://api.github.com/users/misiekofski123");
        int statusCode = response.getStatusCode();

        assertEquals(statusCode, 200);
    }

    @Test
    public void get404StatusCode() {
        Response response = RestAssured.get("https://api.github.com/users/misiekofski123");
        int statusCode = response.getStatusCode();

        assertEquals(statusCode, 200);
    }

    @Test
    public void get404StatusCodeUsingWhenThen() {
        when()
            .get("https://api.github.com/users/misiekofski123")
        .then()
            .statusCode(200);
    }
}
