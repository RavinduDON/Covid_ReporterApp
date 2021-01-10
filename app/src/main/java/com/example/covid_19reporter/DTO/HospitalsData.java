package com.example.covid_19reporter.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HospitalsData {

    private String cumulative_local;

    private String cumulative_foreign;

    private String treatment_local;

    private String treatment_foreign;

    private Hospital hospital;

    public HospitalsData(String cumulative_local, String cumulative_foreign, String treatment_local, String treatment_foreign, Hospital hospital) {
        this.cumulative_local = cumulative_local;
        this.cumulative_foreign = cumulative_foreign;
        this.treatment_local = treatment_local;
        this.treatment_foreign = treatment_foreign;
        this.hospital = hospital;
    }

    public String getCumulative_local() {
        return cumulative_local;
    }

    public void setCumulative_local(String cumulative_local) {
        this.cumulative_local = cumulative_local;
    }

    public String getCumulative_foreign() {
        return cumulative_foreign;
    }

    public void setCumulative_foreign(String cumulative_foreign) {
        this.cumulative_foreign = cumulative_foreign;
    }

    public String getTreatment_local() {
        return treatment_local;
    }

    public void setTreatment_local(String treatment_local) {
        this.treatment_local = treatment_local;
    }

    public String getTreatment_foreign() {
        return treatment_foreign;
    }

    public void setTreatment_foreign(String treatment_foreign) {
        this.treatment_foreign = treatment_foreign;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
