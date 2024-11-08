package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.city.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.keyvault.VaultService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.notification.NotificationService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.telemetry.TelemetryService;
import co.edu.uco.ucobet.generales.application.secondaryports.vo.EmailVO;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.crosscutting.helpers.MessageHelper;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterNewCityImpl implements RegisterNewCity {

    private CityRepository cityRepository;
    private RegisterNewCityRulesValidator registerNewCityRulesValidator;
    private NotificationService notificationService;
    private VaultService vaultService;
    private TelemetryService telemetryService;

    public RegisterNewCityImpl(CityRepository cityRepository, RegisterNewCityRulesValidator registerNewCityRulesValidator,
                               NotificationService notificationService, VaultService vaultService, TelemetryService telemetryService) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
        this.notificationService = notificationService;
        this.vaultService = vaultService;
        this.telemetryService = telemetryService;
    }

    @Override
    public void execute(final CityDomain domain) {
        Map<String, String> startEventProps = new HashMap<>();
        startEventProps.put(MessageHelper.getMessage("M0022"), domain.getName());
        telemetryService.trackEvent(MessageHelper.getMessage("M0023"), startEventProps);
        // Rules validation
        registerNewCityRulesValidator.validate(domain);

        Map<String, String> validationEventProps = new HashMap<>();
        validationEventProps.put(MessageHelper.getMessage("M0022"), domain.getName());
        telemetryService.trackEvent(MessageHelper.getMessage("M0024"), validationEventProps);

        // Data Mapper -> Domain -> Entity
        final var cityEntity= CityEntity.create().setId(domain.getId())
                .setName(domain.getName())
                .setState(StateEntityMapper.INSTANCE.toEntity(domain.getState()));

        // Save CityEntity
        cityRepository.save(cityEntity);

        Map<String, String> saveEventProps = new HashMap<>();
        saveEventProps.put(MessageHelper.getMessage("M0025"), cityEntity.getId().toString());
        saveEventProps.put(MessageHelper.getMessage("M0022"), cityEntity.getName());
        telemetryService.trackEvent(MessageHelper.getMessage("M0026"), saveEventProps);

        String subject = vaultService.getSecretValue("SUBJECT");
        String template = vaultService.getSecretValue("BODY");
        String cityName = domain.getName();
        String body = template.replace("${cityName}", cityName);
        String toEmail = vaultService.getSecretValue("TOEMAIL");

        EmailVO email = EmailVO.create(toEmail, subject, body);
        notificationService.sendEmail(email);

        Map<String, String> emailEventProps = new HashMap<>();
        emailEventProps.put(MessageHelper.getMessage("M022"), cityName);
        emailEventProps.put(MessageHelper.getMessage("M0027"),
                vaultService.getSecretValue("TOEMAIL"));
        telemetryService.trackEvent(MessageHelper.getMessage("M048"), emailEventProps);


        Map<String, String> endEventProps = new HashMap<>();
        endEventProps.put(MessageHelper.getMessage("M0022"), cityEntity.getId().toString());
        endEventProps.put(MessageHelper.getMessage("M0022"), cityEntity.getName());
        telemetryService.trackEvent(MessageHelper.getMessage("M0029"), endEventProps);
        // Notificar al administrador sobre la creacion de la nueva ciudad
        //1. El correo del administrador esta en un lugar parametrizado (Parametres Building Block)
        //2. El asunto del correo esta en un lugar parametrizado
        //3: El cuerpo del correo esta en un lugar parametrizado
    }
}
