package co.edu.uco.ucobet.generales.crosscutting.exceptions;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

public class RuleUcoBetException extends  UcoBetException{

    private static final long serialVersionUID = 1L;

    public RuleUcoBetException(final String usserMessage,final String technicalMessage,
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
