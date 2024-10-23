package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityIdRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityStateRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityRulesValidatorImpl implements RegisterNewCityRulesValidator {

    private RegisterNewCityNameRulesValidator cityNameRulesValidator;
    private RegisterNewCityIdRulesValidator cityIdRulesValidator;
    private RegisterNewCityStateRulesValidator cityStateRulesValidator;

    public RegisterNewCityRulesValidatorImpl(RegisterNewCityNameRulesValidator cityNameRulesValidator,
                                             RegisterNewCityIdRulesValidator cityIdRulesValidator,
                                             RegisterNewCityStateRulesValidator cityStateRulesValidator) {
        this.cityNameRulesValidator = cityNameRulesValidator;
        this.cityIdRulesValidator = cityIdRulesValidator;
        this.cityStateRulesValidator = cityStateRulesValidator;
    }

    @Override
    public void validate(final CityDomain data) {
        cityIdRulesValidator.validate(data);
        cityNameRulesValidator.validate(data);
        cityStateRulesValidator.validate(data.getState().getId());
    }
}
