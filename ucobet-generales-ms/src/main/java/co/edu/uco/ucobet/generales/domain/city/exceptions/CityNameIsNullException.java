package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityNameIsNullException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityNameIsNullException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityNameIsNullException create(){
        var userMessage = MessageHelper.getMessage("M0014");
        var technicalMessage = MessageHelper.getMessage("T0010");
        return new CityNameIsNullException(userMessage, technicalMessage);
    }
}
