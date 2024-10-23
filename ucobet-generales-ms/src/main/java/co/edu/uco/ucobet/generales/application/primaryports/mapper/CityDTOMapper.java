package co.edu.uco.ucobet.generales.application.primaryports.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityDTOMapper {
    CityDTOMapper INSTANCE = Mappers.getMapper(CityDTOMapper.class);


}
