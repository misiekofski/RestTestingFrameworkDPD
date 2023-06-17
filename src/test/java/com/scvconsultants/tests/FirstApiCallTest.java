package com.scvconsultants.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class FirstApiCallTest {
    @Test
    public void getFirstApiCall() {
        RestAssured
                .get("https://api.github.com/")
                .prettyPeek();
    }
}
