package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public class StateDoesNotExistsException extends RuleUcoBetException {
    private static final long serialVersionUID = 1L;

    private StateDoesNotExistsException(final String userMessage) {
        super(userMessage, userMessage, new Exception());
    }

    public static final StateDoesNotExistsException create(){
        var userMessage = "El estado no existe";
        return new StateDoesNotExistsException(userMessage);
    }
}
