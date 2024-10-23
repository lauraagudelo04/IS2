package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityNameIsEmptyException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityNameIsEmptyException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityNameIsEmptyException create(){
        var userMessage = "City name is empty";
        return new CityNameIsEmptyException(userMessage);
    }
}
