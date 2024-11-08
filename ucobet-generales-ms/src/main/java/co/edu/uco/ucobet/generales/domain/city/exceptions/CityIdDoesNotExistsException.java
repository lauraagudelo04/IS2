package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CityIdDoesNotExistsException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesNotExistsException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityIdDoesNotExistsException create(){
        var userMessage = MessageHelper.getMessage("M009");
        var technicalMessage = MessageHelper.getMessage("T005");
        return new CityIdDoesNotExistsException(userMessage,technicalMessage);
    }
}
