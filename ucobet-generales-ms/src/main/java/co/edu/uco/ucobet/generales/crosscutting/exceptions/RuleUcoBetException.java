package co.edu.uco.ucobet.generales.crosscutting.exceptions;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.enums.Layer;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;

import java.util.HashMap;
import java.util.Map;

public class RuleUcoBetException extends  UcoBetException{

    private static final long serialVersionUID = 1L;

    public RuleUcoBetException(final String userMessage,final String technicalMessage,
                               final Exception rootException) {
        super(userMessage, technicalMessage, rootException, Layer.RULE);
        registerInTelemetry(userMessage, technicalMessage);
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

    private void registerInTelemetry(String userMessage, String technicalMessage) {
        TelemetryService telemetryService = GlobalTelemetry.getTelemetryService();
        if (telemetryService != null) {

            telemetryService.trackException(this);

            Map<String, String> properties = new HashMap<>();
            properties.put(MessageHelper.getMessage("M0032"), userMessage);
            properties.put(MessageHelper.getMessage("M0033"), technicalMessage);
            telemetryService.trackEvent(MessageHelper.getMessage("M0034"), properties);
        }
    }
}
