package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityNameForStateDoesExistsException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityNameForStateDoesExistsException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityNameForStateDoesExistsException create(){
        var userMessage = MessageHelper.getMessage("M003");
        var technicalMessage = MessageHelper.getMessage("T008");
        return new CityNameForStateDoesExistsException(userMessage, technicalMessage);
    }

}
