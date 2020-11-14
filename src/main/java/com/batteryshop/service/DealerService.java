package com.batteryshop.service;

import com.batteryshop.entity.DealerEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DealerService {
    List<DealerEntity> findAll();

    List<DealerEntity> findAll(Sort sort);

    List<DealerEntity> findAllById(Iterable<Integer> iterable);

    <S extends DealerEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends DealerEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<DealerEntity> iterable);

    void deleteAllInBatch();

    DealerEntity getOne(Integer integer);

    <S extends DealerEntity> List<S> findAll(Example<S> example);

    <S extends DealerEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<DealerEntity> findAll(Pageable pageable);

    <S extends DealerEntity> S save(S s);

    Optional<DealerEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(DealerEntity dealerEntity);

    void deleteAll(Iterable<? extends DealerEntity> iterable);

    void deleteAll();

    <S extends DealerEntity> Optional<S> findOne(Example<S> example);

    <S extends DealerEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends DealerEntity> long count(Example<S> example);

    <S extends DealerEntity> boolean exists(Example<S> example);
}
