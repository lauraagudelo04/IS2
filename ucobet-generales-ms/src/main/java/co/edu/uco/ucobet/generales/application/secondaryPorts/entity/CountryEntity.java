package co.edu.uco.ucobet.generales.application.secondaryPorts.entity;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
//patron ORM, acceso a datos
@Entity
@Table(name = "Country")
public final class CountryEntity {

    @Id //primary key
    @Column(name="id")
    private UUID id;

    @Column(name="name") //Mapeo objeto relacional
    private String name;

    CountryEntity(){
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public CountryEntity(final UUID id,final String name) {
        setId(id);
        setName(name);
    }

    static final CountryEntity create(){
        return new CountryEntity();
    }

    public  static final CountryEntity create(final UUID id,final String name){
        return new CountryEntity(id,name);
    }

    public  static final CountryEntity create(final UUID id){
        return new CountryEntity(id,TextHelper.EMPTY);
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
}
