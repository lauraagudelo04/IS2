package co.edu.uco.ucobet.generales.domain;

import java.util.UUID;

public class Domain {
    private UUID id;

    protected Domain(UUID id) {
        setId(id);
    }

    public final UUID getId() {
        return id;
    }

    public final void setId(final UUID id) {
        this.id = id;
    }
}
