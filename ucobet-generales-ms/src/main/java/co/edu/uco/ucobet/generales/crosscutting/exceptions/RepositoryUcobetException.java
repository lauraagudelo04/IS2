package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;

public class RepositoryUcobetException extends UcoBetException{
    private static final long serialVersionUID = 1L;

    public RepositoryUcobetException(final String usserMessage,final String technicalMessage,
                               final Exception rootException) {
        super(usserMessage, technicalMessage, rootException, Layer.RULE);
    }

    public static final RuleUcoBetException create(final String usserMessage,final String technicalMessage,
                                                   final Exception rootException){
        return new RuleUcoBetException(usserMessage, technicalMessage, rootException);
    }

    public static final RuleUcoBetException create(final String usserMessage){
        return new RuleUcoBetException(usserMessage, usserMessage, new Exception());
    }

    public static final RuleUcoBetException create(final String usserMessage,final String technicalMessage){
        return new RuleUcoBetException(usserMessage, technicalMessage, new Exception());
    }
}
