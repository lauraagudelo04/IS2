package co.edu.uco.ucobet.generales.application.secondaryports.entity;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

//patron ORM, acceso a datos
@Entity
@Table(name = "City")
public final class CityEntity {
    @Id //primary key
    @Column(name="id")
    private UUID id;

    @Column(name="name") //Mapeo objeto relacional
    private String name;

    @ManyToOne
    @JoinColumn(name="state")
    private StateEntity state;

    CityEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setState(StateEntity.create());
    }

    public CityEntity(UUID id, String name, StateEntity state) {
        setId(id);
        setName(name);
        setState(state);
    }

    static final CityEntity create() {
        return new CityEntity();
    }

    static final CityEntity create(final UUID id, final String name, final StateEntity state) {
        return new CityEntity(id, name, state);
    }

    static final CityEntity create(final UUID id) {
        return new CityEntity(id, TextHelper.EMPTY, StateEntity.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.applyTrim(name);
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(final StateEntity state) {
        this.state = ObjectHelper.getDefault(state, StateEntity.create());
    }
}
