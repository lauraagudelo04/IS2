package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import co.edu.uco.ucobet.generales.application.primaryports.dto.RegisterNewCityDTO;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import co.edu.uco.ucobet.generales.domain.state.StateDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = { UUID.class })

public interface CityDTOMapper {
    CityDTOMapper INSTANCE = Mappers.getMapper(CityDTOMapper.class);

    @Mapping(source = "city", target = "name")
    @Mapping(source = "stateId", target = "state", qualifiedByName = "mapToStateDomain")
    CityDomain toDomain(RegisterNewCityDTO dto);

    @Named("mapToStateDomain")
    default StateDomain mapToStateDomain(UUID stateId) {
        return new StateDomain(stateId, null, null);
    }

}
