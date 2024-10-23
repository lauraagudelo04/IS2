package co.edu.uco.ucobet.generales.domain.city.rules.impl;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.CityRepository;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityNameForStateDoesExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityNameForStateDoesNotExistRule;
import org.springframework.stereotype.Service;

@Service
public class CityNameForStateDoesNotExistRuleImpl implements CityNameForStateDoesNotExistRule {
    private CityRepository cityRepository;

    public CityNameForStateDoesNotExistRuleImpl(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void validate(CityDomain data) {
        if (!cityRepository.existsById(data.getId())) {
            throw CityNameForStateDoesExistsException.create();
        }
    }
}
