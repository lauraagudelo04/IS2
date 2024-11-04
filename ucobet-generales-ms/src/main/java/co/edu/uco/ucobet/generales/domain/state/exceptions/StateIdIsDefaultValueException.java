package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageHelper;

public class StateIdIsDefaultValueException extends RuleUcoBetException {
    private static final long serialVersionUID = 1L;

    private StateIdIsDefaultValueException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final StateIdIsDefaultValueException create(){
        var userMessage = MessageHelper.getMessage("M0018");
        var technicalMessage = MessageHelper.getMessage("T0014");
        return new StateIdIsDefaultValueException(userMessage, technicalMessage);
    }
}
