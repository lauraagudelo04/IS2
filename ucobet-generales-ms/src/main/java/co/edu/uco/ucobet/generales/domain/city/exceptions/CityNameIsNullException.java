package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityNameIsNullException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityNameIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityNameIsNullException create(){
        var userMessage = "City name is null";
        return new CityNameIsNullException(userMessage);
    }
}
