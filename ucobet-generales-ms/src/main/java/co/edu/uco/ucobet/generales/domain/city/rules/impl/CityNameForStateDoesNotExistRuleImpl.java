package co.edu.uco.ucobet.generales.domain.city.rules.impl;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistRule;

public class CityNameForStateDoesNotExistRuleImpl implements CityNameForStateDoesNotExistRule {
    private CityRepository cityRepository;
    public CityNameForStateDoesNotExistRuleImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(CityDomain data) {
        if (!cityRepository.existsById(data.getId())) {
            //throw exception
        }
    }
}
