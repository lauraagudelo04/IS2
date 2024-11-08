package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class CityIdIsNullException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityIdIsNullException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityIdIsNullException create(){
        var userMessage = MessageHelper.getMessage("M0010");
        var technicalMessage = MessageHelper.getMessage("T006");
        return new CityIdIsNullException(userMessage, technicalMessage);
    }
}
