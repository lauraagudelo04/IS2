package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityStateDoesNotExistsException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityStateDoesNotExistsException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityStateDoesNotExistsException create() {
        var userMessage = MessageHelper.getMessage("M0016");
        var technicalMessage = MessageHelper.getMessage("T0012");
        return new CityStateDoesNotExistsException(userMessage, technicalMessage);
    }
}