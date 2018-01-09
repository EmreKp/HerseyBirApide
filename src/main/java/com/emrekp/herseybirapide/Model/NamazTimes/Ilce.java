package com.emrekp.herseybirapide.Model.NamazTimes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ilce {
    private String IlceAdi;
    private Integer IlceID;

    @JsonProperty(value = "IlceAdi")
    public String getIlceAdi() {
        return IlceAdi;
    }

    public void setIlceAdi(String ilceAdi) {
        IlceAdi = ilceAdi;
    }

    @JsonProperty(value = "IlceID")
    public Integer getIlceID() {
        return IlceID;
    }

    public void setIlceID(Integer ilceID) {
        IlceID = ilceID;
    }
}
