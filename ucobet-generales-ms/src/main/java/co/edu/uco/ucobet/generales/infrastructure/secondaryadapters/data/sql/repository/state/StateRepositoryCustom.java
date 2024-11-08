package co.edu.uco.ucobet.generales.infrastructure.secondaryadapters.data.sql.repository.state;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepositoryCustom {
    List<StateEntity> findByFilter(StateEntity filter);
}