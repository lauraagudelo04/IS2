package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;


import java.util.UUID;

public final class CountryDTO{
    private UUID id;
    private String name;


    public CountryDTO(String name, UUID id) {
        setName(name);
        setId(id);
    }

    public CountryDTO() {
        setName(TextHelper.EMPTY);
        setId(UUIDHelper.getDefault());
    }

    public static CountryDTO create(String name, UUID id) {
      return new CountryDTO(name, id);
    }

    public static CountryDTO create() {
        return new CountryDTO();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = TextHelper.applyTrim(name);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getDefault(id,UUIDHelper.getDefault());
    }
}
