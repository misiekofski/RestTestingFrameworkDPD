package com.scvconsultants.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String login;
    private int id;

    private int publicRepos;

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }

    public int getPublicRepos() {
        return publicRepos;
    }
}
