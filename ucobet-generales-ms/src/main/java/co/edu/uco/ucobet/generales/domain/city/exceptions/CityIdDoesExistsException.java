package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public final class CityIdDoesExistsException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityIdDoesExistsException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityIdDoesExistsException create(){
        var userMessage = MessageHelper.getMessage("M008");
        var technicalMessage = MessageHelper.getMessage("T004");
        return new CityIdDoesExistsException(userMessage,technicalMessage);
    }
}
