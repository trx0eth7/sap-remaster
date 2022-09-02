package com.company.sapremaster.repository.jpa;

import io.jmix.core.FetchPlan;
import io.jmix.core.repository.JmixDataRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Alexander Vasiliev
 */
@NoRepositoryBean
public interface JpaJmixDataRepository<T, ID> extends JmixDataRepository<T, ID> {

    @Override
    List<T> findAll(FetchPlan fetchPlan);

    @Override
    List<T> findAll(Iterable<ID> ids, @Nullable FetchPlan fetchPlan);

    @Override
    List<T> findAll(Sort sort, @Nullable FetchPlan fetchPlan);

    @Override
    List<T> findAll(Sort sort);

    @Override
    <S extends T> List<S> saveAll(Iterable<S> entities);
}
