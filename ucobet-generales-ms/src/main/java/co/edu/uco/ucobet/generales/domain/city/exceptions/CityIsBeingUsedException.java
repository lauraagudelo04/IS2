package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityIsBeingUsedException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityIsBeingUsedException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityIsBeingUsedException create(){
        var userMessage = MessageHelper.getMessage("M0011");
        var technicalMessage = MessageHelper.getMessage("T007");
        return new CityIsBeingUsedException(userMessage, technicalMessage);
    }
}
