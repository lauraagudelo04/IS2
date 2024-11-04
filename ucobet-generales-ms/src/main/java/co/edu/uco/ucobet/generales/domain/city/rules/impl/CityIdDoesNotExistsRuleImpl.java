package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.city.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistsException;

import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIDoesNotExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CityIdDoesNotExistsRuleImpl implements CityIdIDoesNotExistsRule {

    private CityRepository cityRepository;

    public CityIdDoesNotExistsRuleImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(UUID data) {
        if (cityRepository.existsById(data)) {
            throw CityIdDoesExistsException.create();
        }
    }
}
