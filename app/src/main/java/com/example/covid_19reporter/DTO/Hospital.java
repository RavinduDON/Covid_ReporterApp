package com.example.covid_19reporter.DTO;

import com.google.gson.annotations.SerializedName;

public class Hospital {

    private String id;

    private String name;

    public Hospital(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
