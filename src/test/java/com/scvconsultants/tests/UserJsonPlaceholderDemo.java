package com.scvconsultants.tests;

import com.scvconsultants.jsonplaceholder.User;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;

public class UserJsonPlaceholderDemo {

    final static String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    @Test
    public void mapJsonPlaceholderUsers() {
        List<User> users = RestAssured.get(BASE_URL)
                .then()
                .extract()
                .jsonPath()
                .getList(".", User.class);

        System.out.println(users.get(0).getName());
    }
}
