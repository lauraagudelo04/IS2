package co.edu.uco.ucobet.generales.domain.country;

import co.edu.uco.ucobet.generales.domain.Domain;

import java.util.UUID;

public class CountryDomain extends Domain {
    private String name;

    protected CountryDomain(final UUID id, final String name) {
        super(id);
        setName(name);
    }

    public  String getName() {
        return name;
    }

    private  final void setName(String name) {
        this.name = name;
    }
}
