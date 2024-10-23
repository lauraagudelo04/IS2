package co.edu.uco.ucobet.generales.domain;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class Domain {
    private UUID id;
    private String idAsString;

    protected Domain(UUID id) {
        setId(id);
    }

    public final UUID getId() {
        //return UUIDHelper.isDefault(id)? UUIDHelper.convertToUUID(idAsString);
        return id;
    }

    private final void setId(final UUID id) {
        this.id = id;
    }

    public void generateId(){
        this.id = UUIDHelper.generate();
    }
}
