package co.edu.uco.ucobet.generales.domain.state;

import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.country.CountryDomain;

import java.util.UUID;

public class StateDomain extends Domain {
    private  String name;
    private CountryDomain country;

    public StateDomain(final UUID id, final String name, final CountryDomain country) {
        super(id);
        setName(name);
        setCountry(country);
    }

    public String getName() {
        return name;
    }

    private final void setName(final String name) {
        this.name = name;
    }

    public final CountryDomain getCountry() {
        return country;
    }

    private final void setCountry(final CountryDomain country) {
        this.country = country;
    }
}
