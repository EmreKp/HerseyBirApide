package com.emrekp.herseybirapide.Model.Weather;

import java.util.List;

public class Geolocation {
    private List<GeoResult> results;

    public List<GeoResult> getResults() {
        return results;
    }

    public void setResults(List<GeoResult> results) {
        this.results = results;
    }
}
