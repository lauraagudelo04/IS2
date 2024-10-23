package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityNameForStateDoesExistsException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityNameForStateDoesExistsException create(){
        var userMessage = "City name for state does not exists";
        return new CityNameForStateDoesExistsException(userMessage);
    }

}
