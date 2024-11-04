package co.edu.uco.ucobet.generales.crosscutting.exceptions;

import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;


public class SendGridUcoBetException extends UcoBetException{
    private static final long serialVersionUID = 1L;

    public SendGridUcoBetException(final String userMessage, final String technicalMessage,
                                   final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.GENERAL);
    }

    public static SendGridUcoBetException create (final String userMessage, final String technicalMessage,
                                                  final Exception rootException) {
        return new SendGridUcoBetException(userMessage, technicalMessage, rootException);
    }

    public static SendGridUcoBetException create (final String userMessage, final String technicalMessage){
        return new SendGridUcoBetException(userMessage, technicalMessage, new Exception());
    }

    public static SendGridUcoBetException create (final String userMessage){
        return new SendGridUcoBetException(userMessage, userMessage, new Exception());
    }
}

