package com.batteryshop.service;

import com.batteryshop.entity.FaultyProductEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface FaultyProductService {

    List<FaultyProductEntity> findAll();

    List<FaultyProductEntity> findAll(Sort sort);

    List<FaultyProductEntity> findAllById(Iterable<Integer> iterable);

    <S extends FaultyProductEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends FaultyProductEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<FaultyProductEntity> iterable);

    void deleteAllInBatch();

    FaultyProductEntity getOne(Integer integer);

    <S extends FaultyProductEntity> List<S> findAll(Example<S> example);

    <S extends FaultyProductEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<FaultyProductEntity> findAll(Pageable pageable);

    <S extends FaultyProductEntity> S save(S s);

    Optional<FaultyProductEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(FaultyProductEntity faultyProductEntity);

    void deleteAll(Iterable<? extends FaultyProductEntity> iterable);

    void deleteAll();

    <S extends FaultyProductEntity> Optional<S> findOne(Example<S> example);

    <S extends FaultyProductEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends FaultyProductEntity> long count(Example<S> example);

    <S extends FaultyProductEntity> boolean exists(Example<S> example);
}
