package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

public class StateDoesNotExistsException extends RuleUcoBetException {
    private static final long serialVersionUID = 1L;

    private StateDoesNotExistsException(final String userMessage, final String technicalMessage) {
        super(userMessage, technicalMessage, new Exception());
    }

    public static final StateDoesNotExistsException create(){
        var userMessage = MessageHelper.getMessage("M0017");
        var technicalMessage = MessageHelper.getMessage("T0013");
        return new StateDoesNotExistsException(userMessage, technicalMessage);
    }
}
