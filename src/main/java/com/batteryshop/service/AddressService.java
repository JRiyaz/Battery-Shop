package com.batteryshop.service;

import com.batteryshop.entity.AddressEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface AddressService {

    List<AddressEntity> findAll();

    List<AddressEntity> findAll(Sort sort);

    List<AddressEntity> findAllById(Iterable<Integer> iterable);

    <S extends AddressEntity> List<S> saveAll(Iterable<S> iterable);

    void flush();

    <S extends AddressEntity> S saveAndFlush(S s);

    void deleteInBatch(Iterable<AddressEntity> iterable);

    void deleteAllInBatch();

    AddressEntity getOne(Integer integer);

    <S extends AddressEntity> List<S> findAll(Example<S> example);

    <S extends AddressEntity> List<S> findAll(Example<S> example, Sort sort);

    Page<AddressEntity> findAll(Pageable pageable);

    <S extends AddressEntity> S save(S s);

    Optional<AddressEntity> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(AddressEntity addressEntity);

    void deleteAll(Iterable<? extends AddressEntity> iterable);

    void deleteAll();

    <S extends AddressEntity> Optional<S> findOne(Example<S> example);

    <S extends AddressEntity> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends AddressEntity> long count(Example<S> example);

    <S extends AddressEntity> boolean exists(Example<S> example);
}
