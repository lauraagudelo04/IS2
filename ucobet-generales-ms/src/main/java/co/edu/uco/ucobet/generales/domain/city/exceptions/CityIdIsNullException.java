package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityIdIsNullException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityIdIsNullException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityIdIsNullException create(){
        var userMessage = "City id no puede ser nulo";
        return new CityIdIsNullException(userMessage);
    }
}
