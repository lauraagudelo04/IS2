package co.edu.uco.ucobet.generales.application.secondaryports.repository.state;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.StateEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepositoryCustom {
    List<StateEntity> findByFilter(StateEntity filter);
}