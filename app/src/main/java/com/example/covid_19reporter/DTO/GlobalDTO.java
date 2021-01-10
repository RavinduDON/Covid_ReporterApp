package com.example.covid_19reporter.DTO;

import com.google.gson.annotations.SerializedName;

public class GlobalDTO {
    @SerializedName("global_new_cases")
    String global_new_cases;
    @SerializedName("global_total_cases")
    String global_total_cases;
    @SerializedName("global_deaths")
    String global_deaths;
    @SerializedName("global_new_deaths")
    String global_new_deaths;
    @SerializedName("global_recovered")
    String global_recovered;

    public GlobalDTO(String global_new_cases, String global_total_cases, String global_deaths, String global_new_deaths, String global_recovered) {
        this.global_new_cases = global_new_cases;
        this.global_total_cases = global_total_cases;
        this.global_deaths = global_deaths;
        this.global_new_deaths = global_new_deaths;
        this.global_recovered = global_recovered;
    }
}
