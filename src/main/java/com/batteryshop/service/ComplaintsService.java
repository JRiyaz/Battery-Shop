package com.batteryshop.service;

import com.batteryshop.entity.ComplaintsEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ComplaintsService {
    List<ComplaintsEntity> findAll();

    List<ComplaintsEntity> findAll(Sort sort);

    List<ComplaintsEntity> findAllById(Iterable<Integer> iterable);

    <S extends ComplaintsEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends ComplaintsEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<ComplaintsEntity> iterable);

    void deleteAllInBatch();

    ComplaintsEntity getOne(Integer integer);

    <S extends ComplaintsEntity> List<S> findAll(Example<S> example);

    <S extends ComplaintsEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<ComplaintsEntity> findAll(Pageable pageable);

    <S extends ComplaintsEntity> S save(S s);

    Optional<ComplaintsEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(ComplaintsEntity complaintsEntity);

    void deleteAll(Iterable<? extends ComplaintsEntity> iterable);

    void deleteAll();

    <S extends ComplaintsEntity> Optional<S> findOne(Example<S> example);

    <S extends ComplaintsEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends ComplaintsEntity> long count(Example<S> example);

    <S extends ComplaintsEntity> boolean exists(Example<S> example);
}
