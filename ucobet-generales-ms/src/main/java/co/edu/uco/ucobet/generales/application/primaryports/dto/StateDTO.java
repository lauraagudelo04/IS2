package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class StateDTO {
    private UUID id;
    private String name;
    private CountryDTO country;

    public StateDTO(UUID id, String name, CountryDTO country) {
       setId(id);
       setName(name);
       setCountry(country);
    }

    public StateDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setCountry(CountryDTO.create());
    }

    public static StateDTO create(UUID id, String name, CountryDTO country) {
        return new StateDTO(id, name, country);
    }

    public static StateDTO create() {
        return new StateDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.applyTrim(name);
    }
}

