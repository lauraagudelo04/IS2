package co.edu.uco.ucobet.generales.application.usecase.city.impl;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityNameRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.city.rules.*;
import org.springframework.stereotype.Service;

@Service
public final class RegisterNewCityNameRulesValidatorImpl implements RegisterNewCityNameRulesValidator {

    private CityNameLenghtIsValidlRule cityNameLengthIsValidRule;
    private CityNameFormatIsValidRule cityNameFormatIsValidRule;
    private CityNameIsNotEmptyRule cityNameIsNotEmptyRule;
    private CityNameIsNotNullRule cityNameIsNotNullRule;
    private CityNameForStateDoesNotExistRule cityNameForStateDoesNotExistsRule;

    public RegisterNewCityNameRulesValidatorImpl(CityNameLenghtIsValidlRule cityNameLengthIsValidRule, CityNameFormatIsValidRule cityNameFormatIsValidRule, CityNameIsNotEmptyRule cityNameIsNotEmptyRule, CityNameIsNotNullRule cityNameIsNotNullRule, CityNameForStateDoesNotExistRule cityNameForStateDoesNotExistsRule) {
        this.cityNameLengthIsValidRule = cityNameLengthIsValidRule;
        this.cityNameFormatIsValidRule = cityNameFormatIsValidRule;
        this.cityNameIsNotEmptyRule = cityNameIsNotEmptyRule;
        this.cityNameIsNotNullRule = cityNameIsNotNullRule;
        this.cityNameForStateDoesNotExistsRule = cityNameForStateDoesNotExistsRule;
    }

    @Override
    public void validate(final CityDomain data) {
        cityNameIsNotNullRule.validate(data.getName());
        cityNameIsNotEmptyRule.validate(data.getName());
        cityNameFormatIsValidRule.validate(data.getName());
        cityNameLengthIsValidRule.validate(data.getName());
        cityNameForStateDoesNotExistsRule.validate(data);
    }
}