package co.edu.uco.ucobet.generales.application.secondaryPorts.repository;

import co.edu.uco.ucobet.generales.application.secondaryPorts.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryPorts.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, UUID> {
    //dependency injection
}
