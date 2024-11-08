package co.edu.uco.ucobet.generales.application.secondaryports.repository.state;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.data.sql.repository.state.StateRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, UUID>, StateRepositoryCustom {
    //dependency injection
}
