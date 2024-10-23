package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public final class CityIdDoesExistsException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesExistsException(final String usserMessage) {
        super(usserMessage, usserMessage, new Exception());
    }

    public static final CityIdDoesExistsException create(){
        var usserMessage = "Ya existe la ciudad con el id indicado...";
        return new CityIdDoesExistsException(usserMessage);
    }
}
