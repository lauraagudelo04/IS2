package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageHelper;

public class CityNameLenghtIsNotValidlException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityNameLenghtIsNotValidlException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityNameLenghtIsNotValidlException create(){
        var userMessage = MessageHelper.getMessage("M0015");
        var technicalMessage = MessageHelper.getMessage("T0011");
        return new CityNameLenghtIsNotValidlException(userMessage, technicalMessage);
    }
}
