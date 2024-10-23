package co.edu.uco.ucobet.generales.application.primaryports.interactor.city.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.city.RegisterNewCityInteractor;
import co.edu.uco.ucobet.generales.application.usecase.city.RegisterNewCity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegisterNewCityInteractorImpl implements RegisterNewCityInteractor {

    private RegisterNewCity registerNewCity;

    public RegisterNewCityInteractorImpl(RegisterNewCity registerNewCity) {
        super();
        this.registerNewCity = registerNewCity;
    }

    @Override
    public void execute(final RegisterNewCityDTO data) {
        //Data mapper -> DTO -> Domain
        final var cityDomain=new CityDomain(null,null,null);
        registerNewCity.execute(cityDomain);
    }
}
