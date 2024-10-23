package co.edu.uco.ucobet.generales.application.secondaryports.mapper;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import co.edu.uco.ucobet.generales.domain.city.CityDomain;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityEntityMapper {

    CityEntityMapper INSTANCE = Mappers.getMapper(CityEntityMapper.class);

    CityEntity toEntity(CityDomain domain);

    CityDomain toDomain(CityEntity entity);

    List<CityEntity> toEntityCollection(List<CityDomain> domainCollection);

    List<CityDomain> toDomainCollection(List<CityEntity> entityCollection);

}