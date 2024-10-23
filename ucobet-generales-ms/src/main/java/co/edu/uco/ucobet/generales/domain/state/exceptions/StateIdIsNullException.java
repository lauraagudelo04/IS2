package co.edu.uco.ucobet.generales.domain.state.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.RuleUcoBetException;

public class StateIdIsNullException extends RuleUcoBetException {
    private static final long serialVersionUID = 1L;

    private StateIdIsNullException(final String usserMessage) {
        super(usserMessage,usserMessage, new Exception());
    }

    public static final StateIdIsNullException create(){
        var userMessage="El Id del estado no puede ser nulo.";
        return new StateIdIsNullException(userMessage);
    }
}
