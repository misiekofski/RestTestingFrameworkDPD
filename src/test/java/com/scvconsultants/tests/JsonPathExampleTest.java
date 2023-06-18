package com.scvconsultants.tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;


public class JsonPathExampleTest {
    @Test
    public void someJsonPathsValidationTest() {
        RestAssured.get("https://api.github.com/users/misiekofski")
                .then()
                .statusCode(200)
                .assertThat()
                .body("public_repos", equalTo(105));
    }


    @Test
    public void otherTestExample() {
        String response = RestAssured.get("https://api.github.com/users/misiekofski")
                .print();
        System.out.println(response.contains("105"));
    }


    @Test
    public void anotherTestExample() {
        var response = RestAssured.get("https://api.github.com/users/misiekofski")
                .path("public_repos");
        System.out.println(response);
    }


    @Test
    public void showFirstRepo() {
        var response = RestAssured.get("https://api.github.com/users/misiekofski/repos")
                .path("[0].name");
        System.out.println(response);
    }

    @Test
    public void showAllRepos() {
        var response = RestAssured.get("https://api.github.com/users/misiekofski/repos")
                .path("name");
        System.out.println(response);
    }


    @Test
    public void showFirstOwnerOfRepo() {
        var response = RestAssured.get("https://api.github.com/users/misiekofski/repos")
                .path("[0].owner.url");
        System.out.println(response);
    }
}
