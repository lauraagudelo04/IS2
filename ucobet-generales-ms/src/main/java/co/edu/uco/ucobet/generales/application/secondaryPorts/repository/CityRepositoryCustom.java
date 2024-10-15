package co.edu.uco.ucobet.generales.application.secondaryPorts.repository;

import co.edu.uco.ucobet.generales.application.secondaryPorts.entity.CityEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CityRepositoryCustom {

    List<CityEntity> findByFilter(CityEntity filter);
}
