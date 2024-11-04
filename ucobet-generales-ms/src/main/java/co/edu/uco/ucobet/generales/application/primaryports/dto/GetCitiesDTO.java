package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

public final class GetCitiesDTO {
    private String cityName;
    private String stateName;

    public GetCitiesDTO(final String cityName,final String stateName) {
       setCityName(cityName);
       setStateName(stateName);
    }

    public static GetCitiesDTO create (final String cityName, final String stateName) {
        return new GetCitiesDTO(cityName, stateName);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(final String cityName) {
        this.cityName = TextHelper.applyTrim(cityName);
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(final String stateName) {
        this.stateName = TextHelper.applyTrim(stateName);
    }
}
