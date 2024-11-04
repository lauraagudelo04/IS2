package co.edu.uco.ucobet.generales.application.usecase.city;

import co.edu.uco.ucobet.generales.application.usecase.UseCaseWithReturn;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;

import java.util.List;

public interface GetCities extends UseCaseWithReturn <Void, List<CityDomain>> {
}
