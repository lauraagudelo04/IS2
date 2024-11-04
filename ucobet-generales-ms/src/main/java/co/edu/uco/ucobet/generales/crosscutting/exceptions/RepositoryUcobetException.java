package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class RepositoryUcobetException extends UcoBetException{
    private static final long serialVersionUID = 1L;

    public RepositoryUcobetException(final String userMessage,final String technicalMessage,
                               final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.RULE);
    }

    public static final RuleUcoBetException create(final String userMessage,final String technicalMessage,
                                                   final Exception rootException){
        return new RuleUcoBetException(userMessage, technicalMessage, rootException);
    }

    public static final RuleUcoBetException create(final String userMessage){
        return new RuleUcoBetException(userMessage, userMessage, new Exception());
    }

    public static final RuleUcoBetException create(final String userMessage,final String technicalMessage){
        return new RuleUcoBetException(userMessage, technicalMessage, new Exception());
    }
}
