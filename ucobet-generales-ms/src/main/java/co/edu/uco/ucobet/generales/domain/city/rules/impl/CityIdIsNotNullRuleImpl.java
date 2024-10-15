package co.edu.uco.ucobet.generales.domain.city.rules.impl;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.domain.city.rules.CityIdIsNotNullRule;
import java.util.UUID;

public final class CityIdIsNotNullRuleImpl implements CityIdIsNotNullRule {

    @Override
    public void validate(final UUID data) {
        if (ObjectHelper.isNull(data)){
            //throw Exception
        }
    }
}
