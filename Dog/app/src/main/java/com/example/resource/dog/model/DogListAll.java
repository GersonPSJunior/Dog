package com.example.resource.dog.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class DogListAll {

    private String status;

    @JsonProperty("message")
    private HashMap<String, List<String>> message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, List<String>> getMessage() {
        return message;
    }

    public void setMessage(HashMap<String, List<String>> message) {
        this.message = message;
    }
}
