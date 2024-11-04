package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import co.edu.uco.ucobet.generales.application.primaryports.dto.StateDTO;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(componentModel = "spring")
public interface StateDTOMapper {

    StateDTOMapper INSTANCE = Mappers.getMapper(StateDTOMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "country", target = "country")
    StateDomain toDomain(StateDTO dto);

    // Método de mapeo adicional
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "country", target = "country")
    StateDTO toDto(StateDomain stateDomain);

    List<StateDTO> toDtoCollection(List<StateDomain> domains);

}