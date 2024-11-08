package co.edu.uco.ucobet.generales.crosscutting.exceptions;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;


public class NotificationUcoBetException extends UcoBetException{
    private static final long serialVersionUID = 1L;

    public NotificationUcoBetException(final String userMessage, final String technicalMessage,
                                       final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.GENERAL);
    }

    public static NotificationUcoBetException create (final String userMessage, final String technicalMessage,
                                                      final Exception rootException) {
        return new NotificationUcoBetException(userMessage, technicalMessage, rootException);
    }

    public static NotificationUcoBetException create (final String userMessage, final String technicalMessage){
        return new NotificationUcoBetException(userMessage, technicalMessage, new Exception());
    }

    public static NotificationUcoBetException create (final String userMessage){
        return new NotificationUcoBetException(userMessage, userMessage, new Exception());
    }
}

