package co.edu.uco.ucobet.generales.application.primaryports.interactor.city;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.InteractorWithoutReturn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface RegisterNewCityInteractor extends InteractorWithoutReturn<RegisterNewCityDTO> {

}
