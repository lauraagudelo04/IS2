package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public final class CityIdDoesNotExistsException extends RuleUcoBetException {

    private CityIdDoesNotExistsException(final String usserMessage) {
        super(usserMessage, usserMessage, new Exception());
    }

    public static final CityIdDoesNotExistsException create(){
        var usserMessage = "No existe la ciudad con el id indicado...";
        return new CityIdDoesNotExistsException(usserMessage);
    }
}
