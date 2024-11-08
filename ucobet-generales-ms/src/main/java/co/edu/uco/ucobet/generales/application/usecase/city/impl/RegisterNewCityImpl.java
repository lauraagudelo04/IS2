package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.city.CityRepository;
import co.edu.uco.ucobet.generales.application.secondaryports.service.keyvault.VaultService;
import co.edu.uco.ucobet.generales.application.secondaryports.service.notification.NotificationService;
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

    private static final String MESSAGE_CITY_NAME_KEY = "M0022";

    private final CityRepository cityRepository;
    private final RegisterNewCityRulesValidator registerNewCityRulesValidator;
    private final NotificationService notificationService;
    private final VaultService vaultService;


    public RegisterNewCityImpl(CityRepository cityRepository, RegisterNewCityRulesValidator registerNewCityRulesValidator,
                               NotificationService notificationService, VaultService vaultService) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
        this.notificationService = notificationService;
        this.vaultService = vaultService;
    }

    @Override
    public void execute(final CityDomain domain) {
        Map<String, String> startEventProps = new HashMap<>();
        startEventProps.put(MessageHelper.getMessage(MESSAGE_CITY_NAME_KEY), domain.getName());
        // Rules validation
        registerNewCityRulesValidator.validate(domain);

        Map<String, String> validationEventProps = new HashMap<>();
        validationEventProps.put(MessageHelper.getMessage(MESSAGE_CITY_NAME_KEY), domain.getName());

        // Data Mapper -> Domain -> Entity
        final var cityEntity= CityEntity.create().setId(domain.getId())
                .setName(domain.getName())
                .setState(StateEntityMapper.INSTANCE.toEntity(domain.getState()));

        // Save CityEntity
        cityRepository.save(cityEntity);

        Map<String, String> saveEventProps = new HashMap<>();
        saveEventProps.put(MessageHelper.getMessage(MESSAGE_CITY_NAME_KEY), cityEntity.getName());
        saveEventProps.put(MessageHelper.getMessage("M0025"), cityEntity.getId().toString());

        String subject = vaultService.getSecretValue("SUBJECT");
        String template = vaultService.getSecretValue("BODY");
        String cityName = domain.getName();
        String body = template.replace("${cityName}", cityName);
        String toEmail = vaultService.getSecretValue("TOEMAIL");

        EmailVO email = EmailVO.create(toEmail, subject, body);
        notificationService.sendEmail(email);

        Map<String, String> emailEventProps = new HashMap<>();
        emailEventProps.put(MessageHelper.getMessage(MESSAGE_CITY_NAME_KEY), cityName);
        emailEventProps.put(MessageHelper.getMessage("M0027"), toEmail);

        Map<String, String> endEventProps = new HashMap<>();
        endEventProps.put(MessageHelper.getMessage(MESSAGE_CITY_NAME_KEY), cityEntity.getName());
        endEventProps.put(MessageHelper.getMessage("M0029"), cityEntity.getId().toString());
    }
}
