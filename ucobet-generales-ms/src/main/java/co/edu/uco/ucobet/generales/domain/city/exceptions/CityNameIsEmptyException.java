package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityNameIsEmptyException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityNameIsEmptyException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityNameIsEmptyException create(){
        var userMessage = MessageHelper.getMessage("M0013");
        var technicalMessage = MessageHelper.getMessage("T009");
        return new CityNameIsEmptyException(userMessage, technicalMessage);
    }
}
