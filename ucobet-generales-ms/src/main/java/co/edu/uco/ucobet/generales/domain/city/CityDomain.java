package co.edu.uco.ucobet.generales.domain.city;

import co.edu.uco.ucobet.generales.domain.Domain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;

import java.util.UUID;

public class CityDomain extends Domain {
    private  String name;
    private  StateDomain state;

    public CityDomain(UUID id, String name, StateDomain state) {
        super(id);
        setName(name);
        setState(state);
    }

    public String getName() {
        return name;
    }

    private final void setName(final String name) {
        this.name = name;
    }

    public StateDomain getState() {
        return state;
    }

    private final void setState( final StateDomain state) {
        this.state = state;
    }
}
