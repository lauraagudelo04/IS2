package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public class CityNameLenghtIsNotValidlException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityNameLenghtIsNotValidlException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final CityNameLenghtIsNotValidlException create(){
        var userMessage = "City name lenght is not valid";
        return new CityNameLenghtIsNotValidlException(userMessage);
    }
}
