package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.redis.MessageHelper;

public class StateIdIsNullException extends RuleUcoBetException {
    private static final long serialVersionUID = 1L;

    private StateIdIsNullException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final StateIdIsNullException create(){
        var userMessage= MessageHelper.getMessage("M0019");
        var technicalMessage= MessageHelper.getMessage("T015");
        return new StateIdIsNullException(userMessage, technicalMessage);
    }
}
