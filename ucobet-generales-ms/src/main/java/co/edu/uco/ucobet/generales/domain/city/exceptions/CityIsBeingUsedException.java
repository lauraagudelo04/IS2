package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityIsBeingUsedException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    public CityIsBeingUsedException(final String userMessage ) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityIsBeingUsedException create(){
        var userMessage = "City is already being used";
        return new CityIsBeingUsedException(userMessage);
    }
}
