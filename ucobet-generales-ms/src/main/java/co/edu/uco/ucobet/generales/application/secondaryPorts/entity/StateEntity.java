package co.edu.uco.ucobet.generales.application.secondaryPorts.entity;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.*;

import java.util.UUID;

//patron ORM, acceso a datos
@Entity
@Table(name = "State")
public final class StateEntity {
    @Id //primary key
    @Column(name="id")
    private UUID id;

    @Column(name="name") //Mapeo objeto relacional
    private String name;

    @ManyToOne
    @JoinColumn(name="country")
    private CountryEntity country;

    StateEntity() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setCountry(CountryEntity.create());
    }

    public StateEntity(final UUID id, final String name, final CountryEntity country) {
        setId(id);
        setName(name);
        setCountry(country);
    }

    static final StateEntity create() {
        return new StateEntity();
    }


    static final StateEntity create(final UUID id, final String name, final CountryEntity country) {
        return new StateEntity(id, name, country);
    }

    static final StateEntity create(final UUID id) {
        return new StateEntity(id, TextHelper.EMPTY, CountryEntity.create());
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

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(final CountryEntity country) {
        this.country = ObjectHelper.getDefault(country, CountryEntity.create());
    }

}
