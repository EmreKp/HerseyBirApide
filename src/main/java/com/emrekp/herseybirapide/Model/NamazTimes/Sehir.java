package com.emrekp.herseybirapide.Model.NamazTimes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sehir {
    private String SehirAdi;
    private Integer SehirID;

    @JsonProperty(value = "SehirAdi")
    public String getSehirAdi() {
        return SehirAdi;
    }

    public void setSehirAdi(String sehirAdi) {
        SehirAdi = sehirAdi;
    }

    @JsonProperty(value = "SehirID")
    public Integer getSehirID() {
        return SehirID;
    }

    public void setSehirID(Integer sehirID) {
        SehirID = sehirID;
    }
}
