package co.edu.uco.ucobet.generales.application.primaryports.interactor.states.impl;

import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.application.primaryports.interactor.states.GetStatesInteractor;
import co.edu.uco.ucobet.generales.application.primaryports.mapper.StateDTOMapper;
import co.edu.uco.ucobet.generales.application.usecase.state.GetStates;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GetStatesInteractorImpl implements GetStatesInteractor {

    private  GetStates getStates;

    public GetStatesInteractorImpl(GetStates getStates) {
        this.getStates = getStates;
    }

    @Override
    public List<StateDTO> execute(StateDTO data) {
        var stateDomain= StateDTOMapper.INSTANCE.toDomain(data);
        var results=getStates.execute(stateDomain);
        return StateDTOMapper.INSTANCE.toDtoCollection(results);
    }
}
