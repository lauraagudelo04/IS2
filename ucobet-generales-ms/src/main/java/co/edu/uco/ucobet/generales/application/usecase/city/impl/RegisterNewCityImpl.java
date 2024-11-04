package co.edu.uco.ucobet.generales.application.usecase.city.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryports.mapper.StateEntityMapper;
import co.edu.uco.ucobet.generales.application.secondaryports.repository.city.CityRepository;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCityRulesValidator;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewCityImpl implements RegisterNewCity {

    private CityRepository cityRepository;
    private RegisterNewCityRulesValidator registerNewCityRulesValidator;

    public RegisterNewCityImpl(CityRepository cityRepository, RegisterNewCityRulesValidator registerNewCityRulesValidator) {
        this.cityRepository = cityRepository;
        this.registerNewCityRulesValidator = registerNewCityRulesValidator;
    }

    @Override
    public void execute(final CityDomain domain) {
        // Rules validation
        registerNewCityRulesValidator.validate(domain);

        // Data Mapper -> Domain -> Entity
        final var cityEntity= CityEntity.create().setId(domain.getId())
                .setName(domain.getName())
                .setState(StateEntityMapper.INSTANCE.toEntity(domain.getState()));

        // Save CityEntity
        cityRepository.save(cityEntity);

        // Notificar al administrador sobre la creacion de la nueva ciudad

        //1. El correo del administrador esta en un lugar parametrizado (Parametres Building Block)
        //2. El asunto del correo esta en un lugar parametrizado
        //3: El cuerpo del correo esta en un lugar parametrizado
    }
}
