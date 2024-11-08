package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.telemetryservice;

import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class TelemetryServiceImpl implements TelemetryService {

    private final TelemetryClient telemetryClient;

    public TelemetryServiceImpl(TelemetryClient telemetryClient) {
        this.telemetryClient = telemetryClient;
    }

    @Override
    public void trackEvent(String eventName, Map<String, String> properties) {
        if (eventName == null || eventName.trim().isEmpty()) {
            eventName = "DefaultEventName";
        }
        telemetryClient.trackEvent(eventName, properties, null);
    }

    @Override
    public void trackMetric(String metricName, double value) {
        telemetryClient.trackMetric(metricName, value);
    }

    @Override
    public void trackException(Exception exception) {
        telemetryClient.trackException(exception);
    }
}
