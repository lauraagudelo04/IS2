package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.exceptions.CityIdDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIDoesNotExistsRule;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCityIdRulesValidatorImpl implements RegisterNewCityIdRulesValidator {
    private CityIdIDoesNotExistsRule cityIdIDoesNotExistsRule;

    public RegisterNewCityIdRulesValidatorImpl(final CityIdIDoesNotExistsRule cityIdIDoesNotExistsRule) {
        this.cityIdIDoesNotExistsRule = cityIdIDoesNotExistsRule;
    }

    @Override
    public void validate(final CityDomain data) {
        data.generateId();
        try {
            cityIdIDoesNotExistsRule.validate(data.getId());
        }catch (final CityIdDoesNotExistsException exception){
            validate(data);
        }
    }
}
