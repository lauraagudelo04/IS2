package co.edu.uco.ucobet.generales.infrastructure.secondaryAdapters.data.sql.repository;

import co.edu.uco.ucobet.generales.application.secondaryPorts.entity.CityEntity;
import co.edu.uco.ucobet.generales.application.secondaryPorts.repository.CityRepositoryCustom;
import co.edu.uco.ucobet.generales.crosscutting.exceptions.RepositoryUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class CityRepositoryCustomImpl implements CityRepositoryCustom {

    private EntityManager entityManager;

    public CityRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<CityEntity> findByFilter(final CityEntity filter) {
        try {
            var criteriaBuilder = entityManager.getCriteriaBuilder();
            var query = criteriaBuilder.createQuery(CityEntity.class);
            var result = query.from(CityEntity.class);
            var predicates = new ArrayList<>();
            if (!ObjectHelper.isNull(filter)){
                if (!UUIDHelper.isDefault(filter.getId())){
                    predicates.add(criteriaBuilder.equal(result.get("id"), filter.getId()));
                }
                if (!TextHelper.isEmpty(filter.getName())){
                    predicates.add(criteriaBuilder.equal(result.get("name"), filter.getName()));
                }
                if (!UUIDHelper.isDefault(filter.getState().getId())){
                    predicates.add(criteriaBuilder.equal(result.get("state"), filter.getId()));
                }
            }

            query.select(result).where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
            return entityManager.createQuery(query).getResultList();


        }catch (final Exception exception) {
            throw RepositoryUcobetException.create(null,null,exception);
        }
    }
}
