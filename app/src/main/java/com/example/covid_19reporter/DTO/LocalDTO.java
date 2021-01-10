package com.example.covid_19reporter.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocalDTO {
    int len;
    @SerializedName("local_new_cases")
    private String local_new_cases;
    @SerializedName("local_active_cases")
    private String local_active_cases;
    @SerializedName("local_total_cases")
    private String local_total_cases;
    @SerializedName("local_deaths")
    private String local_deaths;
    @SerializedName("local_recovered")
    private String local_recovered;
    @SerializedName("local_total_number_of_individuals_in_hospitals")
    private String local_total_number_of_individuals_in_hospitals;
    @SerializedName("hospital_data")
    private List<HospitalsData> hospitalsData;

    public LocalDTO(String local_new_cases, String local_active_cases, String local_total_cases, String local_deaths, String local_recovered, String local_total_number_of_individuals_in_hospitals, List<HospitalsData> hospitalsData) {
        this.local_new_cases = local_new_cases;
        this.local_active_cases = local_active_cases;
        this.local_total_cases = local_total_cases;
        this.local_deaths = local_deaths;
        this.local_recovered = local_recovered;
        this.local_total_number_of_individuals_in_hospitals = local_total_number_of_individuals_in_hospitals;
        this.hospitalsData = hospitalsData;
    }

    public String getLocal_new_cases() {
        return local_new_cases;
    }

    public void setLocal_new_cases(String local_new_cases) {
        this.local_new_cases = local_new_cases;
    }

    public String getLocal_active_cases() {
        return local_active_cases;
    }

    public void setLocal_active_cases(String local_active_cases) {
        this.local_active_cases = local_active_cases;
    }

    public String getLocal_total_cases() {
        return local_total_cases;
    }

    public void setLocal_total_cases(String local_total_cases) {
        this.local_total_cases = local_total_cases;
    }

    public String getLocal_deaths() {
        return local_deaths;
    }

    public void setLocal_deaths(String local_deaths) {
        this.local_deaths = local_deaths;
    }

    public String getLocal_recovered() {
        return local_recovered;
    }

    public void setLocal_recovered(String local_recovered) {
        this.local_recovered = local_recovered;
    }

    public String getLocal_total_number_of_individuals_in_hospitals() {
        return local_total_number_of_individuals_in_hospitals;
    }

    public void setLocal_total_number_of_individuals_in_hospitals(String local_total_number_of_individuals_in_hospitals) {
        this.local_total_number_of_individuals_in_hospitals = local_total_number_of_individuals_in_hospitals;
    }

    public List<HospitalsData> getHospitalsData() {
        return hospitalsData;
    }

    public void setHospitalsData(List<HospitalsData> hospitalsData) {
        this.hospitalsData = hospitalsData;
    }
}
