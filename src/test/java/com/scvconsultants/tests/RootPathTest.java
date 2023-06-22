package com.scvconsultants.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class RootPathTest {
    public static final String BASE_URL = "https://api.github.com/";


    @Test
    public void complexBodyExample() {
        RestAssured.get(BASE_URL + "users/misiekofski")
                .then()
                .body("url", response -> containsString("misiekofski"))
                .body("url", response -> containsString(response.body().jsonPath().get("login")));
    }


    @Test
    public void nestedBodyValidation() {
        RestAssured.get(BASE_URL + "rate_limit")
                .then()
                .rootPath("resources.core")
                .body("limit", equalTo(60))
                .body("remaining", lessThanOrEqualTo(60))
                .body("reset", notNullValue())
                .rootPath("resources.search")
                .body("limit", equalTo(10))
                .body("remaining", lessThanOrEqualTo(10))
                .noRootPath()
                .body("resources.graphql.limit", is(0));
    }
}
