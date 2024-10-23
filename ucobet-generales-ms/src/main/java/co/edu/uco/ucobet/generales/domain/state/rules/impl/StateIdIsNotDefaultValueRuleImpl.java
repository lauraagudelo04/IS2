package co.edu.uco.ucobet.generales.domain.state.rules.impl;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import co.edu.uco.ucobet.generales.domain.state.exceptions.StateIdIsDefaultValueException;
import co.edu.uco.ucobet.generales.domain.state.rules.StateIdIsNotDefaultValueRule;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StateIdIsNotDefaultValueRuleImpl implements StateIdIsNotDefaultValueRule {

    @Override
    public void validate(UUID data) {
        if (UUIDHelper.isDefault(data)){
            throw StateIdIsDefaultValueException.create();
        }
    }
}
