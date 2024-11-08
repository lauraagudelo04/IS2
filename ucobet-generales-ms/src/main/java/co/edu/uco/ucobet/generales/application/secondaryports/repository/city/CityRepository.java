package co.edu.uco.ucobet.generales.application.secondaryports.repository.city;
import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.data.sql.repository.city.CityRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, UUID>, CityRepositoryCustom {
    //dependency injection
}
