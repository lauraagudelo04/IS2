package co.edu.uco.ucobet.generales.domain.city.rules.impl;
import co.edu.uco.ucobet.generales.application.secondaryPorts.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIDoesExistsRule;
import java.util.UUID;

public final class CityIdIDoesExistsRuleImpl implements CityIdIDoesExistsRule {

    private CityRepository cityRepository;

    public CityIdIDoesExistsRuleImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(final UUID data) {
        if (!cityRepository.existsById(data)){
            throw CityIdDoesNotExistsException.create();
        }
    }
}
