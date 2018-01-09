package com.emrekp.herseybirapide.Model.NamazTimes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vakit {
    private String Gunes,Ogle,Ikindi,Aksam,Yatsi;

    @JsonProperty(value = "Gunes")
    public String getGunes() {
        return Gunes;
    }

    public void setGunes(String gunes) {
        Gunes = gunes;
    }

    @JsonProperty(value = "Ogle")
    public String getOgle() {
        return Ogle;
    }

    public void setOgle(String ogle) {
        Ogle = ogle;
    }

    @JsonProperty(value = "Ikindi")
    public String getIkindi() {
        return Ikindi;
    }

    public void setIkindi(String ikindi) {
        Ikindi = ikindi;
    }

    @JsonProperty(value = "Aksam")
    public String getAksam() {
        return Aksam;
    }

    public void setAksam(String aksam) {
        Aksam = aksam;
    }

    @JsonProperty(value = "Yatsi")
    public String getYatsi() {
        return Yatsi;
    }

    public void setYatsi(String yatsi) {
        Yatsi = yatsi;
    }
}
