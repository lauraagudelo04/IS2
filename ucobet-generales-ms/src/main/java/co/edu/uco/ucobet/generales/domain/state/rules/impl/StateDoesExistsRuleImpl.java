package co.edu.uco.ucobet.generales.domain.state.rules.impl;

import co.edu.uco.ucobet.generales.application.secondaryports.repository.state.StateRepository;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateDoesNotExistsException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateDoesExistsRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateDoesExistsRuleImpl implements StateDoesExistsRule {

    private final StateRepository stateRepository;

    public StateDoesExistsRuleImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public void validate(UUID data) {
       if(!stateRepository.existsById(data)) {
           throw StateDoesNotExistsException.create();
        }
    }
}
