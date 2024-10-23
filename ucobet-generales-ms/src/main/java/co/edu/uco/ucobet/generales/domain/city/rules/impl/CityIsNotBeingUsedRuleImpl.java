package co.edu.uco.ucobet.generales.domain.city.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIsBeingUsedException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIsNotBeingUsedRule;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CityIsNotBeingUsedRuleImpl implements CityIsNotBeingUsedRule {

    private CityRepository cityRepository;

    public CityIsNotBeingUsedRuleImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    @Override
    public void validate(UUID data) {
        if (cityRepository.isCityBeingUsed(data)){
            throw CityIsBeingUsedException.create();
        }
    }
}
