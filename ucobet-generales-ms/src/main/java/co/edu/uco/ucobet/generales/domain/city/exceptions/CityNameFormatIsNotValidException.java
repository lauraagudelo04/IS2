package co.edu.uco.ucobet.generales.domain.city.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageHelper;

public class CityNameFormatIsNotValidException extends RuleUcoBetException {

    private static final long serialVersionUID = 1L;

    private CityNameFormatIsNotValidException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final CityNameFormatIsNotValidException create(){
        var userMessage = MessageHelper.getMessage("M0012");
        var technicalMessage=MessageHelper.getMessage("T003");
        return new CityNameFormatIsNotValidException(userMessage,technicalMessage);
    }
}
